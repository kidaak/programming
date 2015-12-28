/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concert;

import org.springframework.stereotype.Component;

/**
 *
 * @author hoangnv
 */
@Component
public class PerformanceImpl implements Performance {

    @Override
    public void perform() {
        System.out.println("Performance is starting...");
    }

}
