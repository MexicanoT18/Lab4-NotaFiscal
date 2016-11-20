package basededados;


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
    public static TreeMap<String, String> getImpostosNomes(){
        TreeMap<String, String> nomes = mock(TreeMap.class);
        when(nomes.get("chocolate")).thenReturn("Imposto sobre chocolate");
        when(nomes.get("sorvete")).thenReturn("Imposto sobre sorvete");
        when(nomes.get("internet")).thenReturn("Imposto sobre internet");
        when(nomes.get("transporte")).thenReturn("Imposto sobre transporte");
        return nomes;
    }
    public static TreeMap<String, Double> getImpostosPorcentagens(){
        TreeMap<String, Double> precos = mock(TreeMap.class);
        when(precos.get("chocolate")).thenReturn(0.1);
        when(precos.get("sorvete")).thenReturn(0.2);
        when(precos.get("internet")).thenReturn(0.3);
        when(precos.get("transporte")).thenReturn(0.4);
        return precos;
    }
    public static TreeMap<String, Double> getPSPrecos(){
        TreeMap<String, Double> precos = mock(TreeMap.class);
        when(precos.get("chocolate")).thenReturn(5.0);
        when(precos.get("sorvete")).thenReturn(20.0);
        when(precos.get("internet")).thenReturn(120.0);
        when(precos.get("transporte")).thenReturn(30.0);
        return precos;
    }
}
