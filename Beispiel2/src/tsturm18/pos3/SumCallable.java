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
public class SumCallable implements Callable<Integer> {

    private int von;
    private final int bis;

    public SumCallable(int von, int bis) {
        this.von = von;
        this.bis = bis;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        while (von <= bis) {
            sum += von;
            von++;
        }
        return sum;
    }

}
