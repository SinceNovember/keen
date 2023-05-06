package com.simple.keen.common.consts;

/**
 * 常量接口
 *
 * @author SinceNovember
 * @date 2022/11/19
 */
public interface Consts {

    int CONNECTION_TIMEOUT = 10000;

    int IDLE_TIMEOUT = 3000;

    int MAX_LIFETIME = 60000;

    int MAXIMUM_POOL_SIZE = 50;

    int MINIMUM_IDLE = 15;

    /**
     * 主数据源名称
     */
    String PRIMARY_DATASOURCE = "primaryDataSource";

    /**
     * 主sql会话工厂
     */
    String PRIMARY_SQL_SESSION_FACTORY = "primarySqlSessionFactory";

    /**
     * 主sql会话模板
     */
    String PRIMARY_SQL_SESSION_TEMPLATE = "primarySqlSessionTemplate";

    /**
     * 主要事务管理器
     */
    String PRIMARY_TRANSACTION_MANAGER = "primaryTransactionManager";

    String TYPE_HANDLER_PACKAGE = "com.simple.keen.converter";

    /**
     * 根节点值
     */
    Integer ROOT_PID = null;

    String CREATE_TIME_FIELD = "create_time";


}
