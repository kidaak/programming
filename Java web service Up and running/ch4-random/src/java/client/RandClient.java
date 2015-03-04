/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;

/**
 *
 * @author hoangnv
 */
public class RandClient {

    public static void main(String[] args) {
        //set-up
        RandServiceService service = new RandServiceService();
        RandService port = service.getRandServicePort();
        //sample calls
        System.out.println(port.next1());
        System.out.println();
        List<Integer> nums = port.nextN(4);
        nums.stream().forEach((num) -> {
            System.out.println(num);
        });
    }
}
