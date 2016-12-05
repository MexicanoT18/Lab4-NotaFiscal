/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import imposto.Porcentagem;
import imposto.ValorBruto;
import java.util.ArrayList;
import imposto.Imposto;
import imposto.ValorBrutoRelativo;
import java.util.List;
import notafiscal.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Lucas
 */
public class TaxCalculatorTestes {
    
    @Before
    public void setUp(){
        
    }
    
    @Test
    public void testarImpostosSimples_requisito_8(){
        Porcentagem porcentagem = new Porcentagem(0.0);
        assertEquals(10.0, porcentagem.aplicarImposto(10.0, null), 1e-9);
        assertEquals(20.0, porcentagem.aplicarImposto(20.0, null), 1e-9);
        
        porcentagem = new Porcentagem(0.1);
        assertEquals(11.0, porcentagem.aplicarImposto(10.0, null), 1e-9);
        assertEquals(22.0, porcentagem.aplicarImposto(20.0, null), 1e-9);
        
        porcentagem = new Porcentagem(0.2);
        assertEquals(12.0, porcentagem.aplicarImposto(10.0, null), 1e-9);
        assertEquals(24.0, porcentagem.aplicarImposto(20.0, null), 1e-9);
        
        porcentagem = new Porcentagem(1.0);
        assertEquals(20.0, porcentagem.aplicarImposto(10.0, null), 1e-9);
        assertEquals(40.0, porcentagem.aplicarImposto(20.0, null), 1e-9);
        
        ValorBruto bruto = new ValorBruto(0.0);
        assertEquals(10.0, bruto.aplicarImposto(10.0, null), 1e-9);
        assertEquals(20.0, bruto.aplicarImposto(20.0, null), 1e-9);
        
        bruto = new ValorBruto(10.0);
        assertEquals(20.0, bruto.aplicarImposto(10.0, null), 1e-9);
        assertEquals(30.0, bruto.aplicarImposto(20.0, null), 1e-9);
        
        bruto = new ValorBruto(100.0);
        assertEquals(110.0, bruto.aplicarImposto(10.0, null), 1e-9);
        assertEquals(120.0, bruto.aplicarImposto(20.0, null), 1e-9);
        
    }
    
    @Test
    public void testarImpostosEmSequencia_requisito_10(){
        List<Imposto> impostos = new ArrayList<>();
        Produto produto = new Produto(10.0, "dummy", new ArrayList<>(), impostos);      //preco inicial:           10
        impostos.add(new Imposto("imposto 1", new Porcentagem(0.5), produto));          //1o imposto (*1.5):       15
        impostos.add(new Imposto("imposto 2", new ValorBrutoRelativo(1.0), produto));   //2o imposto (+2*1):       17
        assertEquals(17.0, produto.getValor(), 1e-9);
        
        impostos = new ArrayList<>();
        produto = new Produto(10.0, "dummy", new ArrayList<>(), impostos);              //preco inicial:           10
        impostos.add(new Imposto("imposto 1", new ValorBruto(10.0), produto));          //1o imposto (+10):        20
        impostos.add(new Imposto("imposto 2", new Porcentagem(0.5), produto));          //2o imposto (*1.5):       30
        impostos.add(new Imposto("imposto 3", new ValorBrutoRelativo(1.0), produto));   //3o imposto (+3*1):       33
        assertEquals(33.0, produto.getValor(), 1e-9);
    }
}
