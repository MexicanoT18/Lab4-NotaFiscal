package basededados;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import imposto.Imposto;
import java.util.List;
import notafiscal.Mercadoria;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosImpostos {
    
    private Map<String, ArrayList<String> > _impostosPorNome;
    private Map<String, Imposto> _impostos;
    
    BancoDeDadosImpostos(){
        _impostosPorNome = DataGUI.getImpostosPorNomes();
        _impostos = DataGUI.getImpostos();
    }
    
    public void getImposto(List<Imposto> impostos, Mercadoria mercadoria) throws Exception{
        String nomeMercadoria = mercadoria.getNome();
        
        if (!_impostosPorNome.containsKey(nomeMercadoria)){
            throw new Exception("Mercadoria inexistente no banco de dados de impostos");
        }
        
        ArrayList<String> nomesImpostos = _impostosPorNome.get(nomeMercadoria);
        for(int i=0; i<nomesImpostos.size(); i++){
            String nomeImposto = nomesImpostos.get(i);
            if (!_impostos.containsKey(nomeImposto)){
                throw new Exception("Imposto inexistente no banco de dados de impostos");
            }
            impostos.add(_impostos.get(nomeImposto).clone(mercadoria));
        }
    }
}
