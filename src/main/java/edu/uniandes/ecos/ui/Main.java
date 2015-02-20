package edu.uniandes.ecos.ui;


import edu.uniandes.ecos.biz.DesviationBiz;
import edu.uniandes.ecos.util.FileUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Main {
    public static void main(String[] args){
        
        System.out.println("Calculo de Desviacion Estadar y Medidas de Estimacion\n");
        
        try {
            System.out.println("Digite el nombre del archivo con las dos lista de numeros "
                + "a evaluar, debe colocarse en la carpeta /src/test/resources/: ");
            Scanner sc = new Scanner(System.in);
            String file = sc.next();
            System.out.println("\nArchivo de valores " + file + "\n");
            
            DesviationBiz biz = new DesviationBiz(FileUtil.getListNumbers(file));
            

            System.out.println("Desviacion Estandar: " + biz.getSd()+"\n");
            System.out.println("VS: " + biz.getVs());
            System.out.println("S: " + biz.getS());
            System.out.println("M: " + biz.getM());
            System.out.println("L: " + biz.getL());
            System.out.println("VL: " + biz.getVl());


        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo especificado, se debe ubicar en la carpeta /src/test/resources/");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo especificado");
        } catch (NumberFormatException ex) {
            System.out.println("Existen lineas que no son numeros");
        }
        System.out.println("\nFin de la aplicacion");
        
    }
}
