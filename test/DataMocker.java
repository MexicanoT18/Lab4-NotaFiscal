
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import notafiscal.Imposto;
import notafiscal.Mercadoria;
import notafiscal.Produto;
import notafiscal.Servico;

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
    
    private static Produto _sorvete;
    private static Imposto _impostoSorvete;
    private static Produto _chocolate;
    private static Imposto _impostoChocolate;
    private static Servico _internet;
    private static Imposto _impostoInternet;
    private static Servico _telefone;
    private static Imposto _impostoTelefone;
    private static Produto _caixaDoces;
    private static Imposto _impostoCaixaDoces;
    private static Servico _comboNet;
    private static Imposto _impostoComboNet;
    
    public static void mockAll(){
        Map<String, Double> map;
        ArrayList<Mercadoria> submercadorias;
        
        //sorvete
        map = new TreeMap<>();
        map.put("imposto sobre sorvete", 0.2);
        map.put("imposto sobre doces", 0.15);
        _impostoSorvete = new Imposto(map);
        submercadorias = new ArrayList<>();
        _sorvete = new Produto(20.0, "sorvete", _impostoSorvete, submercadorias);
        
        //chocolate
        map = new TreeMap<>();
        map.put("imposto sobre chocolate", 0.1);
        map.put("imposto sobre doces", 0.15);
        _impostoChocolate = new Imposto(map);
        submercadorias = new ArrayList<>();
        _chocolate = new Produto(5.0, "chocolate", _impostoChocolate, submercadorias);
        
        //internet
        map = new TreeMap<>();
        map.put("imposto sobre internet", 0.1);
        map.put("imposto sobre comunicações", 0.2);
        _impostoInternet = new Imposto(map);
        submercadorias = new ArrayList<>();
        _internet = new Servico(120.0, "internet", _impostoInternet, submercadorias);
        
        //telefone
        map = new TreeMap<>();
        map.put("imposto sobre telefone", 0.3);
        map.put("imposto sobre comunicações", 0.2);
        _impostoTelefone = new Imposto(map);
        submercadorias = new ArrayList<>();
        _telefone = new Servico(30.0, "telefone", _impostoTelefone, submercadorias);
        
        //combo net
        map = new TreeMap<>();
        _impostoComboNet = new Imposto(map);
        submercadorias = new ArrayList<>();
        submercadorias.add(_internet);
        submercadorias.add(_telefone);
        _comboNet = new Servico(0.0, "combo net", _impostoComboNet, submercadorias);
        
        //caixa de doces
        map = new TreeMap<>();
        _impostoCaixaDoces = new Imposto(map);
        submercadorias = new ArrayList<>();
        submercadorias.add(_chocolate);
        submercadorias.add(_sorvete);
        _caixaDoces = new Produto(0.0, "caixa de doces", _impostoCaixaDoces, submercadorias);
        
    }
    
    public static Imposto getImposto(String nome){
        if (nome.equals("sorvete")){
            return _impostoSorvete;
        }
        if (nome.equals("chocolate")){
            return _impostoChocolate;
        }
        if (nome.equals("internet")){
            return _impostoInternet;
        }
        if (nome.equals("telefone")){
            return _impostoTelefone;
        }
        if (nome.equals("combo net")){
            return _impostoComboNet;
        }
        if (nome.equals("caixa de doces")){
            return _impostoCaixaDoces;
        }
        return null;
    }
    
    public static Mercadoria getMercadoria(String nome){
        if (nome.equals("sorvete")){
            return _sorvete;
        }
        if (nome.equals("chocolate")){
            return _chocolate;
        }
        if (nome.equals("internet")){
            return _internet;
        }
        if (nome.equals("telefone")){
            return _telefone;
        }
        if (nome.equals("combo net")){
            return _comboNet;
        }
        if (nome.equals("caixa de doces")){
            return _caixaDoces;
        }
        return null;
    }
}
