package com.pgt.chainResponsibility;

import com.pgt.chainResponsibility.chain.OneChain;
import com.pgt.chainResponsibility.config.PropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@SpringBootApplication
public class ChainResponsibilityApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(ChainResponsibilityApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String s : beanDefinitionNames){
            System.out.println(s);
        }


        Object oneChain = run.getBean("oneChain");
        OneChain oneChain1 = (OneChain) oneChain;
        System.out.println(oneChain1.hasNextChain());
    }

}
