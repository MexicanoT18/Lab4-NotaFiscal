/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

/**
 *
 * @author Lucas
 */
public class Produto implements Mercadoria{
    
    private double _preco;
    private String _nome;
    private Imposto _imposto;
    
    public Produto(double preco, String nome, Imposto imposto){
        _preco = preco;
        _nome = nome;
        _imposto = imposto;
    }
    
    public double getPreco(){
        return _preco;
    }
    public String getNome(){
        return _nome;
    }
    public Imposto getImposto(){
        return _imposto;
    }
    
}
