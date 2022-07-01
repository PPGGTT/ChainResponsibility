package com.pgt.chainResponsibility.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TwoChain extends AbstractChain<String,Integer>{
    @Override
    public boolean canAbleToHandle(String s) {
        if (s.equals("b")){
            return true;
        }
        return false;
    }

    @Override
    public String Handler(String s, Integer integer) {
        JSONObject jsonObject = JSON.parseObject(s);
        Object a = jsonObject.get("b");
        jsonObject.put("b",(Integer)a+integer);
        String s1 = JSON.toJSONString(jsonObject);
        return s1;
    }
}
