package com.linkpets.util;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.handler.GlobalExceptionHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zhumaer
 * @desc 请求参数、响应体统一日志打印
 * @since 10/10/2017 9:54 AM
 */
@Aspect
@Component
public class RestControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 环绕通知
     *
     * @param joinPoint 连接点
     * @return 切入点返回值
     * @throws Throwable 异常信息
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController) || @annotation(org.springframework.web.bind.annotation.RestController)")
    public Object apiLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("------------------------------------");

        boolean logFlag = this.needToLog(method);
        if (!logFlag) {
            return joinPoint.proceed();
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        // User loginUser =
        // LoginHelper.getLoginUserFromRequest(request);

        // String ip = IpUtil.getRealIp(request);
        String methodName = this.getMethodName(joinPoint);
        String params = this.getParamsJson(joinPoint);
        // String requester = loginUser == null ? "unknown" :
        // String.valueOf(loginUser.getId());

        // String callSource = request.getHeader(HeaderConstants.CALL_SOURCE);
        // String appVersion = request.getHeader(HeaderConstants.APP_VERSION);
        // String apiVersion = request.getHeader(HeaderConstants.API_VERSION);
        // String userAgent = request.getHeader("user-agent");

        String ip = "";
        String requester = "acc";

        String callSource = "";
        String appVersion = "appVersion";
        String apiVersion = "apiVersion";
        String userAgent = "userAgent";

        logger.info(
                "Started request requester [{}] method [{}] params [{}] IP [{}] callSource [{}] appVersion [{}] apiVersion [{}] userAgent [{}]",
                requester, methodName, params, ip, callSource, appVersion, apiVersion, userAgent);
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        logger.info("Ended request requester [{}] method [{}] params[{}] response is [{}] cost [{}] millis ", requester,
                methodName, params, this.deleteSensitiveContent(result), System.currentTimeMillis() - start);
        return result;
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        String SHORT_METHOD_NAME_SUFFIX = "(..)";
        if (methodName.endsWith(SHORT_METHOD_NAME_SUFFIX)) {
            methodName = methodName.substring(0, methodName.length() - SHORT_METHOD_NAME_SUFFIX.length());
        }
        return methodName;
    }

    private String getParamsJson(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            // 移除敏感内容
            String paramStr;
            if (arg instanceof HttpServletResponse) {
                paramStr = HttpServletResponse.class.getSimpleName();
            } else if (arg instanceof HttpServletRequest) {
                paramStr = HttpServletRequest.class.getSimpleName();
            } else if (arg instanceof MultipartFile) {
                long size = ((MultipartFile) arg).getSize();
                paramStr = MultipartFile.class.getSimpleName() + " size:" + size;
            } else {
                paramStr = this.deleteSensitiveContent(arg);
            }
            sb.append(paramStr).append(",");
        }
        if (sb.length() > 0) {
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return sb.toString();
        }

    }

    /**
     * 判断是否需要记录日志
     */
    private boolean needToLog(Method method) {
        return method.getAnnotation(GetMapping.class) == null
                && !method.getDeclaringClass().equals(GlobalExceptionHandler.class);
    }

    /**
     * 删除参数中的敏感内容
     *
     * @param obj 参数对象
     * @return 去除敏感内容后的参数对象
     */
    private String deleteSensitiveContent(Object obj) {
        JSONObject jsonObject = new JSONObject();
        if (obj == null || obj instanceof Exception) {
            return jsonObject.toJSONString();
        }

        /*
         * try { String param = JSON.toJSONString(obj); jsonObject =
         * JSONObject.parseObject(param); List<String> sensitiveFieldList =
         * this.getSensitiveFieldList(); for (String sensitiveField :
         * sensitiveFieldList) { if (jsonObject.containsKey(sensitiveField)) {
         * jsonObject.put(sensitiveField, "******"); } } } catch
         * (ClassCastException e) { return String.valueOf(obj); }
         */
        return jsonObject.toJSONString();
    }

    /**
     * 敏感字段列表（当然这里你可以更改为可配置的）
     */
    private List<String> getSensitiveFieldList() {
        List<String> sensitiveFieldList = new ArrayList<String>();
        sensitiveFieldList.add("pwd");
        sensitiveFieldList.add("password");
        return sensitiveFieldList;
    }
}