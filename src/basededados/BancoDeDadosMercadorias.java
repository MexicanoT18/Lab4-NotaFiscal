package basededados;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import imposto.Imposto;
import java.util.List;
import notafiscal.Mercadoria;
import notafiscal.Produto;
import notafiscal.Servico;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosMercadorias {
    
    private BancoDeDadosImpostos _bancoImpostos;
    private Map<String, Double> _precos;
    private Map<String, ArrayList<String> > _submercadorias;
    private Set<String> _nomesProdutos;
    private Set<String> _nomesServicos;
    
    public BancoDeDadosMercadorias(BancoDeDadosImpostos bancoImpostos){
        _bancoImpostos = bancoImpostos;
        
        _precos = DataGUI.getPSPrecos();
        _submercadorias = DataGUI.getPSSubmercadorias();
        _nomesProdutos = DataGUI.getProdutos();
        _nomesServicos = DataGUI.getServicos();
    }
    
    public Produto getProduto(String nome) throws Exception{
        if (!_nomesProdutos.contains(nome)){
            throw new Exception(nome + ": Produto inexistente no banco de dados de mercadorias");
        }
        double preco = _precos.get(nome);
        
        ArrayList<String> nomesSubmercadorias = _submercadorias.get(nome);
        ArrayList<Mercadoria> submercadorias = new ArrayList<>();
        for(int i=0; i<nomesSubmercadorias.size(); i++){
            if (_nomesProdutos.contains(nomesSubmercadorias.get(i)))
                submercadorias.add(getProduto(nomesSubmercadorias.get(i)));
            if (_nomesServicos.contains(nomesSubmercadorias.get(i)))
                submercadorias.add(getServico(nomesSubmercadorias.get(i)));
        }
        
        List<Imposto> impostos = _bancoImpostos.getImposto(nome);
        
        Produto produto = new Produto(preco, nome, submercadorias, impostos);
        
        return produto;
    }
    
    public Servico getServico(String nome) throws Exception{
        if (!_nomesServicos.contains(nome)){
            throw new Exception(nome + ": Servico inexistente no banco de dados de mercadorias");
        }
        double preco = _precos.get(nome);
        
        ArrayList<String> nomesSubmercadorias = _submercadorias.get(nome);
        ArrayList<Mercadoria> submercadorias = new ArrayList<>();
        for(int i=0; i<nomesSubmercadorias.size(); i++){
            if (_nomesProdutos.contains(nomesSubmercadorias.get(i)))
                submercadorias.add(getProduto(nomesSubmercadorias.get(i)));
            if (_nomesServicos.contains(nomesSubmercadorias.get(i)))
                submercadorias.add(getServico(nomesSubmercadorias.get(i)));
        }
        
        List<Imposto> impostos = _bancoImpostos.getImposto(nome);
        
        Servico servico = new Servico(preco, nome, submercadorias, impostos);
        return servico;
    }
}
