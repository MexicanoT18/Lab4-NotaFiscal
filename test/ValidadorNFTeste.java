
import java.util.ArrayList;
import java.util.List;
import notafiscal.ValidadorNF;
import notafiscal.NotaFiscal;
import basededados.BancoDeDados;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class ValidadorNFTeste {
    @Before
    public void setUp(){
        DataMocker.mockAll();
    }
    
    @Test
    public void testarValidacaoBemSucedida_requsito_6(){
        assertEquals(0, ValidadorNF.getInstancia().getNumeroNotasEmitidas());
        BancoDeDados banco = BancoDeDados.getInstancia();
        
        try{      
            NotaFiscal nota = new NotaFiscal();      
            nota.adicionarMercadoria("chocolate", 0.0, 1);
            nota.validar();
            assertEquals(1, ValidadorNF.getInstancia().getNumeroNotasEmitidas());
            assertEquals(1, nota.getId());
        } catch (Exception e){
            fail(e.getMessage());
        }
        
        try{      
            NotaFiscal nota = new NotaFiscal();      
            nota.adicionarMercadoria("sorvete", 50.0, 1);
            nota.validar();
            assertEquals(2, ValidadorNF.getInstancia().getNumeroNotasEmitidas());
            assertEquals(2, nota.getId());
        } catch (Exception e){
            fail(e.getMessage());
        }
        
        try{      
            NotaFiscal nota = new NotaFiscal();      
            nota.adicionarMercadoria("caixa de doces", 25.0, 8);
            nota.validar();
            assertEquals(3, ValidadorNF.getInstancia().getNumeroNotasEmitidas());
            assertEquals(3, nota.getId());
        } catch (Exception e){
            fail(e.getMessage());
        }
        
        try{      
            NotaFiscal nota = new NotaFiscal();      
            nota.adicionarMercadoria("internet", 0.0, 1);
            nota.validar();
            assertEquals(4, ValidadorNF.getInstancia().getNumeroNotasEmitidas());
            assertEquals(4, nota.getId());
        } catch (Exception e){
            fail(e.getMessage());
        }
        
        try{      
            NotaFiscal nota = new NotaFiscal();      
            nota.adicionarMercadoria("telefone", 25.0, 1);
            banco.registrarId(5);
            nota.validar();
            assertEquals(5, ValidadorNF.getInstancia().getNumeroNotasEmitidas());
            assertEquals(6, nota.getId());
        } catch (Exception e){
            fail(e.getMessage());
        }
        
        try{      
            NotaFiscal nota = new NotaFiscal();      
            nota.adicionarMercadoria("combo net", 10.0, 2);
            banco.registrarId(7);
            nota.validar();
            assertEquals(6, ValidadorNF.getInstancia().getNumeroNotasEmitidas());
            assertEquals(8, nota.getId());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarValidacaoMalSucedidaNotaVazia_requisito_1_6(){
        try{
            NotaFiscal nota = new NotaFiscal();
            nota.validar();
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Nota fiscal inválida"))
                fail(e.getMessage());
        }
    }
    
    @Test
    public void testarValidacaoMalSucedidaNotaJaValidada_requisito_7(){
        try{
            NotaFiscal nota = new NotaFiscal();
            nota.adicionarMercadoria("combo net", 10.0, 2);
            nota.validar();
            nota.adicionarMercadoria("telefone", 25.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Nota já validada"))
                fail(e.getMessage());
        }
        try{
            NotaFiscal nota = new NotaFiscal();
            nota.adicionarMercadoria("combo net", 10.0, 2);
            nota.validar();
            nota.validar();
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Nota já validada"))
                fail(e.getMessage());
        }
    }
}
