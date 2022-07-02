package com.pgt.chainResponsibility;

import com.alibaba.fastjson.JSON;
import com.pgt.chainResponsibility.config.StaticMethodGetBean;
import com.pgt.chainResponsibility.processor.JsonProcessor;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChainResponsibilityApplicationTests {

    @Autowired
    private JsonProcessor jsonProcessor;
    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws JSONException {
        String s = "{\"a\":2,\"b\":3,\"c\":4}";
        String a = jsonProcessor.addValue(s, "d", 1);
        System.out.println(a);

    }

}
