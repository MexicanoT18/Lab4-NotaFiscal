/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededados;

import notafiscal.Produto;
import notafiscal.Servico;

/**
 *
 * @author Lucas
 */
public class BancoDeDados {
    private static BancoDeDados _instancia;
    private BancoDeDadosImpostos _bancoImpostos;
    private BancoDeDadosMercadorias _bancoMercadorias;
    
    private BancoDeDados(){
        _bancoImpostos = new BancoDeDadosImpostos();
        _bancoMercadorias = new BancoDeDadosMercadorias(_bancoImpostos);
    }
    
    public static BancoDeDados getInstancia(){
        if (_instancia == null){
            _instancia = new BancoDeDados();
        }
        return _instancia;
    }
    
    public Produto getProduto(String nome){
        return _bancoMercadorias.getProduto(nome);
    }
    
    public Servico getServico(String nome){
        return _bancoMercadorias.getServico(nome);
    }
}
