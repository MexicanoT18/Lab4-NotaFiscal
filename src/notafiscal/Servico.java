/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Servico implements Mercadoria{
    
    private final double _preco;
    private final String _nome;
    private final Imposto _imposto;
    private final List<Mercadoria> _submercadorias;
    
    public Servico(double preco, String nome, Imposto imposto, List<Mercadoria> submercadorias){
        _preco = preco;
        _nome = nome;
        _imposto = imposto;
        _submercadorias = submercadorias;
    }
    
    @Override
    public List<Mercadoria> getSubmercadorias(){
        return Collections.unmodifiableList(_submercadorias);
    }
    
    @Override
    public double getPreco(){
        return _preco;
    }
    
    @Override
    public String getNome(){
        return _nome;
    }
    
    @Override
    public Imposto getImposto(){
        return _imposto;
    }
    
    public boolean equals(Mercadoria outro){
        List<Mercadoria> lista1 = getSubmercadorias();
        List<Mercadoria> lista2 = outro.getSubmercadorias();
        if (lista1.size()!=lista2.size())
            return false;
        Produto produto1, produto2;
        Servico servico1, servico2;
        for(int i=0; i<lista1.size(); i++){
            if (lista1.get(i) instanceof Produto){
                produto1 = (Produto)lista1.get(i);
                servico1 = null;
            }
            else if (lista1.get(i) instanceof Servico){
                servico1 = (Servico)lista1.get(i);
                produto1 = null;
            }
            else{
                servico1 = null;
                produto1 = null;
            }
            if (lista2.get(i) instanceof Produto){
                produto2 = (Produto)lista2.get(i);
                servico2 = null;
            }
            else if (lista2.get(i) instanceof Servico){
                servico2 = (Servico)lista2.get(i);
                produto2 = null;
            }
            else{
                servico2 = null; produto2 = null;
            }
            if (produto1 != null && produto2 != null){
                if (!produto1.equals(produto2)) return false;
            }
            else if (servico1 != null && servico2 != null){
                if (!servico1.equals(servico2)) return false;
            }
            else return false;
        }
        if (Math.abs(getPreco() - outro.getPreco()) > 1e-9) return false;
        if (!getNome().equals(outro.getNome())) return false;
        if (!getImposto().equals(outro.getImposto())) return false;
        return true;
    }
}
