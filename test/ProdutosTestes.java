import java.util.ArrayList;
import java.util.List;
import notafiscal.Mercadoria;
import notafiscal.Produto;
import imposto.Imposto;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class ProdutosTestes {
    
    @Before
    public void setUp(){
        DataMocker.mockAll();
    }
    
    @Test
    public void testarGerarProdutosValidos_requisito_5(){
        Produto esperado = (Produto)DataMocker.getMercadoria("sorvete");
        try{
            List<Imposto> impostos = DataMocker.getImposto("sorvete");
            Produto teste = new Produto(20.0, "sorvete", new ArrayList<>(), impostos);
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 1e-9);
            assertEquals(teste.getValor(), esperado.getValor(), 1e-9);
            assertEquals(teste, esperado);
        } catch(Exception e){
            fail(e.getMessage());
        }
        esperado = (Produto)DataMocker.getMercadoria("chocolate");
        try{
            List<Imposto> impostos = DataMocker.getImposto("chocolate");
            Produto teste = new Produto(5.0, "chocolate", new ArrayList<>(), impostos);
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 1e-9);
            assertEquals(teste.getValor(), esperado.getValor(), 1e-9);
            assertEquals(teste, esperado);
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarGerarProdutosCompostos_requisito_17(){
        Produto esperado = (Produto)DataMocker.getMercadoria("caixa de doces");
        try{
            List<Mercadoria> submercadorias = new ArrayList<>();
            List<Imposto> impostos = DataMocker.getImposto("chocolate");
            submercadorias.add(new Produto(5.0, "chocolate", new ArrayList<>(), impostos));
            impostos = DataMocker.getImposto("sorvete");
            submercadorias.add(new Produto(20.0, "sorvete", new ArrayList<>(), impostos));
            
            impostos = DataMocker.getImposto("caixa de doces");
            Produto teste = new Produto(0.0, "caixa de doces", submercadorias, impostos);
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 1e-9);
            assertEquals(teste.getValor(), esperado.getValor(), 1e-9);
            assertEquals(teste, esperado);
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
}
