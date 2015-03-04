/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rand;

import java.util.Random;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author hoangnv
 */
@WebService
public class RandService {

    private static final int maxRands = 16;

    @WebMethod //optional but helpful annotation
    public int next1() {
        return new Random().nextInt();
    }

    @WebMethod //optional but helpful annotation
    public int[] nextN(final int n) {
        final int k = (n > maxRands) ? maxRands : Math.abs(n);
        int[] rands = new int[k];
        Random r = new Random();
        for (int i = 0; i < k; i++) {
            rands[i] = r.nextInt();
        }
        return rands;
    }

}
