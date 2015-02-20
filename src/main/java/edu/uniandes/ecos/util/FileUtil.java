/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Alvaro
 */
public class FileUtil {

    public static LinkedList<Double> getListNumbers(final String nameFile) throws FileNotFoundException, IOException, NumberFormatException {
        final LinkedList<Double> list = new LinkedList<Double>();
        final File file = new File("src/test/resources/"+nameFile);
        final FileReader fr = new FileReader(file);
        final BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            list.add(Double.parseDouble(line));
            line = br.readLine();
        }
        fr.close();
        return list;
    }

}
