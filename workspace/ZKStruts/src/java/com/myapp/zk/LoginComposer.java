/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.zk;

import com.myapp.struts.LoginForm;
import java.util.Map;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Composer;

/**
 *
 * @author hoangnv
 */
public class LoginComposer implements Composer<Component> {

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        LoginForm formBean = (LoginForm) Executions.getCurrent().getAttribute("formBean");
        System.out.println(formBean);
    }

}
