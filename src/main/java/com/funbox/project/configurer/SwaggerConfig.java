package com.funbox.project.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Sets.newHashSet;

/**
 * Swagger2SpringBoot 配置文件
 * 详情参考，http://springfox.github.io/springfox/docs/current/#springfox-samples
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    Docket UiApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(false)
                .groupName("front-ui-api")
                .useDefaultResponseMessages(false)
                .produces(newHashSet("application/json"))
                .genericModelSubstitutes(DeferredResult.class)
                .select().apis(RequestHandlerSelectors.basePackage("com.funbox.project.web")).build()
                .globalOperationParameters(globalOperationParameters(true))
                .globalResponseMessage(RequestMethod.GET, globalResponseMessage())
                .globalResponseMessage(RequestMethod.POST, globalResponseMessage())
                .apiInfo(UiApiInfo());
    }

    private ApiInfo UiApiInfo() {
        Contact contact = new Contact("funbox开发团队", "", "");
        return new ApiInfo(
                "funbox小程序以及app的API文档 - (前端UI篇)",
                "三全鲜食API文档</br>" +
                        "1、开发平台：<a href='http://das.dev.funbox.net' target='_top'>http://das.dev.funbox.net</a>" +
                        "</br>" +
                        "2、测试平台：<a href='http://das.qa.kashuo.net' target='_top'>http://das.qa.funbox.net</a>",
                "v1.0", null, contact, null, null);
    }

    /**
     * 全局请求头参数
     */
    private List<Parameter> globalOperationParameters(boolean needUserLogin) {
        List<Parameter> parameters = new ArrayList<Parameter>();
//        parameters.add(new ParameterBuilder().name("X-AUTH-TIME").description("请求时间戳").parameterType("header").modelRef(new ModelRef("string")).required(true).build());
//        parameters.add(new ParameterBuilder().name("X-Auth-Token").description("请求令牌").parameterType("header").modelRef(new ModelRef("string")).required(true).build());
//        parameters.add(new ParameterBuilder().name("X-AUTH-APPKEY").description("请求密钥").parameterType("header").modelRef(new ModelRef("string")).required(true).build());
//        if (needUserLogin)
//            parameters.add(new ParameterBuilder().name("X-USER-TOKEN").description("用户登录令牌").parameterType("header").modelRef(new ModelRef("string")).required(false).build());
        return parameters;
    }

    /**
     * 请求返回的HTTP全局状态码说明(非业务状态码)
     */
    private List<ResponseMessage> globalResponseMessage() {
        List<ResponseMessage> messageList = new ArrayList<ResponseMessage>();
        messageList.add(new ResponseMessageBuilder().code(400).message("请求无效").build());
        messageList.add(new ResponseMessageBuilder().code(403).message("资源不可用").build());
        messageList.add(new ResponseMessageBuilder().code(404).message("服务器未能找到相关信息").build());
        messageList.add(new ResponseMessageBuilder().code(500).message("系统内部错误").responseModel(new ModelRef("Error")).build());
        return messageList;
    }


    @Bean
    UiConfiguration uiConfig() {
        //validatorUrl, docExpansion, apiSorter, defaultModelRendering, String[] supportedSubmitMethods, enableJsonEditor, showRequestHeaders
        return new UiConfiguration(null, "none", "alpha", "model", UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, false);
    }

}
