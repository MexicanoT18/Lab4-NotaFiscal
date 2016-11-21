package notafiscal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javafx.print.Collation;

/**
 *
 * @author Lucas
 */
public final class NotaFiscal {
    
    private int _id;
    private List<ItemDeVenda> _itens;
    private boolean _emElaboracao;
    
    public NotaFiscal(){
        _emElaboracao = true;
        _itens = new ArrayList<>();
        _id = -1;
    }
    
    public void validar() throws Exception{
        if (!_emElaboracao){
            throw new Exception("Nota já validada");
        }
        ValidadorNF validador = ValidadorNF.getInstancia();
        _id = validador.validarEPegarId(this);
        if (_id < 0){
            throw new Exception("Validação não autorizada");
        }
        _itens = Collections.unmodifiableList(_itens);
        _emElaboracao = false;
    }
    
    public double getValor(){
        double valor = 0.0;
        for (int i = 0; i < _itens.size(); i++) {
            valor += _itens.get(i).getValor();            
        }
        return valor;
    }
    
    public List<ItemDeVenda> getItensDeVenda(){
        return Collections.unmodifiableList(_itens);
    }
    
    public boolean possuiItens(){
        return !_itens.isEmpty();
    }
    
    public void adicionarMercadoria(String nome, double desconto, int quantidade) throws Exception{
        if (!_emElaboracao) return;
        
        ItemDeVenda item = new ItemDeVenda(nome, desconto, quantidade);
        
        if (_itens.contains(item)){
            int i = _itens.indexOf(item);
            quantidade += _itens.get(i).getQuantidade();
            _itens.remove(item);
        }
        
        item = new ItemDeVenda(nome, desconto, quantidade);
        
        _itens.add(item);
    }
}
