/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsturm18.pos3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author timst
 */
public class Beispiel2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in, "Windows-1252");
            System.out.print("n>");
            int bis = Integer.parseInt(scanner.nextLine());
            ExecutorService executor = Executors.newCachedThreadPool();

            List<SumCallable> tasks = new ArrayList<>();

            int von = 1;
            while (von <= bis) {
                if (von + 99 >= bis) {
                    tasks.add(new SumCallable(von, bis));
                } else {
                    tasks.add(new SumCallable(von, von + 99));
                }
                von += 100;
            }

            List<Future<Integer>> numbers = executor.invokeAll(tasks);

            executor.shutdown();

            numbers.stream()
                    .map(number -> {
                        try {
                            return number.get();
                        } catch (InterruptedException e) {
                            System.out.println("InterruptedException");
                        } catch (ExecutionException e) {
                            System.out.println("ExecutionException");
                        }
                        return null;
                    })
                    .reduce(Integer::sum)
                    .ifPresent(n -> System.out.println("Summe = " + n));

            int sum = (int) ((Math.pow(bis, 2) + bis) / 2);
            System.out.println("Summe Kontrolle = " + sum);

        } catch (InterruptedException ex) {
            System.out.println("InterruptedException");
        }
    }

}
