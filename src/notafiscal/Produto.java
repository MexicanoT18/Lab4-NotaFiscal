/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

/**
 *
 * @author Lucas
 */
public class Produto implements Mercadoria{
    public double getPreco(){
        return 0.0; //dummy
    }
    public String getNome(){
        return "Papel"; //dummy
    }
    public Imposto getImposto(){
        return null;    //dummy
    }
    
}
