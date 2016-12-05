
import java.util.ArrayList;
import java.util.List;
import notafiscal.ItemDeVenda;
import notafiscal.NotaFiscal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class NotaFiscalTestes {
    @Before
    public void setUp(){
        DataMocker.mockAll();
    }
    
    @Test
    public void testarGerarNotaFiscalValida_requisito_1(){
        
        NotaFiscal nota = new NotaFiscal();
        double valor = 0.0;
        List<ItemDeVenda> itensEsperados = new ArrayList<>();
        
        try{
            assertFalse(nota.possuiItens());
            
            nota.adicionarMercadoria("chocolate", 0.0, 1);
            itensEsperados.add(new ItemDeVenda("chocolate", 0.0, 1));
            valor += DataMocker.getMercadoria("chocolate").getValor();
            assertEquals(nota.getValor(), valor, 1e-9);
            assertTrue(nota.possuiItens());
            
            nota.adicionarMercadoria("sorvete", 50.0, 1);
            itensEsperados.add(new ItemDeVenda("sorvete", 50.0, 1));
            valor += DataMocker.getMercadoria("sorvete").getValor()/2.0;
            assertEquals(nota.getValor(), valor, 1e-9);
            assertTrue(nota.possuiItens());
            
            nota.adicionarMercadoria("caixa de doces", 25.0, 8);
            itensEsperados.add(new ItemDeVenda("caixa de doces", 25.0, 8));
            valor += DataMocker.getMercadoria("caixa de doces").getValor()*6.0;
            assertEquals(nota.getValor(), valor, 1e-9);
            assertTrue(nota.possuiItens());
            
            nota.adicionarMercadoria("internet", 0.0, 1);
            itensEsperados.add(new ItemDeVenda("internet", 0.0, 1));
            valor += DataMocker.getMercadoria("internet").getValor();
            assertEquals(nota.getValor(), valor, 1e-9);
            assertTrue(nota.possuiItens());
            
            nota.adicionarMercadoria("telefone", 25.0, 1);
            itensEsperados.add(new ItemDeVenda("telefone", 25.0, 1));
            valor += DataMocker.getMercadoria("telefone").getValor()*0.75;
            assertEquals(nota.getValor(), valor, 1e-9);
            assertTrue(nota.possuiItens());
            
            nota.adicionarMercadoria("combo net", 10.0, 2);
            itensEsperados.add(new ItemDeVenda("combo net", 10.0, 2));
            valor += DataMocker.getMercadoria("combo net").getValor()*1.8;
            assertEquals(nota.getValor(), valor, 1e-9);
            assertTrue(nota.possuiItens());
            
            List<ItemDeVenda> itens = nota.getItensDeVenda();
            if (itens.size() != itensEsperados.size()){
                fail();
            }
            for(int i=0; i<itens.size(); i++){
                if (!itens.get(i).equals(itensEsperados.get(i))){
                    fail();
                }
            }
        } catch (Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarGerarNotaFiscalInvalida_requisito_5(){
        try{
            NotaFiscal nota = new NotaFiscal();
            nota.adicionarMercadoria("chocolate branco", 0.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Produto/Serviço inexistente"))
                fail();
        }
        try{
            NotaFiscal nota = new NotaFiscal();
            nota.adicionarMercadoria("3g", 0.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Produto/Serviço inexistente"))
                fail();
        }
        try{
            NotaFiscal nota = new NotaFiscal();
            nota.adicionarMercadoria("chocolate", -1.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Desconto inválido"))
                fail();
        }
        try{
            NotaFiscal nota = new NotaFiscal();
            nota.adicionarMercadoria("chocolate", 101.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Desconto inválido"))
                fail();
        }
        try{
            NotaFiscal nota = new NotaFiscal();
            nota.adicionarMercadoria("chocolate", 0.0, -1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Quantidade inválida"))
                fail();
        }
    }
}
