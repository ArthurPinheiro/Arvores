public class MapaHash{

    private Registro valores[];

    public MapaHash(){
        valores = new Registro[100];
    }

    public void put(Registro registro){
        int posicao = registro.hashCode();
        if (valores[posicao] == null){
            valores[posicao] = registro;
        }
        else{
            Registro reg = valores[posicao];
            // Tratar o primeiro elemento
            if (reg.getKey() == registro.getKey()){ // se o registro já existir, substituo o valor
                   reg.setValue(registro.getValue()); 
                   return;
            }
            // se ele tá no meio da lista
            while (reg.getProximo() != null){
                if (reg.getKey() == registro.getKey()){ // se o registro já existir, substituo o valor
                   reg.setValue(registro.getValue());
                   System.out.println("Tá no meio da lista - Registro Existente - atualizando...");
                   return;
                }
                reg = reg.getProximo(); 
            }

            // se ele é o último da lista
                if (reg.getKey() == registro.getKey()){
                    reg.setValue(registro.getValue());
                    return;
                }
            reg.setProximo(registro); // coloquei o novo registro na última posicao  
        }
    }
    
    public Registro get(int key){
        
        Registro r = new Registro();
        r.setKey(key);
        int posicao = r.hashCode(); // se a posição não existir, retorna null

        Registro resultado = valores[posicao]; // tento encontrar o registro
        if (resultado != null && resultado.getKey() == key){
            return resultado;
        }
        else{
            while (resultado != null){ // percorre a lista enquanto tiver elementos
                resultado = resultado.getProximo(); 
                if (resultado != null && resultado.getKey() == key){
                    return resultado; 
                }
            }
        }
        return null;
    }
}