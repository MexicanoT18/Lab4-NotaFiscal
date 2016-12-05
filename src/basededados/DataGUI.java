package basededados;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import imposto.Imposto;
import imposto.Porcentagem;
import imposto.ValorBruto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class DataGUI {
    public static Map<String, ArrayList<String> > getImpostosPorNomes(){    //requisito 9
        Map<String, ArrayList<String> > nomes = new TreeMap<String, ArrayList<String>>();
        ArrayList<String> nomesImpostos;
        
        //chocolate
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre chocolate");
        nomesImpostos.add("imposto sobre doces");
        nomes.put("chocolate", nomesImpostos);
        
        //sorvete
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre sorvete");
        nomesImpostos.add("imposto sobre doces");
        nomes.put("sorvete", nomesImpostos);
        
        //caixa de doces
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre doces");
        nomes.put("caixa de doces", nomesImpostos);
        
        //internet
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre internet");
        nomesImpostos.add("imposto sobre comunicações");
        nomes.put("internet", nomesImpostos);
        
        //telefone
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre telefone");
        nomesImpostos.add("imposto sobre comunicações");
        nomes.put("telefone", nomesImpostos);
        
        //combo net
        nomesImpostos = new ArrayList<>();
        nomesImpostos.add("imposto sobre comunicações");
        nomes.put("combo net", nomesImpostos);
        return nomes;
    }
    public static Map<String, Imposto> getImpostos(){
        Map<String, Imposto> impostos = new TreeMap<String, Imposto>();
        Imposto imposto;
        
        //chocolate
        imposto = new Imposto("imposto sobre chocolate", new ValorBruto(1), null);
        impostos.put("imposto sobre chocolate", imposto);
        
        //sorvete
        imposto = new Imposto("imposto sobre sorvete", new ValorBruto(2), null);
        impostos.put("imposto sobre sorvete", imposto);
        
        //doces
        imposto = new Imposto("imposto sobre doces", new Porcentagem(0.15), null);
        impostos.put("imposto sobre doces", imposto);
        
        //internet
        imposto = new Imposto("imposto sobre internet", new ValorBruto(1), null);
        impostos.put("imposto sobre internet", imposto);
        
        //telefone
        imposto = new Imposto("imposto sobre telefone", new ValorBruto(3), null);
        impostos.put("imposto sobre telefone", imposto);
        
        //comunicações
        imposto = new Imposto("imposto sobre comunicações", new Porcentagem(0.2), null);
        impostos.put("imposto sobre comunicações", imposto);
        
        return impostos;
    }
    public static Map<String, Double> getPSPrecos(){
        Map<String, Double> precos = new TreeMap<>();
        precos.put("chocolate", 5.0);
        precos.put("sorvete", 20.0);
        precos.put("internet", 120.0);
        precos.put("telefone", 30.0);
        precos.put("caixa de doces", 0.0);
        precos.put("combo net", 0.0);
        return precos;
    }
    public static Map<String, ArrayList<String> > getPSSubmercadorias(){
        Map<String, ArrayList<String> > sub = new TreeMap<>();
        ArrayList<String> mercadorias;
        
        //chocolate
        mercadorias = new ArrayList<>();
        sub.put("chocolate", mercadorias);
        
        //sorvete
        mercadorias = new ArrayList<>();
        sub.put("sorvete", mercadorias);
        
        //internet
        mercadorias = new ArrayList<>();
        sub.put("internet", mercadorias);
        
        //telefone
        mercadorias = new ArrayList<>();
        sub.put("telefone", mercadorias);
        
        //combo net
        mercadorias = new ArrayList<>();
        mercadorias.add("internet");
        mercadorias.add("telefone");
        sub.put("combo net", mercadorias);
        
        //caixa de doces
        mercadorias = new ArrayList<>();
        mercadorias.add("chocolate");
        mercadorias.add("sorvete");
        sub.put("caixa de doces", mercadorias);
        
        return sub;
    }
    public static Set<String> getProdutos(){
        Set<String> produtos = new TreeSet<String>();
        produtos.add("sorvete");
        produtos.add("chocolate");
        produtos.add("caixa de doces");
        return produtos;
    }
    public static Set<String> getServicos(){
        Set<String> servicos = new TreeSet<String>();
        servicos.add("internet");
        servicos.add("telefone");
        servicos.add("combo net");
        return servicos;
    }
}
