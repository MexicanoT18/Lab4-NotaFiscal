/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

import basededados.ValidadorNF;
import java.util.ArrayList;
import javafx.print.Collation;

/**
 *
 * @author Lucas
 */
public class NotaFiscal {
    private int _id;
    private String _data;
    private ArrayList<ItemDeVenda> _itens;
    private boolean _emElaboracao;
    
    public NotaFiscal(){
        _emElaboracao = true;
        _itens = new ArrayList<>();
        _id = -1;
        _data = "Em elaboração";
    }
    public NotaFiscal(int id, String data, ArrayList<ItemDeVenda> itens, boolean emElaboracao){
        _emElaboracao = emElaboracao;
        _itens = (ArrayList<ItemDeVenda>) itens.clone();
        _id = id;
        _data = data;
    }
    public NotaFiscal validar(){
        ValidadorNF validador = ValidadorNF.getInstancia();
        return validador.validar(this);
    }
    public double getValor(){
        double valor = 0.0;
        for (int i = 0; i < _itens.size(); i++) {
            valor += _itens.get(i).getValor();            
        }
        return valor;
    }
    public String getData(){
        return _data;
    }
    public void adicionarProduto(String nome){
        if (!_emElaboracao) return;
    }
    public void adicionarServico(String nome){
        if (!_emElaboracao) return;        
    }
}
