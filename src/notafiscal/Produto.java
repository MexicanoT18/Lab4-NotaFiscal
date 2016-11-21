package notafiscal;

import imposto.Imposto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas
 */
public final class Produto implements Mercadoria{
    
    private final double _preco;
    private final String _nome;
    private final List<Imposto> _impostos;
    private final List<Mercadoria> _submercadorias;
    
    public Produto(double preco, String nome, List<Mercadoria> submercadorias, List<Imposto> impostos){
        _preco = preco;
        _nome = nome;
        _impostos = impostos;
        _submercadorias = submercadorias;
    }
    
    @Override
    public double getValor(){
        double valor = _preco;
        for(int i=0; i<_submercadorias.size(); i++){
            valor += _submercadorias.get(i).getValor();
        }
        for(int i=0; i<_impostos.size(); i++){
            valor = _impostos.get(i).getValor(valor);
        }
        return valor;
    }
    
    @Override
    public double getPreco(){
        double preco = _preco;
        for(int i=0; i<_submercadorias.size(); i++){
            preco += _submercadorias.get(i).getPreco();
        }
        return _preco;
    }
    
    @Override
    public String getNome(){
        return _nome;
    }
    
    @Override
    public List<Mercadoria> getSubmercadorias(){
        return Collections.unmodifiableList(_submercadorias);
    }
    
    @Override
    public List<Imposto> getImpostos(){
        return Collections.unmodifiableList(_impostos);
    }
    
    @Override
    public boolean equals(Object object){
        if (!(object instanceof Produto)) return false;
        Produto outro = (Produto)object;
        
        if (Math.abs(getPreco() - outro.getPreco()) > 1e-9) return false;
        if (!getNome().equals(outro.getNome())) return false;
        if (!getImpostos().equals(outro.getImpostos())) return false;
        
        List<Mercadoria> lista1 = getSubmercadorias();
        List<Mercadoria> lista2 = outro.getSubmercadorias();
        if (lista1.size()!=lista2.size()) return false;
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
        return true;
    }
    
}
