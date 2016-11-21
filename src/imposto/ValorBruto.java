package imposto;

/**
 *
 * @author Lucas
 */
public final class ValorBruto implements TaxCalculator{
    
    private double _bruto;
    
    public ValorBruto(double bruto){
        _bruto = bruto;
    }
    
    @Override
    public double aplicarImposto(double valor){
        return valor + _bruto;
    }
    
    @Override
    public TaxCalculator clone(){
        return new ValorBruto(_bruto);
    }
    
    public double getBruto(){
        return _bruto;
    }
    
    @Override
    public boolean equals(Object object){
        if (!(object instanceof ValorBruto)) return false;
        ValorBruto outro = (ValorBruto) object;
        
        return Math.abs(_bruto - outro.getBruto()) < 1e-9;
    }
}
