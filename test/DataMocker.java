import java.util.ArrayList;
import imposto.Imposto;
import imposto.Porcentagem;
import imposto.ValorBruto;
import java.util.List;
import notafiscal.Mercadoria;
import notafiscal.Produto;
import notafiscal.Servico;

/**
 *
 * @author Lucas
 */
public class DataMocker {
    
    private static Produto _sorvete;
    private static List<Imposto> _impostosSorvete;
    private static Produto _chocolate;
    private static List<Imposto> _impostosChocolate;
    private static Servico _internet;
    private static List<Imposto> _impostosInternet;
    private static Servico _telefone;
    private static List<Imposto> _impostosTelefone;
    private static Produto _caixaDoces;
    private static List<Imposto> _impostosCaixaDoces;
    private static Servico _comboNet;
    private static List<Imposto> _impostosComboNet;
    
    public static void mockAll(){
        List<Imposto> impostos;
        ArrayList<Mercadoria> submercadorias;
        
        //sorvete
        impostos =  new ArrayList<>();
        _impostosSorvete = impostos;
        submercadorias = new ArrayList<>();
        _sorvete = new Produto(20.0, "sorvete", submercadorias, _impostosSorvete);
        impostos.add(new Imposto("imposto sobre sorvete", new ValorBruto(2), _sorvete));
        impostos.add(new Imposto("imposto sobre doces", new Porcentagem(0.15), _sorvete));
        
        //chocolate
        impostos =  new ArrayList<>();
        _impostosChocolate = impostos;
        submercadorias = new ArrayList<>();
        _chocolate = new Produto(5.0, "chocolate", submercadorias, _impostosChocolate);
        impostos.add(new Imposto("imposto sobre chocolate", new ValorBruto(1), _chocolate));
        impostos.add(new Imposto("imposto sobre doces", new Porcentagem(0.15), _chocolate));
        
        //internet
        impostos =  new ArrayList<>();
        _impostosInternet = impostos;
        submercadorias = new ArrayList<>();
        _internet = new Servico(120.0, "internet", submercadorias, _impostosInternet);
        impostos.add(new Imposto("imposto sobre internet", new ValorBruto(1), _internet));
        impostos.add(new Imposto("imposto sobre comunicações", new Porcentagem(0.2), _internet));
        
        //telefone
        impostos =  new ArrayList<>();
        _impostosTelefone = impostos;
        submercadorias = new ArrayList<>();
        _telefone = new Servico(30.0, "telefone", submercadorias, _impostosTelefone);
        impostos.add(new Imposto("imposto sobre telefone", new ValorBruto(3), _telefone));
        impostos.add(new Imposto("imposto sobre comunicações", new Porcentagem(0.2), _telefone));
        
        //combo net
        impostos =  new ArrayList<>();
        _impostosComboNet = impostos;
        submercadorias = new ArrayList<>();
        submercadorias.add(_internet);
        submercadorias.add(_telefone);
        _comboNet = new Servico(0.0, "combo net", submercadorias, _impostosComboNet);
        impostos.add(new Imposto("imposto sobre comunicações", new Porcentagem(0.2), _comboNet));
        
        //caixa de doces
        impostos =  new ArrayList<>();
        _impostosCaixaDoces = impostos;
        submercadorias = new ArrayList<>();
        submercadorias.add(_chocolate);
        submercadorias.add(_sorvete);
        _caixaDoces = new Produto(0.0, "caixa de doces", submercadorias, _impostosCaixaDoces);
        impostos.add(new Imposto("imposto sobre doces", new Porcentagem(0.15), _caixaDoces));
        
    }
    
    public static List<Imposto> getImposto(String nome){
        if (nome.equals("sorvete")){
            return _impostosSorvete;
        }
        if (nome.equals("chocolate")){
            return _impostosChocolate;
        }
        if (nome.equals("internet")){
            return _impostosInternet;
        }
        if (nome.equals("telefone")){
            return _impostosTelefone;
        }
        if (nome.equals("combo net")){
            return _impostosComboNet;
        }
        if (nome.equals("caixa de doces")){
            return _impostosCaixaDoces;
        }
        return null;
    }
    
    public static Mercadoria getMercadoria(String nome){
        if (nome.equals("sorvete")){
            return _sorvete;
        }
        if (nome.equals("chocolate")){
            return _chocolate;
        }
        if (nome.equals("internet")){
            return _internet;
        }
        if (nome.equals("telefone")){
            return _telefone;
        }
        if (nome.equals("combo net")){
            return _comboNet;
        }
        if (nome.equals("caixa de doces")){
            return _caixaDoces;
        }
        return null;
    }
}
