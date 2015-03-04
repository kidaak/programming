/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vogella.jersey.jaxb.dao;

import com.vogella.jersey.jaxb.model.Todo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hoangnv
 */
public enum TodoDao {

    instance;

    private final Map<String, Todo> contentProvider = new HashMap<>();

    private TodoDao() {
        Todo todo = new Todo("1", "Learn REST");
        todo.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
        contentProvider.put("1", todo);
        todo = new Todo("2", "Do something");
        todo.setDescription("Read complete http://www.vogella.com");
        contentProvider.put("2", todo);
    }

    public Map<String, Todo> getModel() {
        return contentProvider;
    }
}
