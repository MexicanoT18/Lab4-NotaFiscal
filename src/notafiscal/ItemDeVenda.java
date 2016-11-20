/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

import basededados.BancoDeDados;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ItemDeVenda {
    private Mercadoria _mercadoria;
    private double _desconto;
    private int _quantidade;
    
    public ItemDeVenda(String nome, double desconto, int quantidade) throws Exception{
        BancoDeDados banco = BancoDeDados.getInstancia();
        _mercadoria = null;
        try{
            if (_mercadoria == null)
                _mercadoria = banco.getProduto(nome);
        } catch (Exception e){
            if (!e.getMessage().equals("Produto inexistente")){
                throw e;
            }
        }
        try{
            if (_mercadoria == null)
                _mercadoria = banco.getServico(nome);
        } catch (Exception e){
            if (!e.getMessage().equals("Serviço inexistente")){
                throw e;
            }
        }
        if (_mercadoria == null)
            throw new Exception("Produto/Serviço inexistente");
        
        _desconto = desconto;
        _quantidade = quantidade;                    
    }
    
    public String getNome(){
        return _mercadoria.getNome();
    }
    
    public double getDesconto(){
        return _desconto;
    }
    
    public int getQuantidade(){
        return _quantidade;
    }
    
    public Imposto getImposto(){
        return _mercadoria.getImposto();
    }
    
    public double getValor(){
        return _quantidade*_desconto*_mercadoria.getPreco()*(1.0 + getImposto().getPorcentagem());
    }
    
    public boolean equals(ItemDeVenda outro){
        return getNome().equals(outro.getNome()) && getDesconto() == outro.getDesconto() && getImposto().equals(outro.getImposto());
    }
}
