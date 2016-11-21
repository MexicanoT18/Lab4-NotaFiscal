/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notafiscal;

import java.util.List;

/**
 *
 * @author Lucas
 */
public interface Mercadoria {
    public double getPreco();
    public String getNome();
    public Imposto getImposto();
    public List<Mercadoria> getSubmercadorias();
}
