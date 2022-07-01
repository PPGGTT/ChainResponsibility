package com.pgt.chainResponsibility.processor;

import com.pgt.chainResponsibility.chain.AbstractChain;
import com.pgt.chainResponsibility.chainContainer.ChainContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class JsonProcessor {
    @Autowired
    private ChainContainer chainContainer;

    public String addValue(String json,String addKey,Integer addValue){
        Map<String, AbstractChain> chains = chainContainer.getChains();
        AbstractChain oneChain = getOneChain(chains);
        AbstractChain nowChain = null;

        if (oneChain.canAbleToHandle(addKey)){
            String handler = oneChain.Handler(json, addValue);
            return handler;
        }else {
            nowChain = oneChain;
            while (nowChain.hasNextChain()){
                nowChain = nowChain.getNextChain();
                if (nowChain.canAbleToHandle(addKey)){
                    String handler = nowChain.Handler(json, addValue);
                    return handler;
                }
            }
        }

        return json;
    }

    private AbstractChain getOneChain(Map<String, AbstractChain> chainMap){
        Set<Map.Entry<String, AbstractChain>> entries = chainMap.entrySet();
        AbstractChain abstractChain = null;
        for (Map.Entry<String,AbstractChain> entry : entries){
            abstractChain = entry.getValue();
            if (abstractChain != null){
                return abstractChain;
            }
        }
        return null;
    }
}
