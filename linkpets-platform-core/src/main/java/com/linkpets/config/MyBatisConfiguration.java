//package com.linkpets.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// *
// * @author SteveYang
// * @date 2016/12/22
// */
//
//
//@Configuration
//public class MyBatisConfiguration {
//
//   private static final Logger log= LoggerFactory.getLogger(MyBatisConfiguration.class);
//
//    @Bean(value = "datasource")
//    public DataSource dataSource(){
//        HikariDataSource hikariDataSource=new HikariDataSource();
//        hikariDataSource.setJdbcUrl("jdbc:mysql://116.62.60.203:3306/pokedata_test?useSSL=false&autoReconnect=true");
//        hikariDataSource.setUsername("root");
//        hikariDataSource.setPassword("PokePet123456!");
//        hikariDataSource.setReadOnly(false);
//        hikariDataSource.setConnectionTimeout(30000);
//        hikariDataSource.setIdleTimeout(30000);
//        hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        hikariDataSource.setMinimumIdle(5);
//        hikariDataSource.setAutoCommit(true);
//
//        hikariDataSource.setConnectionTestQuery("SELECT 1");
//        hikariDataSource.setMaximumPoolSize(15);
//        hikariDataSource.setMaxLifetime(1800000);
//        hikariDataSource.setValidationTimeout(3000);
//        return hikariDataSource;
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.linkpets.*.dao,com.linkpetes.core.dao");
//        return mapperScannerConfigurer;
//    }
//
//
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory initSqlSessionFactoryBean() throws Exception {
//
//        SqlSessionFactoryBean sqlSessionFactoryBean= new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(this.dataSource());
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.linkpets.*.model,com.linkpets.core.model");
//
//        log.info("initialize SqlSessionFactoryBean  ..............");
//        ResourcePatternResolver resourceResolver=new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resourceResolver.getResources("classpath*:mapper/*.xml,classpath*:mapper/*/*.xml"));
//        return  sqlSessionFactoryBean.getObject();
//
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
//           return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//
//    @Bean
//    public DataSourceTransactionManager dataSourceTransactionManager(){
//        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(this.dataSource());
//        return dataSourceTransactionManager;
//    }
//
//}
