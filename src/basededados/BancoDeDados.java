/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededados;

/**
 *
 * @author Lucas
 */
public class BancoDeDados {
    private static BancoDeDados _instancia;
    private BancoDeDadosImpostos _bancoImpostos;
    private BancoDeDadosMercadorias _bancoMercadorias;
    
    private BancoDeDados(){
        
    }
    
    public static BancoDeDados getInstancia(){
        if (_instancia == null){
            _instancia = new BancoDeDados();
        }
        return _instancia;
    }
}
