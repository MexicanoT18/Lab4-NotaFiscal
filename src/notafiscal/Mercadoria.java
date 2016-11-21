package notafiscal;

import imposto.Imposto;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface Mercadoria {
    public double getPreco();
    public double getValor();
    public String getNome();
    public List<Imposto> getImpostos();
    public List<Mercadoria> getSubmercadorias();
    public boolean equals(Object object);
}
