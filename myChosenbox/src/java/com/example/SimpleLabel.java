/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.sys.ContentRenderer;

/**
 *
 * @author hoangnv
 */
public class SimpleLabel extends HtmlBasedComponent{
    private String _value;

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        if(!_value.equals(value)){
            _value = value;
            smartUpdate("value", _value);
        }
    }

    @Override
    protected void renderProperties(ContentRenderer renderer) throws IOException {
        super.renderProperties(renderer);
        render(renderer, "value", _value);
    }
    
    
}
