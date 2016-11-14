/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

/**
 *
 * @author Lucas
 */
public class ValidadorNF {
    
    private static ValidadorNF _instancia;
            
    private ValidadorNF(){
        
    }
    public static ValidadorNF getInstancia(){
        if (_instancia == null){
            _instancia = new ValidadorNF();
        }
        return _instancia;
    }
    public void validar(NotaFiscal nota){
        
    }
}
