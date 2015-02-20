package edu.uniandes.ecos;

import edu.uniandes.ecos.biz.DesviationBiz;
import edu.uniandes.ecos.util.FileUtil;
import java.io.IOException;
import junit.framework.TestCase;

public class DesviationTest extends TestCase {

    public void test1() throws IOException {
        String file = "test1.txt";

        DesviationBiz biz = new DesviationBiz(FileUtil.getListNumbers(file));

        System.out.println("Desviacion Estandar: " + biz.getSd()+"\n");
        System.out.println("VS: " + biz.getVs());
        System.out.println("S: " + biz.getS());
        System.out.println("M: " + biz.getM());
        System.out.println("L: " + biz.getL());
        System.out.println("VL: " + biz.getVl());
        System.out.println("");

        assertEquals(4.3953 , biz.getVs(), 0.001d);
        assertEquals(8.5081, biz.getS(), 0.001d);
        assertEquals(16.4696, biz.getM(), 0.001d);
        assertEquals(31.8811, biz.getL(), 0.001d);
        assertEquals(61.7137, biz.getVl(), 0.001d);
    }
    
    public void test2() throws IOException {
        String file = "test2.txt";

        DesviationBiz biz = new DesviationBiz(FileUtil.getListNumbers(file));

        System.out.println("Desviacion Estandar: " + biz.getSd()+"\n");
        System.out.println("VS: " + biz.getVs());
        System.out.println("S: " + biz.getS());
        System.out.println("M: " + biz.getM());
        System.out.println("L: " + biz.getL());
        System.out.println("VL: " + biz.getVl());
        System.out.println("");

        assertEquals(6.3375 , biz.getVs(), 0.001d);
        assertEquals(8.4393, biz.getS(), 0.001d);
        assertEquals(11.2381, biz.getM(), 0.001d);
        assertEquals(14.9650, biz.getL(), 0.001d);
        assertEquals(19.9280, biz.getVl(), 0.001d);
    }
    
    
}
