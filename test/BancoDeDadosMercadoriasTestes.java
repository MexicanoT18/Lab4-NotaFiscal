import basededados.BancoDeDadosImpostos;
import basededados.BancoDeDadosMercadorias;
import imposto.Imposto;
import notafiscal.Produto;
import notafiscal.Servico;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosMercadoriasTestes {
    
    BancoDeDadosImpostos _bancoImpostos;
    BancoDeDadosMercadorias _bancoMercadorias;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Before
    public void setUp(){
        DataMocker.mockAll();
        _bancoImpostos = new BancoDeDadosImpostos();
        _bancoMercadorias = new BancoDeDadosMercadorias(_bancoImpostos);
    }
    
    @Test
    public void testarSorvete(){
        Produto esperado = (Produto)DataMocker.getMercadoria("sorvete");
        try{
            Produto teste = _bancoMercadorias.getProduto("sorvete");
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 0.000000001);
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarChocolate(){
        Produto esperado = (Produto)DataMocker.getMercadoria("chocolate");
        try{
            Produto teste = _bancoMercadorias.getProduto("chocolate");
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 0.000000001);
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarCaixaDeDoces(){
        Produto esperado = (Produto)DataMocker.getMercadoria("caixa de doces");
        try{
            Produto teste = _bancoMercadorias.getProduto("caixa de doces");
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 0.000000001);
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarInternet(){
        Servico esperado = (Servico)DataMocker.getMercadoria("internet");
        try{
            Servico teste = _bancoMercadorias.getServico("internet");
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 0.000000001);
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarTelefone(){
        Servico esperado = (Servico)DataMocker.getMercadoria("telefone");
        try{
            Servico teste = _bancoMercadorias.getServico("telefone");
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 0.000000001);
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarComboNet(){
        Servico esperado = (Servico)DataMocker.getMercadoria("combo net");
        try{
            Servico teste = _bancoMercadorias.getServico("combo net");
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 0.000000001);
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
}
