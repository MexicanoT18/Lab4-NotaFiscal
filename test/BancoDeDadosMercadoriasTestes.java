import basededados.BancoDeDadosImpostos;
import basededados.BancoDeDadosMercadorias;
import imposto.Imposto;
import notafiscal.Mercadoria;
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
    
    @Before
    public void setUp(){
        DataMocker.mockAll();
        _bancoImpostos = new BancoDeDadosImpostos();
        _bancoMercadorias = new BancoDeDadosMercadorias(_bancoImpostos);
    }
    
    @Test
    public void testarGerarProdutosValidos(){
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
        esperado = (Produto)DataMocker.getMercadoria("chocolate");
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
    public void testarGerarServicosValidos(){
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
        esperado = (Servico)DataMocker.getMercadoria("telefone");
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
    public void testarGerarMercadoriasCompostas(){
        Produto esperado1 = (Produto)DataMocker.getMercadoria("caixa de doces");
        try{
            Produto teste = _bancoMercadorias.getProduto("caixa de doces");
            assertTrue(teste.getNome().equals(esperado1.getNome()));
            assertTrue(teste.getImpostos().equals(esperado1.getImpostos()));
            assertEquals(teste.getPreco(), esperado1.getPreco(), 0.000000001);
            assertTrue(teste.equals(esperado1));
        } catch(Exception e){
            fail(e.getMessage());
        }
        Servico esperado2 = (Servico)DataMocker.getMercadoria("combo net");
        try{
            Servico teste = _bancoMercadorias.getServico("combo net");
            assertTrue(teste.getNome().equals(esperado2.getNome()));
            assertTrue(teste.getImpostos().equals(esperado2.getImpostos()));
            assertEquals(teste.getPreco(), esperado2.getPreco(), 0.000000001);
            assertTrue(teste.equals(esperado2));
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarGerarMercadoriaInvalida(){
        try{
            Produto produto = _bancoMercadorias.getProduto("chocolate branco");
            fail();
        } catch(Exception e){
            if (!e.getMessage().equals("chocolate branco: Produto inexistente no banco de dados de mercadorias"))
                fail(e.getMessage());
        }
        try{
            Servico servico = _bancoMercadorias.getServico("3g");
            fail();
        } catch(Exception e){
            if (!e.getMessage().equals("3g: Servico inexistente no banco de dados de mercadorias"))
                fail(e.getMessage());            
        }
    }
}
