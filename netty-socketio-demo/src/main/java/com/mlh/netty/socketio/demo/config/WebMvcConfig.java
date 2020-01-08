package com.mlh.netty.socketio.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : linghan.ma
 * @Package com.mlh.netty.socketio.demo.config
 * @Description:
 * @date Date : 2020年01月03日 11:19 AM
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 设置首页
     *
     * @param registry
     * @return void
     * @author wliduo[i@dolyw.com]
     * @date 2019/1/24 19:18
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/view.shtml");
        registry.addViewController("/doc/v1/").setViewName("index.html");
        registry.addViewController("/doc/v2/").setViewName("index.html");
        registry.addViewController("docs.html").setViewName("index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * 自定义静态资源过滤
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/doc/v1/**")
//                .addResourceLocations("classpath:/META-INF/resources/documentv1/");
//        registry.addResourceHandler("/doc/v2/**")
//                .addResourceLocations("classpath:/META-INF/resources/documentv2/");
    }

}
