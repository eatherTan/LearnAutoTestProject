package hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 生成Swagger接口文档的的配置代码
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    Environment env;

    @Bean
    public Docket createRestApi() {
        if(!"product".equals(env.getProperty("tcbase.environment"))) {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("hello"))
                    .paths(PathSelectors.any())
                    .build();
        }else {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo()).enable(false);
        }
        //return null;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Java TestNG 自动化平台项目接口文档")
                .description("鲸图创新项目接口文档")
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }

}
