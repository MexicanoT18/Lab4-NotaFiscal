import basededados.BancoDeDadosImpostos;
import java.util.Map;
import java.util.TreeMap;
import imposto.Imposto;
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
public class BancoDeDadosImpostosTestes {
    
    BancoDeDadosImpostos _banco;
    
    @Before
    public void setUp(){
        DataMocker.mockAll();
        _banco = new BancoDeDadosImpostos();
    }
    
    @Test
    public void testarGerarImpostoProduto_requisito_8(){
        List<Imposto> esperado = DataMocker.getImposto("sorvete");
        try{
            List<Imposto> teste = new ArrayList<>();
            _banco.getImposto(teste, DataMocker.getMercadoria("sorvete"));
            assertEquals(teste.size(), esperado.size());
            for(int i=0; i<teste.size(); i++){
                assertEquals(esperado.get(i).getNome() + "/" + teste.get(i).getNome(), esperado.get(i), teste.get(i));
            }
        } catch(Exception e){
            fail(e.getMessage());
        }
        esperado = DataMocker.getImposto("chocolate");
        try{
            List<Imposto> teste = new ArrayList<>();
            _banco.getImposto(teste, DataMocker.getMercadoria("chocolate"));
            assertEquals(teste.size(), esperado.size());
            for(int i=0; i<teste.size(); i++){
                assertEquals(esperado.get(i).getNome() + "/" + teste.get(i).getNome(), esperado.get(i), teste.get(i));
            }
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarGerarImpostoServico_requisito_8(){
        List<Imposto> esperado = DataMocker.getImposto("telefone");
        try{
            List<Imposto> teste = new ArrayList<>();
            _banco.getImposto(teste, DataMocker.getMercadoria("telefone"));
            assertEquals(teste.size(), esperado.size());
            for(int i=0; i<teste.size(); i++){
                assertEquals(esperado.get(i).getNome() + "/" + teste.get(i).getNome(), esperado.get(i), teste.get(i));
            }
        } catch(Exception e){
            fail(e.getMessage());
        }
        esperado = DataMocker.getImposto("internet");
        try{
            List<Imposto> teste = new ArrayList<>();
            _banco.getImposto(teste, DataMocker.getMercadoria("internet"));
            assertEquals(teste.size(), esperado.size());
            for(int i=0; i<teste.size(); i++){
                assertEquals(esperado.get(i).getNome() + "/" + teste.get(i).getNome(), esperado.get(i), teste.get(i));
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarGerarImpostoMercadoriaComposta_requisito_8_17(){
        List<Imposto> esperado = DataMocker.getImposto("caixa de doces");
        try{
            List<Imposto> teste = new ArrayList<>();
            _banco.getImposto(teste, DataMocker.getMercadoria("caixa de doces"));
            assertEquals(teste.size(), esperado.size());
            for(int i=0; i<teste.size(); i++){
                assertEquals(esperado.get(i).getNome() + "/" + teste.get(i).getNome(), esperado.get(i), teste.get(i));
            }
        } catch(Exception e){
            fail(e.getMessage());
        }
        esperado = DataMocker.getImposto("combo net");
        try{
            List<Imposto> teste = new ArrayList<>();
            _banco.getImposto(teste, DataMocker.getMercadoria("combo net"));
            assertEquals(teste.size(), esperado.size());
            for(int i=0; i<teste.size(); i++){
                assertEquals(esperado.get(i).getNome() + "/" + teste.get(i).getNome(), esperado.get(i), teste.get(i));
            }
        } catch(Exception e){
            fail(e.getMessage());
        }
    }
}
