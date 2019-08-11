package com.linkpets.result;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

import org.springframework.core.MethodParameter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice(annotations = RestController.class)
public class ApiResultHandler implements ResponseBodyAdvice<Object> {
	
	private ThreadLocal<ObjectMapper> mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);

	@SuppressWarnings("rawtypes")
	private static final Class[] annos = { RequestMapping.class, GetMapping.class, PostMapping.class,
			DeleteMapping.class, PutMapping.class };

	/**
	 * 对所有RestController的接口方法进行拦截
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		AnnotatedElement element = returnType.getAnnotatedElement();
		return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
			Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		Object out;
		ObjectMapper mapper = mapperThreadLocal.get();
		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
		if (body instanceof ApiResult) {
			out = body;
		} else if (body instanceof ValidResult) {
			//校验信息
			out = body;
		} else if (body instanceof FileSystemResource) {
			//校验信息
			response.getHeaders().setContentType(MediaType.APPLICATION_PDF);
			out = body;
		} else if (body instanceof ApiResultCode) {
			ApiResultCode errorCode = (ApiResultCode) body;
			out = new ApiResult(errorCode.getCode(), errorCode.getMsg(), null);
		} else if (body instanceof String) {
			ApiResult result = ApiResult.valueOf(body);
			try {
				// 因为是String类型，我们要返回Json字符串，否则SpringBoot框架会转换出错
				out = mapper.writeValueAsString(result);
			} catch (JsonProcessingException e) {
				out = ApiResult.errorOf(ApiResultCode.JSON_PARSE_ERROR, e.getMessage());
			}
		} else {
			out = ApiResult.valueOf(body);
		}
		
		return out;
	}

}
