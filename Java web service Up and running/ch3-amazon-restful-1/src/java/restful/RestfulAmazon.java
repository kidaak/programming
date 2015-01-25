/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

/**
 *
 * @author hoangnv
 */
public class RestfulAmazon {
    private static final String endpoint = "ecs.amazonaws.com";
    private static final String itemId = "0545010225";//Harry Potter
    
    public static void main(String[] args){
        if(args.length < 2){
            System.out.println("RestfulAmazon <accessKeyId> <secretKey>");
            return;
        }
        new RestfulAmazon().lookupStuff(args[0].trim(), args[1].trim());
    }
    
    private void lookupStuff(String accessKeyId, String secretKey){
        
    }
}
