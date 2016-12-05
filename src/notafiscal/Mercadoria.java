package notafiscal;

import imposto.Imposto;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface Mercadoria {   //requisito 12
    public double getPreco();
    public double getValor();
    public String getNome();
    public List<Imposto> getImpostos();
    public List<Mercadoria> getSubmercadorias();    //requsito 4, 17
    public boolean equals(Object object);
}
