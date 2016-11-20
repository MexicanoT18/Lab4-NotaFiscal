package basededados;


import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class DataMocker {
    public static Map<String, ArrayList<String> > getImpostosPorNomes(){
        Map<String, ArrayList<String> > nomes = mock(TreeMap.class);
        ArrayList<String> nomesImpostos;
        
        //chocolate
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre chocolate");
        nomesImpostos.add("imposto sobre doces");
        when(nomes.get("chocolate")).thenReturn(nomesImpostos);
        
        //sorvete
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre sorvete");
        nomesImpostos.add("imposto sobre doces");
        when(nomes.get("sorvete")).thenReturn(nomesImpostos);
        
        //internet
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre internet");
        nomesImpostos.add("imposto sobre comunicações");
        when(nomes.get("internet")).thenReturn(nomesImpostos);
        
        //telefone
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre telefone");
        nomesImpostos.add("imposto sobre comunicações");
        when(nomes.get("telefone")).thenReturn(nomesImpostos);
        return nomes;
    }
    public static Map<String, Double> getImpostos(){
        Map<String, Double> precos = mock(TreeMap.class);
        when(precos.get("imposto sobre chocolate")).thenReturn(0.1);
        when(precos.get("imposto sobre sorvete")).thenReturn(0.2);
        when(precos.get("imposto sobre doces")).thenReturn(0.15);
        when(precos.get("imposto sobre internet")).thenReturn(0.1);
        when(precos.get("imposto sobre telefone")).thenReturn(0.3);
        when(precos.get("imposto sobre comunicações")).thenReturn(0.2);
        return precos;
    }
    public static TreeMap<String, Double> getPSPrecos(){
        TreeMap<String, Double> precos = mock(TreeMap.class);
        when(precos.get("chocolate")).thenReturn(5.0);
        when(precos.get("sorvete")).thenReturn(20.0);
        when(precos.get("internet")).thenReturn(120.0);
        when(precos.get("telefone")).thenReturn(30.0);
        return precos;
    }
}
