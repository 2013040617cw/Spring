package com.cuiwei.dao.impl;

import com.cuiwei.dao.UserDao;
import com.cuiwei.domain.User;

import java.util.*;

public class UserDaoimpl  implements UserDao {

    private  String username;
    private  Integer age;
    private List<Object> list;
    private Set<Object> set;
    private  Object[] array;
    private Map<String,Object> map;
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void save() {
        System.out.println("List集合:" + list);
        System.out.println( "Set集合:" + set);
        System.out.println("object数组:" + Arrays.toString(array));
        System.out.println("Map集合：" + map);
        System.out.println("Properties：" + properties);
        System.out.println("dao被调用了");
    }

}
