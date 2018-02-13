package com.summers.registry;

import com.summers.integration.SpringIntegration;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SUMMERS on 2018/2/13.
 */
public class StrategyRegistry {

    private StrategyRegistry(){
    }

    private static HashMap<String,Map<String,Object>> registryMap = new HashMap<String, Map<String, Object>>();

    private static HashMap<String,Class> groupClassMap = new HashMap<String, Class>();

    public static void register(String group,String key,Class clazz,Object processor){
        Assert.notNull(group,"group不能爲空");
        Assert.notNull(key,"key不能爲空");
        clazz = clazz == null ? Object.class : clazz;
        if (registryMap.containsKey(group)){
            registryMap.get(group).put(key,processor);
            if (!Object.class.equals(clazz)){
                groupClassMap.put(group,clazz);
            }
        } else {
            synchronized (registryMap){
                if (registryMap.containsKey(group)){
                    registryMap.get(group).put(key,processor);
                } else {
                    HashMap<String, Object> processorMap = new HashMap<String, Object>();
                    registryMap.put(group, processorMap);
                    processorMap.put(key,processor);
                    groupClassMap.put(group,clazz);
                }
            }
        }

    }

    public static void register(String group,String key,Object processor){
        register(group,key,null,processor);
    }

    public static <T> T getProcessor(String group,String key){
        Assert.notNull(group,"group不能爲空");
        Assert.notNull(key,"key不能爲空");
        Class<T> aClass = groupClassMap.get(group);
        Map<String, Object> processorMap = registryMap.get(group);
        if (processorMap  == null){
            return null;
        } else {
            return aClass.cast(processorMap.get(key));
        }
    }

    public static void main(String[] args){
        register("test","test", SpringIntegration.class,new SpringIntegration());
        SpringIntegration processor = getProcessor("test", "test");
    }
}
