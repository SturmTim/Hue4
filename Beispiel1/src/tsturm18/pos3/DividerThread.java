/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsturm18.pos3;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timst
 */
public class DividerThread implements Runnable {

    int divider;
    List<Integer> partOfTheList;
    Callable<Integer> c;

    public DividerThread(int divider, List<Integer> partOfTheList) {
        this.divider = divider;
        this.partOfTheList = partOfTheList;
    }

    @Override
    public void run() {

        for (Integer integer : partOfTheList) {
            if (integer % divider == 0) {
                try {
                    c = new CallNumber(integer);
                    c.call();
                } catch (Exception ex) {
                    Logger.getLogger(DividerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

            }
        }
    }

}
