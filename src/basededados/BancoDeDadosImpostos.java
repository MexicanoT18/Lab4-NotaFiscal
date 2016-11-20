/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededados;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import notafiscal.Imposto;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosImpostos {
    
    private Map<String, ArrayList<String> > _impostosPorNome;
    private Map<String, Double> _impostos;
    
    public BancoDeDadosImpostos(){
        _impostosPorNome = DataGUI.getImpostosPorNomes();
        _impostos = DataGUI.getImpostos();
    }
    
    public Imposto getImposto(String nomeMercadoria) throws Exception{
        if (!_impostosPorNome.containsKey(nomeMercadoria)){
            throw new Exception("Mercadoria inexistente no banco de dados de impostos");
        }
        ArrayList<String> nomesImpostos = _impostosPorNome.get(nomeMercadoria);
        Map<String, Double> impostosMercadoria = new TreeMap<>();
        for(int i=0; i<nomesImpostos.size(); i++){
            String nomeImposto = nomesImpostos.get(i);
            if (!_impostos.containsKey(nomeImposto)){
                throw new Exception("Imposto inexistente no banco de dados de impostos");
            }
            double porcentagem = _impostos.get(nomeImposto);
            impostosMercadoria.put(nomeImposto, porcentagem);
        }
        Imposto imposto = new Imposto(impostosMercadoria);
        return imposto;
    }
}
