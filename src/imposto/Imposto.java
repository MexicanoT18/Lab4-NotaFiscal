package imposto;

import java.util.Collections;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public final class Imposto {
    
    private String _nome;
    private TaxCalculator _calculator;  //hook class
    
    public Imposto(String nome, TaxCalculator calculator){
        _calculator = calculator;
        _nome = nome;
    }
    
    public String getNome(){
        return _nome;
    }
    
    public double getValor(double preco){
        return _calculator.aplicarImposto(preco);
    }
    
    public TaxCalculator getCalculator(){
        return _calculator;
    }
    
    public boolean equals(Object object){
        if (!(object instanceof Imposto)) return false;
        Imposto outro = (Imposto) object;
        return getNome().equals(outro.getNome()) && getCalculator().equals(outro.getCalculator());
    }
    
    public Imposto clone(){
        return new Imposto(_nome, _calculator.clone());
    }
}
