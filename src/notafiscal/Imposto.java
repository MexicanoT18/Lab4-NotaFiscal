/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

import java.util.Collections;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class Imposto {
    private Map<String, Double> _impostos;
    
    public Imposto(Map<String, Double> impostos){
        _impostos = impostos;
    }
    
    public Map<String, Double> getImpostos(){
        return Collections.unmodifiableMap(_impostos);
    }
    
    public double getPorcentagem(){
        double porcentagem = 0.0;
        for (Map.Entry<String, Double> entry : _impostos.entrySet())
        {
            porcentagem += entry.getValue();
        }
        return porcentagem;
    }
    
    public boolean equals(Imposto outro){
        return _impostos.equals(outro.getImpostos());
    }
}
