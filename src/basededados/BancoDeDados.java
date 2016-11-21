package basededados;

import notafiscal.Produto;
import notafiscal.Servico;

/**
 *
 * @author Lucas
 */
public class BancoDeDados {         //DP singleton, facade
    private static BancoDeDados _instancia;
    private BancoDeDadosImpostos _bancoImpostos;
    private BancoDeDadosMercadorias _bancoMercadorias;
    private BancoDeDadosNotaFiscal _bancoNotas;
    
    private BancoDeDados(){
        _bancoImpostos = new BancoDeDadosImpostos();
        _bancoMercadorias = new BancoDeDadosMercadorias(_bancoImpostos);
        _bancoNotas = new BancoDeDadosNotaFiscal();
    }
    
    public static BancoDeDados getInstancia(){
        if (_instancia == null){
            _instancia = new BancoDeDados();
        }
        return _instancia;
    }
    
    public Produto getProduto(String nome) throws Exception{
        return _bancoMercadorias.getProduto(nome);
    }
    
    public Servico getServico(String nome) throws Exception{
        return _bancoMercadorias.getServico(nome);
    }
    
    public boolean existeId(int id){
        return _bancoNotas.existeId(id);
    }
    
    public void registrarId(int id) throws Exception{
        _bancoNotas.registrarId(id);
    }
}
