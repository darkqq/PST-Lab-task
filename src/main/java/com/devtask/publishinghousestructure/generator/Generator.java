package com.devtask.publishinghousestructure.generator;

import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.entity.PublishingOffice;
import com.devtask.publishinghousestructure.entity.Worker;
import com.devtask.publishinghousestructure.entity.WorkerDetails;
import com.devtask.publishinghousestructure.generator.parser.JsonParser;
import com.sun.istack.Nullable;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.WildcardType;
import java.util.*;

@Component
public class Generator {


/*    private Map<String, String> urls;

    {
        urls = new HashMap<>();
        urls.put("com.devtask.publishinghousestructure.entity.Publication", "/companies.json");
        urls.put("com.devtask.publishinghousestructure.entity.PublishingOffice", "/books.json");
        urls.put("com.devtask.publishinghousestructure.entity.Worker", "/nicknames.json");
        urls.put("com.devtask.publishinghousestructure.entity.WorkerDetails", "/names-first.json");
    }


    *//*
       Method takes classname and number of elements
       in the result List as a parameters
       and returns List of an ready-to-save
       objects of className type.
     *//*

     *//* TEST METHOD; NEEDS REPLACEMENT *//*
    public List<? extends Object> getN(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        List<String> list = new JsonParser().parseData(urls.get(className));
        List<Object> resultList = new ArrayList<>();
        for (String data : list) {
            Object obj = Class.forName(className).newInstance();
            Method method = obj.getClass().getMethod("setName", String.class);
            method.invoke(obj, data);
            resultList.add(obj);
        }
        return resultList;
    }*/
}
