/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: Swagger2Config
 * Author:   Administrator
 * Date:     2020/3/4 20:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/4
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    Docket docket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.select()
                //指定包下的类生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.fern.swagger2.controller"))
                //哪些接口需要被生成文档
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .description("接口文档的描述信息")
                        .title("微人事项目接口文档")
                        .contact(new Contact("fern","https:www.hi-fern.com","hufei1639670695@gmail.com"))
                        .version("v1.0")
                        .license("Apache2.0")
                        .licenseUrl("www.apache.com")
                        .build());
        return docket;
    }
}