/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: JpaConfigTwo
 * Author:   Administrator
 * Date:     2019/12/28 22:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jpa.jpademo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/28
 * @since 1.0.0
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.fern.jpa.jpademo.dao2",
    entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanTwo",
    transactionManagerRef = "platformTransactionManagerTwo")
public class JpaConfigTwo {
    @Autowired
    @Qualifier("dataSourceTwo")
    private DataSource dataSourceTwo;

    @Autowired
    private JpaProperties jpaProperties;


    @Bean
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanTwo(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceTwo)
                .properties(jpaProperties.getProperties())
                .persistenceUnit("persistenceUnitTwo")
                .packages("com.fern.jpa.jpademo.pojo")
                .build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerTwo(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(localContainerEntityManagerFactoryBeanTwo(builder).getObject());
    }
}