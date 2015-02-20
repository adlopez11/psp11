package edu.uniandes.ecos.util;

import java.util.LinkedList;

/**
 *
 * @author Alvaro
 */
public class MeanUtil {
    
    public static Double calculateMean(final LinkedList<Double> nums){
        double size = nums.size();
        double acum =0d;
        double mean;
        
        for(Double num : nums){
            acum = acum + num;
        }
        mean = acum/size;
        return mean ;
    }
    
}
