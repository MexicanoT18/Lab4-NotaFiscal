package imposto;

/**
 *
 * @author Lucas
 */
public interface TaxCalculator {    //DP Strategy, hook class
    public double aplicarImposto(double valor, Imposto imposto); //hook method
    public TaxCalculator clone();
    public boolean equals(Object object);
}
