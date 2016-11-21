package basededados;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Lucas
 */
public class BancoDeDadosNotaFiscal {
    private Set<Integer> _idsRegistrados;
    
    BancoDeDadosNotaFiscal(){
        _idsRegistrados = new TreeSet<>();
    }
    
    public boolean existeId(int id){
        return _idsRegistrados.contains(id);
    }
    
    public void registrarId(int id) throws Exception{
        if (existeId(id)){
            throw new Exception("Id já registrado");
        }
        _idsRegistrados.add(id);
    }
}
