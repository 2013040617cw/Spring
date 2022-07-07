package com.cuiwei.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    private static Map<String,Object> iocmap = new HashMap<>();

    //程序启动时  初始化对象实例
    static {
        //1.读取配置文件(仅仅是加载)

        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");

        //对配置文件进行解析
        SAXReader saxReader = new SAXReader();
        try {

            Document document = saxReader.read(resourceAsStream);

            //3.编写一个xpath的表达式

            String xpath = "//bean";

            //4.获取到所有的bean标签

            List<Element> list = document.selectNodes(xpath);

            //5.遍历并使用反射创建对象的实例  ，存在Map集合中（ioc容器）

            for (Element element : list) {
                String id = element.attributeValue("id");

                //className的值就是IUserDaoImpl的全路径
                String className = element.attributeValue("class");

                //使用反射生成实例对象
                Object o = Class.forName(className).newInstance();

                //需要存到Map集合中
                iocmap.put(id, o);

            }
        } catch (Exception e) {
            e.printStackTrace();


        }
    }

    public static Object getBean(String beanId){
        Object o = iocmap.get(beanId);
        return o;
    }


}
