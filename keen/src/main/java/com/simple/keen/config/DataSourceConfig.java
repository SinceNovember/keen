package com.simple.keen.config;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.simple.keen.common.consts.Consts;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 主数据源配置
 *
 * @author SinceNovember
 * @date 2022/11/19
 */
@Configuration(proxyBeanMethods = false)
@MapperScan(basePackages = "com.simple.keen.*.mapper", sqlSessionTemplateRef = Consts.PRIMARY_SQL_SESSION_TEMPLATE)
public class DataSourceConfig {

    /**
     * 主数据源
     *
     * @return 数据源
     */
    @Primary
    @Bean(name = Consts.PRIMARY_DATASOURCE)
    @ConfigurationProperties("spring.datasource")
    public DataSource primaryDataSource() {
        HikariDataSource dataSource = DataSourceBuilder.create()
            .type(HikariDataSource.class)
            .build();
        dataSource.setConnectionTimeout(Consts.CONNECTION_TIMEOUT);
        dataSource.setIdleTimeout(Consts.IDLE_TIMEOUT);
        dataSource.setMaxLifetime(Consts.MAX_LIFETIME);
        dataSource.setMaximumPoolSize(Consts.MAXIMUM_POOL_SIZE);
        dataSource.setMinimumIdle(Consts.MINIMUM_IDLE);
        return dataSource;
    }

    /**
     * 主sql会话工厂
     *
     * @param dataSource 数据源
     * @return 会话工厂
     */
    @Primary
    @Bean(name = Consts.PRIMARY_SQL_SESSION_FACTORY)
    public SqlSessionFactory primarySqlSessionFactory(
        @Qualifier(Consts.PRIMARY_DATASOURCE) DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        factory.setConfiguration(configuration);
        //枚举类型转换器包路径
        factory.setTypeHandlersPackage(Consts.TYPE_HANDLER_PACKAGE);
        return factory.getObject();
    }

    /**
     * 配置声明式事务管理器
     */
    @Primary
    @Bean(name = Consts.PRIMARY_TRANSACTION_MANAGER)
    public PlatformTransactionManager primaryTransactionManager(
        @Qualifier(Consts.PRIMARY_DATASOURCE) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = Consts.PRIMARY_SQL_SESSION_TEMPLATE)
    public SqlSessionTemplate primarySqlSessionTemplate(
        @Qualifier(Consts.PRIMARY_SQL_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
