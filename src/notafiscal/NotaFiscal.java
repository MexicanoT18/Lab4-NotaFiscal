/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class NotaFiscal {
    private int _id;
    private String _data;
    private ArrayList<ItemDeVenda> _itens;
    
    public NotaFiscal(){
        
    }
    public void validar(){
        ValidadorNF validador = ValidadorNF.getInstancia();
        validador.validar(this);
    }
    public double getValor(){
        return 0.0; //dummy
    }
    public String getData(){
        return _data;
    }
    public void adicionarProduto(String nome){
        
    }
    public void adicionarServico(String nome){
        
    }
}
