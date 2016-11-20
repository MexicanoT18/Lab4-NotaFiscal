/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededados;

import notafiscal.NotaFiscal;

/**
 *
 * @author Lucas
 */
public class ValidadorNF {
    
    private static ValidadorNF _instancia;
    private int _idAtual;
            
    private ValidadorNF(){
        _idAtual = 0;
    }
    public static ValidadorNF getInstancia(){
        if (_instancia == null){
            _instancia = new ValidadorNF();
        }
        return _instancia;
    }
    public final NotaFiscal validar(NotaFiscal nota){
        return null;
    }
}
