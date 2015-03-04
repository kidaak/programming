/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rand2;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author hoangnv
 */
@WebService
public interface RandService {
    @WebMethod
    public int next1();
    @WebMethod
    public int[] nextN(final int n);
}
