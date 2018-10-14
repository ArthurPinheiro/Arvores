public class ArvoreDePesquisa extends Arvore{

    Elemento elemento;
    Arvore esquerda, direita;

    public boolean isEmpty(){
        return this.elemento == null;
    }

    public void inserir(Elemento novo){
        if(isEmpty()){
            this.elemento = novo;
        }else{
            Arvore novaArvore = new Arvore(novo);

            if(novo.getValor() < this.elemento.getValor()){ // inserir na decendencia da esquerda
                if(this.getEsquerda() == null){ // se for nó folha inseri
                    this.esquerda = novaArvore;
                }else{
                    this.esquerda.inserir(novo); // sub-arvore da esquerda
                }

            } else if(novo.getValor() > this.elemento.getValor()){
                if(this.direita == null){
                    this.direita = novaArvore;
                } else{
                    this.direita.inserir(novo);
                }
            }
        }  
    } 

}