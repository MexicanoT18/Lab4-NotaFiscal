package imposto;

/**
 *
 * @author Lucas
 */
public final class Porcentagem implements TaxCalculator{
    
    private double _porcentagem;
    
    public Porcentagem(double porcentagem){
        _porcentagem = porcentagem;
    }
    
    @Override
    public double aplicarImposto(double valor){
        return valor*(1+_porcentagem);
    }
    
    @Override
    public TaxCalculator clone(){
        return new Porcentagem(_porcentagem);
    }
    
    public double getPorcentagem(){
        return _porcentagem;
    }
    
    @Override
    public boolean equals(Object object){
        if (!(object instanceof Porcentagem)) return false;
        Porcentagem outro = (Porcentagem) object;
        
        return Math.abs(_porcentagem - outro.getPorcentagem()) < 1e-9;
    }
    
}
