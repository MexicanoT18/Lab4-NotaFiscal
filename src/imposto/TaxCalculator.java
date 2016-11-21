package imposto;

/**
 *
 * @author Lucas
 */
public interface TaxCalculator {    //DP Strategy, hook class
    public double aplicarImposto(double valor); //hook method
    public TaxCalculator clone();
    public boolean equals(Object object);
}
