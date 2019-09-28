package com.envision.spring.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建bean对象的工程
 *
 * 创建service和dao对象
 * 1.配置文件
 *      配置的内容那个：唯一标识-全限定类名
 * 2.读取配置文件内容，反射创建对象
 *
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;

    //定义一个Map 用于存放我们要创建的对象 称之为 容器！
    private static Map<String, Object> beans;
    //使用静态代码块为properties对象赋值
    static {
        try{
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中的所有的Key
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()) {
               String key = keys.nextElement().toString();
               String path = props.getProperty(key);
               Object value = Class.forName(path).newInstance();
               beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean的名称获取对象 （单实例）
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {

        return beans.get(beanName);
    }


    /**
     * 根据bean名称获取bean对象
     * @param beanName
     * @return
     */
    /*
    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String benaPath = props.getProperty(beanName);
            bean = Class.forName(benaPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    */
}
