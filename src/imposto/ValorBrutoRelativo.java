/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imposto;

import java.util.List;
import notafiscal.Mercadoria;

/**
 *
 * @author Lucas
 */
public class ValorBrutoRelativo implements TaxCalculator{
    
    private double _bruto;
    
    public ValorBrutoRelativo(double bruto){
        _bruto = bruto;
    }
    
    @Override
    public double aplicarImposto(double valor, Imposto imposto){
        List<Imposto> impostos = imposto.getMercadoria().getImpostos();
        int mult = 0;
        for(int i=0; i<impostos.size(); i++){
            mult++;
            if (impostos.get(i).equals(imposto)){
                break;
            }
        }
        return valor + (mult*_bruto);
    }
    
    @Override
    public TaxCalculator clone(){
        return new ValorBrutoRelativo(_bruto);
    }
    
    public double getBruto(){
        return _bruto;
    }
    
    @Override
    public boolean equals(Object object){
        if (!(object instanceof ValorBruto)) return false;
        ValorBruto outro = (ValorBruto) object;
        
        return Math.abs(_bruto - outro.getBruto()) < 1e-9;
    }
}
