package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * <context:component-scan base-package="myspring.di.annot"/> 
 * ==> @ComponentScan(basePackages={"myspring.di.annot"})
 */
@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"})
public class HelloBeanConfig {

}
