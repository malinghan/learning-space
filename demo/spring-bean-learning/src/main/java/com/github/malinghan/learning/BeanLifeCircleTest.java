package com.github.malinghan.learning;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.stereotype.Component;


/**
 * 测试Spring Bean的生命周期
 * @author
 *
 */
@Component
public class BeanLifeCircleTest implements InitializingBean,DisposableBean
        ,BeanFactoryAware,BeanNameAware,ApplicationContextAware,EnvironmentAware,
         BeanClassLoaderAware,ApplicationEventPublisherAware,
       ResourceLoaderAware{
    private String name;
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("》》》调用BeanLifecycle对象"+this.getName()+"属性set方法，设值为:"+name);
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        System.out.println("》》》调用BeanLifecycle对象"+this.getSex()+"属性set方法，设值为:"+sex);
        this.sex = sex;
    }
    /**
     * 依次开始调用初始化回调方法
     */
    @PostConstruct
    public void initPostConstruct(){
        System.out.println("》》》注解初始化方法被调用");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("》》》BeanLifecycle调用了InitailizingBean的afterPorpertiesSet方法了.....");
    }

    //init-method
    public void init (){
        System.out.println("》》》init方法被调用");
    }

    /**
     * 依次开始调用销毁回调方法
     */

    @PreDestroy
    public void preDestroy(){
        System.out.println("》》》注解销毁方法被调用");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("》》》BeanLifecycle从Spring IoC容器中移除了.......");
    }

    //destory-method
    public void  close() {
        System.out.println("》》》close方法被调用");
    }

    @Override
    public void setApplicationContext(ApplicationContext paramApplicationContext)
            throws BeansException {
        System.out.print("》》》调用ApplicationContextAware接口setApplicationContext方法:");
        System.out.println(paramApplicationContext);

    }

    @Override
    public void setResourceLoader(ResourceLoader paramResourceLoader) {
        System.out.print("》》》调用ResourceLoaderAware接口setResourceLoader方法:");
        System.out.println(paramResourceLoader);
    }

//    @Override
//    public void setImportMetadata(AnnotationMetadata paramAnnotationMetadata) {
//        System.out.println(333333);
//    }

    @Override
    public void setEnvironment(Environment paramEnvironment) {
        System.out.print("》》》调用EnvironmentAware接口setEnvironment方法:");
        System.out.println(paramEnvironment);
    }

    @Override
    public void setBeanName(String paramString) {
        System.out.println("》》》调用BeanNameAware接口setBenaName方法: "+paramString);

    }

    @Override
    public void setBeanFactory(BeanFactory paramBeanFactory)
            throws BeansException {

        System.out.print("》》》调用BeanFactoryAware接口setBeanFactory方法:");
        System.out.println(paramBeanFactory);

    }

    @Override
    public void setBeanClassLoader(ClassLoader paramClassLoader) {
        System.out.print("》》》调用BeanClassLoaderAware接口setBeanClassLoader方法:");
        System.out.println(paramClassLoader);
    }

    @Override
    public void setApplicationEventPublisher(
            ApplicationEventPublisher paramApplicationEventPublisher) {
        System.out.print("》》》调用ApplicationEventPublisherAware接口setApplicationEventPublisher方法:");
        System.out.println(paramApplicationEventPublisher);
    }

    @Override
    public String toString() {
        return "BeanLifecycle [name=" + name + ", sex=" + sex + "]";
    }


}