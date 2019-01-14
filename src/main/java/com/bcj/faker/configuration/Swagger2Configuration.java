/**************************************
 * Copyright (C), Navinfo
 * Package: com.navinfo.sparkmanange
 * Author: wulongyue06158
 * Date: Created in 2018/12/20 17:16
 **************************************/
package com.bcj.faker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*************************************
 * Class Name: Swagger2
 * Description:〈swagger启动类〉
 * @author baochengjie
 * @create 2019/01/14
 * @since 1.0.0
 ************************************/
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.bcj.faker.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("faker 相关服务接口")
                //创建人
                .contact(new Contact(
                        "baochengjie", "http://localhost:8080/", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }


}