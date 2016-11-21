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
            
    private ValidadorNF(){
        _idAtual = 0;
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
        
        int id = _idAtual;
        _idAtual++;
        
        if (banco.existeId(id)){
            throw new Exception("Id já existe");
        }
        
        
        
        return -1;
    }
    
    public int getNumeroNotasEmitidas(){
        return _idAtual;
    }
}
