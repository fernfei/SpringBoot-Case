/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyBatisConfig
 * Author:   Administrator
 * Date:     2019/12/27 21:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hufei.mybatis.mybatisdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/27
 * @since 1.0.0
 */
@Configuration
@MapperScan(basePackages = "com.hufei.mybatis.mybatisdemo.mapper1",
        sqlSessionFactoryRef = "sqlSessionFactoryOne",
        sqlSessionTemplateRef = "sqlSessionTemplateOne")
public class MyBatisConfigOne {
    @Autowired
    @Qualifier("dataSourceOne")
    private DataSource dataSourceOne;

    @Bean
    SqlSessionFactory sqlSessionFactoryOne() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            sqlSessionFactoryBean.setDataSource(dataSourceOne);
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplateOne() {
        return new SqlSessionTemplate(sqlSessionFactoryOne());
    }
}