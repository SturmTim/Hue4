/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsturm18.pos3;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author timst
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1252");
        System.out.println("chunks>");
        int chunks = Integer.parseInt(scanner.nextLine());
        System.out.println("divider");
        int divider = Integer.parseInt(scanner.nextLine());
        NumberReader numberReader = new NumberReader();
        numberReader.readNumbers(new File("numbers.csv"));
        List<Integer> numberList = numberReader.getNumberList();

    }

}
