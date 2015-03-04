/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rand2;

import java.util.Random;
import javax.jws.WebService;

/**
 *
 * @author hoangnv
 */
@WebService(endpointInterface = "rand2.RandService")
public class RandImpl implements RandService {

    private static final int maxRands = 16;

    @Override
    public int next1() {
        return new Random().nextInt();
    }

    @Override
    public int[] nextN(int n) {
        final int k = (n > maxRands) ? maxRands : Math.abs(n);
        int[] rands = new int[k];
        Random r = new Random();
        for (int i = 0; i < k; i++) {
            rands[i] = r.nextInt();
        }
        return rands;
    }

}
