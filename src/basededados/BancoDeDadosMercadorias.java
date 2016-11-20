/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededados;

import java.util.TreeMap;
import notafiscal.Produto;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosMercadorias {
    
    private BancoDeDadosImpostos _bancoImpostos;
    private TreeMap<String, Double> precos;
    
    public BancoDeDadosMercadorias(BancoDeDadosImpostos bancoImpostos){
        _bancoImpostos = bancoImpostos;
    }
    public Produto getProduto(String nome){
        double preco = precos.get(nome);
        Imposto = _bancoImpostos.getImposto(nome);
        Produto produto = new Produto(preco, nome, imposto)
    }
}
