/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import notafiscal.ItemDeVenda;
import notafiscal.Produto;
import notafiscal.Servico;

/**
 *
 * @author Lucas
 */
public class ItemDeVendaTestes {
    
    @Before
    public void setUp(){
        DataMocker.mockAll();
    }
    
    @Test
    public void testarGerarItemDeVendaProdutosValidos(){
        try{
            ItemDeVenda item = new ItemDeVenda("chocolate", 0.0, 1);
            Produto produto = (Produto)DataMocker.getMercadoria("chocolate");
            assertEquals(item.getNome(), "chocolate");
            assertEquals(item.getDesconto(), 0.0, 1e-9);
            assertEquals(item.getQuantidade(), 1);
            assertEquals(item.getValor(), produto.getValor(), 1e-9);
            assertEquals(item.getMercadoria(), produto);
            
            item = new ItemDeVenda("sorvete", 50.0, 1);
            produto = (Produto)DataMocker.getMercadoria("sorvete");
            assertEquals(item.getNome(), "sorvete");
            assertEquals(item.getDesconto(), 50.0, 1e-9);
            assertEquals(item.getQuantidade(), 1);
            assertEquals(item.getValor(), produto.getValor()/2.0, 1e-9);
            assertEquals(item.getMercadoria(), produto);
            
            item = new ItemDeVenda("caixa de doces", 25.0, 8);
            produto = (Produto)DataMocker.getMercadoria("caixa de doces");
            assertEquals(item.getNome(), "caixa de doces");
            assertEquals(item.getDesconto(), 25.0, 1e-9);
            assertEquals(item.getQuantidade(), 8);
            assertEquals(item.getValor(), produto.getValor()*6.0, 1e-9);
            assertEquals(item.getMercadoria(), produto);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarGerarItemDeVendaServicosValidos(){
        try{
            ItemDeVenda item = new ItemDeVenda("internet", 0.0, 1);
            Servico servico = (Servico)DataMocker.getMercadoria("internet");
            assertEquals(item.getNome(), "internet");
            assertEquals(item.getDesconto(), 0.0, 1e-9);
            assertEquals(item.getQuantidade(), 1);
            assertEquals(item.getValor(), servico.getValor(), 1e-9);
            assertEquals(item.getMercadoria(), servico);
            
            item = new ItemDeVenda("telefone", 25.0, 1);
            servico = (Servico)DataMocker.getMercadoria("telefone");
            assertEquals(item.getNome(), "telefone");
            assertEquals(item.getDesconto(), 25.0, 1e-9);
            assertEquals(item.getQuantidade(), 1);
            assertEquals(item.getValor(), servico.getValor()*0.75, 1e-9);
            assertEquals(item.getMercadoria(), servico);
            
            item = new ItemDeVenda("combo net", 10.0, 2);
            servico = (Servico)DataMocker.getMercadoria("combo net");
            assertEquals(item.getNome(), "combo net");
            assertEquals(item.getDesconto(), 10.0, 1e-9);
            assertEquals(item.getQuantidade(), 2);
            assertEquals(item.getValor(), servico.getValor()*1.8, 1e-9);
            assertEquals(item.getMercadoria(), servico);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testarGerarItemDeVendaInvalido(){
        try{
            ItemDeVenda item = new ItemDeVenda("chocolate branco", 0.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Produto/Serviço inexistente"))
                fail();
        }
        try{
            ItemDeVenda item = new ItemDeVenda("3g", 0.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Produto/Serviço inexistente"))
                fail();
        }
        try{
            ItemDeVenda item = new ItemDeVenda("chocolate", -1.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Desconto inválido"))
                fail();
        }
        try{
            ItemDeVenda item = new ItemDeVenda("chocolate", 101.0, 1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Desconto inválido"))
                fail();
        }
        try{
            ItemDeVenda item = new ItemDeVenda("chocolate", 0.0, -1);
            fail();
        } catch (Exception e){
            if (!e.getMessage().equals("Quantidade inválida"))
                fail();
        }
    }
}
