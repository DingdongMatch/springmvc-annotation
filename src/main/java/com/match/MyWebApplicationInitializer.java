package com.match;

import com.match.config.AppConfig;
import com.match.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web容器启动的时候创建对象
 * 调用方法来初始化容器以及前端控制器
 * @author match fu
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 获取根容器的配置类（Spring的配置文件）父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    // 获取web容器的配置类（SpringMVC配置文件）子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    // 获取DispatcherServlet的映射信息
    // /：拦截所有请求（包括静态资源（xx.js，xx.png)），但不包括*.jsp
    // /*：拦截所有请求，连*.jsp页面都拦截；jsp页面是Tomcat的jsp引擎解析的
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
