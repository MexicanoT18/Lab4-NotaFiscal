package imposto;

import java.util.Collections;
import java.util.Map;
import notafiscal.Mercadoria;

/**
 *
 * @author Lucas
 */
public final class Imposto {
    
    private String _nome;
    private TaxCalculator _calculator;  //hook class
    private Mercadoria _mercadoria;     //Imposto deve ter acesso a mercadoria e a seus filhos
    
    public Imposto(String nome, TaxCalculator calculator, Mercadoria mercadoria){
        _calculator = calculator;
        _nome = nome;
        _mercadoria = mercadoria;
    }
    
    public String getNome(){
        return _nome;
    }
    
    public double getValor(double preco){
        return _calculator.aplicarImposto(preco, this);
    }
    
    public TaxCalculator getCalculator(){
        return _calculator;
    }
    
    public Mercadoria getMercadoria(){
        return _mercadoria;
    }
    
    public boolean equals(Object object){
        if (!(object instanceof Imposto)) return false;
        Imposto outro = (Imposto) object;
        return getNome().equals(outro.getNome()) && getCalculator().equals(outro.getCalculator());
    }
    
    public Imposto clone(Mercadoria mercadoria){
        return new Imposto(_nome, _calculator.clone(), mercadoria);
    }
}
