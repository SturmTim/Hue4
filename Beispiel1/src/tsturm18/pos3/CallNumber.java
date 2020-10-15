/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsturm18.pos3;

import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author timst
 */
public class CallNumber implements Callable<Integer[]> {

    private final List<Integer> numbers;

    private final Integer divider;

    public CallNumber(List<Integer> numbers, Integer divider) {
        this.numbers = numbers;
        this.divider = divider;
    }

    @Override
    public Integer[] call() throws Exception {
        return numbers.stream()
                .filter(number -> number % divider == 0)
                .toArray(Integer[]::new);
    }

}
