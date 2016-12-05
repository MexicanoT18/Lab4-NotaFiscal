package imposto;

/**
 *
 * @author Lucas
 */
public interface TaxCalculator {    //requisito 9, 15: DP Strategy, hook class 
    public double aplicarImposto(double valor, Imposto imposto); //hook method
    public TaxCalculator clone();
    public boolean equals(Object object);
}
