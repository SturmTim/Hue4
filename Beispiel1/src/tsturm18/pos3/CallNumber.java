/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsturm18.pos3;

import java.util.concurrent.Callable;

/**
 *
 * @author timst
 */
public class CallNumber implements Callable<Integer> {

    int calledNumber;

    public CallNumber(int calledNumber) {
        this.calledNumber = calledNumber;
    }

    @Override
    public Integer call() throws Exception {
        return calledNumber;
    }

}
