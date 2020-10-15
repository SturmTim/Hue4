/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsturm18.pos3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in, "Windows-1252");
            System.out.println("chunks>");
            int chunks = Integer.parseInt(scanner.nextLine());
            System.out.println("divider>");
            int divider = Integer.parseInt(scanner.nextLine());
            NumberReader numberReader = new NumberReader();
            numberReader.readNumbers(new File("numbers.csv"));
            List<Integer> numberList = numberReader.getNumberList();
            ExecutorService executor = Executors.newCachedThreadPool();
            List<CallNumber> tasksList = new ArrayList<>();

            int begin = 0;
            for (int i = 1; i <= chunks; i++) {
                int end = (int) (Math.ceil(numberList.size() / chunks) * i);
                if (end < numberList.size()) {
                    tasksList.add(new CallNumber(numberList.subList(begin, end), divider));
                } else {
                    tasksList.add(new CallNumber(numberList.subList(begin, numberList.size()),
                            divider));
                }
                begin = end;
            }

            List<Future<Integer[]>> list = executor.invokeAll(tasksList);
            executor.shutdown();
            list.stream()
                    .forEach(integers -> {
                        try {
                            Arrays.stream(integers.get()).forEach(System.out::println);
                        } catch (InterruptedException ex) {
                            System.out.println("InterruptedException");
                        } catch (ExecutionException ex) {
                            System.out.println("ExecutionException");
                        }
                    });

        } catch (InterruptedException ex) {
            System.out.println("InterruptedException");
        }
    }

}
