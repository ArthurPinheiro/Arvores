public class Registro{

    private int key;
    private String value;
    Registro proximo;

    public Registro(){
        this.proximo = null;
    }

    public Registro(int key, String value){
        this.key = key;
        this.value = value;
        this.proximo = null;
    }

    public void setKey(int key){
        this.key = key;
    }
    public int getKey(){
        return this.key;
    }

    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }

    public void setProximo(Registro proximo){
        this.proximo = proximo;
    }
    public Registro getProximo(){
        return this.proximo;
    }
    
    public int hashCode(){
        return key % 100;
    }

}