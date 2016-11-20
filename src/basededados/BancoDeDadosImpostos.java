/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededados;

import java.util.TreeMap;
import notafiscal.Imposto;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosImpostos {
    
    private TreeMap<String, String> _nomes;
    private TreeMap<String, Double> _porcentagens;
    
    public BancoDeDadosImpostos(){
        _nomes = DataMocker.getImpostosNomes();
        _porcentagens = DataMocker.getImpostosPorcentagens();
    }
    
    public Imposto getImposto(String nome){
        Imposto imposto = new Imposto(_porcentagens.get(nome), _nomes.get(nome));
        return imposto;
    }
}
