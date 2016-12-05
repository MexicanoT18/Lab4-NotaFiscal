package notafiscal;

import imposto.Imposto;
import basededados.BancoDeDados;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public final class ItemDeVenda {
    private Mercadoria _mercadoria; //requisitos 2, 3, 4
    private double _desconto;
    private int _quantidade;
    
    //requisito 13: apenas o construtor define os atributos
    public ItemDeVenda(String nome, double desconto, int quantidade) throws Exception{
        BancoDeDados banco = BancoDeDados.getInstancia();
        _mercadoria = null;
        try{
            if (_mercadoria == null)
                _mercadoria = banco.getProduto(nome);
        } catch (Exception e){
            if (!e.getMessage().equals(nome + ": Produto inexistente no banco de dados de mercadorias")){
                throw e;
            }
        }
        try{
            if (_mercadoria == null)
                _mercadoria = banco.getServico(nome);
        } catch (Exception e){
            if (!e.getMessage().equals(nome + ": Servico inexistente no banco de dados de mercadorias")){
                throw e;
            }
        }
        if (_mercadoria == null)
            throw new IllegalArgumentException("Produto/Serviço inexistente");
        
        if (desconto < 0.0 || desconto > 100.0){
            throw new IllegalArgumentException("Desconto inválido");
        }
        _desconto = desconto;
        
        if (quantidade < 1){
            throw new IllegalArgumentException("Quantidade inválida");
        }
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
    
    public Mercadoria getMercadoria(){
        return _mercadoria;
    }
    
    public double getValor(){
        return _quantidade*(1.0 - (_desconto/100.0))*_mercadoria.getValor();
    }
    
    public boolean equals(Object object){
        if (!(object instanceof ItemDeVenda)) return false;
        ItemDeVenda outro = (ItemDeVenda)object;
        
        if (Math.abs(getDesconto() - outro.getDesconto()) > 1e-9) return false;
        
        Produto produto1, produto2;
        Servico servico1, servico2;
        if (getMercadoria() instanceof Produto){
            produto1 = (Produto)getMercadoria();
            servico1 = null;
        }
        else if (getMercadoria() instanceof Servico){
            servico1 = (Servico)getMercadoria();
            produto1 = null;
        }
        else{
            servico1 = null;
            produto1 = null;
        }
        if (outro.getMercadoria() instanceof Produto){
            produto2 = (Produto)outro.getMercadoria();
            servico2 = null;
        }
        else if (outro.getMercadoria() instanceof Servico){
            servico2 = (Servico)outro.getMercadoria();
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
        
        return true;
    }
}
