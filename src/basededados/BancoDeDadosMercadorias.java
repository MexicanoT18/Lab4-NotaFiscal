/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededados;

import java.util.TreeMap;
import notafiscal.Imposto;
import notafiscal.Produto;
import notafiscal.Servico;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosMercadorias {
    
    private BancoDeDadosImpostos _bancoImpostos;
    private TreeMap<String, Double> _precos;
    
    public BancoDeDadosMercadorias(BancoDeDadosImpostos bancoImpostos){
        _bancoImpostos = bancoImpostos;
        
        _precos = DataMocker.getPSPrecos();
    }
    
    public Produto getProduto(String nome) throws Exception{
        if (_precos.containsKey(nome)){
            throw new Exception("Mercadoria inexistente no banco de dados de mercadorias");
        }
        double preco = _precos.get(nome);
        Imposto imposto = _bancoImpostos.getImposto(nome);
        Produto produto = new Produto(preco, nome, imposto);
        return produto;
    }
    
    public Servico getServico(String nome) throws Exception{
        double preco = _precos.get(nome);
        Imposto imposto = _bancoImpostos.getImposto(nome);
        Servico servico = new Servico(preco, nome, imposto);
        return servico;
    }
}
