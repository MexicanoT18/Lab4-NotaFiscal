/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import basededados.BancoDeDadosImpostos;
import java.util.Map;
import java.util.TreeMap;
import notafiscal.Imposto;
import notafiscal.Produto;
import notafiscal.Servico;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosImpostosTestes {
    
    BancoDeDadosImpostos _banco;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Before
    public void setUp(){
        DataMocker.mockAll();
        _banco = new BancoDeDadosImpostos();
    }
    
    @Test
    public void testarImpostoSorvete(){
        Imposto esperado = DataMocker.getImposto("sorvete");
        try{
            Imposto teste = _banco.getImposto("sorvete");
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }
    
    @Test
    public void testarImpostoChocolate(){
        Imposto esperado = DataMocker.getImposto("chocolate");
        try{
            Imposto teste = _banco.getImposto("chocolate");
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }
    
    @Test
    public void testarImpostoTelefone(){
        Imposto esperado = DataMocker.getImposto("telefone");
        try{
            Imposto teste = _banco.getImposto("telefone");
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }
    
    @Test
    public void testarImpostoInternet(){
        Imposto esperado = DataMocker.getImposto("internet");
        try{
            Imposto teste = _banco.getImposto("internet");
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }
    
    @Test
    public void testarImpostoCaixaDeDoces(){
        Imposto esperado = DataMocker.getImposto("caixa de doces");
        try{
            Imposto teste = _banco.getImposto("caixa de doces");
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }
    
    @Test
    public void testarImpostoComboNet(){
        Imposto esperado = DataMocker.getImposto("combo net");
        try{
            Imposto teste = _banco.getImposto("combo net");
            assertTrue(teste.equals(esperado));
        } catch(Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }
}
