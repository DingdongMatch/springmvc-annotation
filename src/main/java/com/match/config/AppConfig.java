package com.match.config;

import com.match.controller.MyFirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

//SpringMVC只扫描Controller，子容器
//useDefaultFilters = false禁用默认过滤规则
@ComponentScan(value = "com.match", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    // 定制
    // 视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 默认所有的页面都从/WEB-INF/xxx.jsp
//        registry.jsp();
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // 静态资源访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
    }
}
