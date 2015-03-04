/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientAsync;

import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

/**
 *
 * @author hoangnv
 */
public class RandClientAsync {

    public static void main(String[] args) {
        RandServiceService service = new RandServiceService();
        RandService port = service.getRandServicePort();
        port.nextNAsync(4, new MyHandler());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        System.out.println("\n main is exiting...");
    }

    static class MyHandler implements AsyncHandler<NextNResponse> {

        @Override
        public void handleResponse(Response<NextNResponse> future) {
            try {
                NextNResponse response = future.get();
                List<Integer> nums = response.getReturn();
                nums.stream().forEach((num) -> {
                    System.out.println(num);
                });
            } catch (InterruptedException | ExecutionException e) {
            }
        }
    }
}
