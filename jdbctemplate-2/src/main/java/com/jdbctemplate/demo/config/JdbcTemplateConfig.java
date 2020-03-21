/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: JdbcTemplateConfig
 * Author:   Administrator
 * Date:     2019/12/26 19:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jdbctemplate.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/26
 * @since 1.0.0
 */
@Configuration
public class JdbcTemplateConfig {
    @Bean
    JdbcTemplate jdbcTemplateOne(@Qualifier("dsOne")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    JdbcTemplate jdbcTemplateTwo(@Qualifier("dsTwo")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}