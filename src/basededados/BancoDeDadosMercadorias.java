/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededados;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import notafiscal.Imposto;
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
        
        Imposto imposto = _bancoImpostos.getImposto(nome);
        
        ArrayList<String> nomesSubmercadorias = _submercadorias.get(nome);
        ArrayList<Mercadoria> submercadorias = new ArrayList<>();
        for(int i=0; i<nomesSubmercadorias.size(); i++){
            if (_nomesProdutos.contains(nomesSubmercadorias.get(i)))
                submercadorias.add(getProduto(nomesSubmercadorias.get(i)));
            if (_nomesServicos.contains(nomesSubmercadorias.get(i)))
                submercadorias.add(getServico(nomesSubmercadorias.get(i)));
        }
        
        Produto produto = new Produto(preco, nome, imposto, submercadorias);
        return produto;
    }
    
    public Servico getServico(String nome) throws Exception{
        if (!_nomesServicos.contains(nome)){
            throw new Exception(nome + ": Servico inexistente no banco de dados de mercadorias");
        }
        double preco = _precos.get(nome);
        
        Imposto imposto = _bancoImpostos.getImposto(nome);
        
        ArrayList<String> nomesSubmercadorias = _submercadorias.get(nome);
        ArrayList<Mercadoria> submercadorias = new ArrayList<>();
        for(int i=0; i<nomesSubmercadorias.size(); i++){
            if (_nomesProdutos.contains(nomesSubmercadorias.get(i)))
                submercadorias.add(getProduto(nomesSubmercadorias.get(i)));
            if (_nomesServicos.contains(nomesSubmercadorias.get(i)))
                submercadorias.add(getServico(nomesSubmercadorias.get(i)));
        }
        Servico servico = new Servico(preco, nome, imposto, submercadorias);
        return servico;
    }
}
