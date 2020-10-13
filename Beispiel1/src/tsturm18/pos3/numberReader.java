/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsturm18.pos3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timst
 */
public class numberReader {

    List<Integer> numberList = new ArrayList<>();

    public numberReader() {

    }

    public void readNumbers(File file) {
        try {
            Files.lines(file.toPath())
                    .map(n -> n.split(":"))
                    .forEach(array -> Arrays.stream(array)
                    .forEach(n -> {
                        try {
                            numberList.add(Integer.valueOf(n));
                        } catch (NumberFormatException ex) {
                        }
                    }));
        } catch (IOException ex) {
            Logger.getLogger(numberReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
