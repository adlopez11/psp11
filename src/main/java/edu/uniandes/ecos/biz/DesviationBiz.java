/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.biz;

import edu.uniandes.ecos.util.MeanUtil;
import java.util.LinkedList;

/**
 *
 * @author Alvaro
 */
public class DesviationBiz {
    
    final private Double sd;
    
    final private Double vs;
    final private Double s;
    final private Double m;
    final private Double l;
    final private Double vl;
    
    public DesviationBiz(final LinkedList<Double> xs){
        
        double n = xs.size();
        LinkedList<Double> logxs = new LinkedList<Double>();
        for(Double x : xs){
            logxs.add(Math.log(x));
        }
        
        Double avg = MeanUtil.calculateMean(logxs);
        
        Double acum = 0d;
        
        for(Double x : xs){
            acum = acum + Math.pow((Math.log(x) - avg),2d);
        }
        
        Double var = acum / (n - 1d);
        
        sd = Math.sqrt(var);
        
        vs = Math.pow(Math.E, (avg - 2*sd));
        s = Math.pow(Math.E, (avg - sd));
        m = Math.pow(Math.E, (avg));
        l = Math.pow(Math.E, (avg + sd));
        vl = Math.pow(Math.E, (avg + 2*sd));
        
    }

    public Double getSd() {
        return sd;
    }

    public Double getVs() {
        return vs;
    }

    public Double getS() {
        return s;
    }

    public Double getM() {
        return m;
    }

    public Double getL() {
        return l;
    }

    public Double getVl() {
        return vl;
    }
    
    
}
