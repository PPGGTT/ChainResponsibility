package com.pgt.chainResponsibility.chainContainer;

import com.pgt.chainResponsibility.chain.AbstractChain;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ChainContainer {
    private Map<String,AbstractChain> chains = new HashMap<>();
}
