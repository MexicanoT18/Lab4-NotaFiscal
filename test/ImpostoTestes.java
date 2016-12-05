import imposto.Imposto;
import imposto.Porcentagem;
import imposto.ValorBruto;
import java.util.ArrayList;
import java.util.List;
import notafiscal.Produto;
import notafiscal.Servico;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Lucas
 */
public class ImpostoTestes {
    
    @Before
    public void setUp(){
    }
    
    @Test
    public void testarMetodosImpostos_requisito_8(){
        List<Imposto> impostos = new ArrayList<>();
        Produto produto = new Produto(10.0, "dummy 1", new ArrayList<>(), impostos);
        Imposto imposto1 = new Imposto("imposto 1", new Porcentagem(0.1), produto);
        impostos.add(imposto1);
        assertEquals(imposto1.getCalculator(), new Porcentagem(0.1));
        assertEquals(imposto1.getNome(), "imposto 1");
        assertEquals(imposto1.getValor(10.0), 11.0, 1e-9);
        assertEquals(imposto1.getMercadoria(), produto);
        
        impostos = new ArrayList<>();
        Servico servico = new Servico(20.0, "dummy 2", new ArrayList<>(), impostos);
        Imposto imposto2 = new Imposto("imposto 2", new ValorBruto(10.0), servico);
        impostos.add(imposto2);
        assertEquals(imposto2.getCalculator(), new ValorBruto(10.0));
        assertEquals(imposto2.getNome(), "imposto 2");
        assertEquals(imposto2.getValor(20.0), 30.0, 1e-9);
        assertEquals(imposto2.getMercadoria(), servico);
    }
}
