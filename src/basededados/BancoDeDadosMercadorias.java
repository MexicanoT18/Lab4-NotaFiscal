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
        
        _precos = DataMocker.getImpostosPorcentagens();
    }
    
    public Produto getProduto(String nome){
        double preco = _precos.get(nome);
        Imposto imposto = _bancoImpostos.getImposto(nome);
        Produto produto = new Produto(preco, nome, imposto);
        return produto;
    }
    
    public Servico getServico(String nome){
        double preco = _precos.get(nome);
        Imposto imposto = _bancoImpostos.getImposto(nome);
        Servico servico = new Servico(preco, nome, imposto);
        return servico;
    }
}
