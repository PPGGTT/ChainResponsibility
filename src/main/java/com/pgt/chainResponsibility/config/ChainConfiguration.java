package com.pgt.chainResponsibility.config;

import com.pgt.chainResponsibility.chain.AbstractChain;
import com.pgt.chainResponsibility.chain.OneChain;
import com.pgt.chainResponsibility.chain.ThreeChain;
import com.pgt.chainResponsibility.chain.TwoChain;
import com.pgt.chainResponsibility.chainContainer.ChainContainer;
import javafx.scene.input.KeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static javafx.scene.input.KeyCode.T;

@Configuration
public class ChainConfiguration {
    @Autowired
    private PropertiesConfig propertiesConfig;

    @Bean
    public ChainContainer chainContainer() throws ClassNotFoundException {
        ChainContainer chainContainer = new ChainContainer();
        HashMap<String, AbstractChain> map = new HashMap<>();
        Map<String, String> chainsName = propertiesConfig.getChainsName();
        Set<Map.Entry<String, String>> entries = chainsName.entrySet();
       for (Map.Entry<String,String> entry : entries){
           String nowChainName = entry.getKey();
           String nextChainName = entry.getValue();
           Object nowChain = StaticMethodGetBean.getBean(nowChainName);
           if(nowChain instanceof AbstractChain){
               if (testNotNull(nextChainName)){
                   Object nextChain = StaticMethodGetBean.getBean(nextChainName);
                   if (nextChain instanceof AbstractChain){
                       ((AbstractChain) nowChain).setNextChain((AbstractChain) nextChain);
                   }
               }
               map.put(nowChainName,(AbstractChain)nowChain);
           }
       }
       chainContainer.setChains(map);
        return chainContainer;
    }

    private boolean testNotNull(String chain){
        if (chain == null || chain.length()==0){
            return false;
        }
        if (chain.equals("null")){
            return false;
        }
        return true;
    }

}
