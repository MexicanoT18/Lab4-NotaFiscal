package notafiscal;

import basededados.BancoDeDados;
import notafiscal.NotaFiscal;

/**
 *
 * @author Lucas
 */
public class ValidadorNF {      //DP singleton
    
    private static ValidadorNF _instancia;
    private int _idAtual;
    private int _notasEmitidas;
            
    private ValidadorNF(){
        _idAtual = 1;
        _notasEmitidas = 0;
    }
    
    public static ValidadorNF getInstancia(){
        if (_instancia == null){
            _instancia = new ValidadorNF();
        }
        return _instancia;
    }
    
    public boolean notaValida(NotaFiscal nota){
        if (nota.getItensDeVenda().isEmpty()) return false;
        return true;
    }
    
    public int validarEPegarId(NotaFiscal nota) throws Exception{
        if (!notaValida(nota)){
            throw new Exception("Nota fiscal inválida");
        }
        
        BancoDeDados banco = BancoDeDados.getInstancia();
        
        while (banco.existeId(_idAtual)){
            _idAtual++;
        }
        int id = _idAtual;
        _idAtual++;
        banco.registrarId(id);
        _notasEmitidas++;
                
        return id;
    }
    
    public int getNumeroNotasEmitidas(){
        return _notasEmitidas;
    }
}
