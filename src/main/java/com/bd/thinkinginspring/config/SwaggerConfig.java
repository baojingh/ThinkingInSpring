package com.bd.thinkinginspring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: baojing.he
 * @Date: 2021-01-12 19:10
 * @Description:
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    private static Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);


    @Bean
    public Docket createRestApi() {

        LOGGER.info("swagger2 configures successfully");

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("com.bd.thinkinginspring.web API Doc")
                .description("This is a restful api document of Spring Boot.")
                .version("1.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }


}
