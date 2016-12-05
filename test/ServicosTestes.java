import imposto.Imposto;
import java.util.ArrayList;
import java.util.List;
import notafiscal.Mercadoria;
import notafiscal.Servico;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class ServicosTestes {
    @Before
    public void setUp(){
        DataMocker.mockAll();
    }
    
    @Test
    public void testarGerarServicosValidos_requisito_5(){
        Servico esperado = (Servico)DataMocker.getMercadoria("internet");
        try{
            List<Imposto> impostos = DataMocker.getImposto("internet");
            Servico teste = new Servico(120.0, "internet", new ArrayList<>(), impostos);
            assertTrue(teste.getNome().equals(esperado.getNome()));
            assertTrue(teste.getImpostos().equals(esperado.getImpostos()));
            assertEquals(teste.getPreco(), esperado.getPreco(), 1e-9);
            assertEquals(teste.getValor(), esperado.getValor(), 1e-9);
            assertEquals(teste, esperado);
        } catch(Exception e){
            fail(e.getMessage());
        }
        esperado = (Servico)DataMocker.getMercadoria("telefone");
        try{
            List<Imposto> impostos = DataMocker.getImposto("telefone");
            Servico teste = new Servico(30.0, "telefone", new ArrayList<>(), impostos);
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
    public void testarGerarServicosCompostos_requisito_17(){
        Servico esperado = (Servico)DataMocker.getMercadoria("combo net");
        try{
            List<Mercadoria> submercadorias = new ArrayList<>();
            List<Imposto> impostos = DataMocker.getImposto("internet");
            submercadorias.add(new Servico(120.0, "internet", new ArrayList<>(), impostos));
            impostos = DataMocker.getImposto("telefone");
            submercadorias.add(new Servico(30.0, "telefone", new ArrayList<>(), impostos));
            
            impostos = DataMocker.getImposto("combo net");
            Servico teste = new Servico(0.0, "combo net", submercadorias, impostos);
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
