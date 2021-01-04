package com.bd.thinkinginspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

/**
 * @Author: baojing.he
 * @Date: 2021/1/4 21:40
 * @Description:
 */

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {
    //空间名称
    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    //表实体类包名
//    @Value("${spring.data.cassandra.entity-base-packages}")
//    private String entityBasePackages;

    //节点IP（连接的集群节点IP）
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    //端口
    @Value("${spring.data.cassandra.port}")
    private int port;

    //集群名称
    @Value("${spring.data.cassandra.cluster-name}")
    private String clusterName;


    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    public String getContactPoints() {
        return contactPoints;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getClusterName() {
        return clusterName;
    }

//    @Override
//    public String[] getEntityBasePackages() {
//        return new String[] { DeviceDataVo.class.getPackage().getName()};
//    }

}
