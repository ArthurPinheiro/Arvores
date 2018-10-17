public class Arvore{

    private Elemento elemento;
    private Arvore esquerda;
    private Arvore direita;

    public Arvore(){
        this.elemento = null;
        this.esquerda = null;
        this.direita  = null;
    }

    public Arvore(Elemento elemento){
        this.elemento = elemento;
        this.esquerda = null;
        this.direita  = null;

      //  System.out.println("Criei a arvore com o elemento " + elemento.getValor());
    }

    public void setEsquerda(Arvore esquerda){
        this.esquerda = esquerda;
    }

    public void setDireita(Arvore direita){
        this.direita = direita;
    }

    public void setElemento(Elemento elemento){
        this.elemento = elemento;
    }

    public Arvore getEsquerda(){
        return this.esquerda;
    }

    public Arvore getDireita(){
        return this.direita;
    }

    public Elemento getElemento(){
        return this.elemento;
    }

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
                   // System.out.println("Inseri o elemento " + novo.getValor() + " a esquerda de " + this.elemento.getValor());
                }else{
                    this.esquerda.inserir(novo); // sub-arvore da esquerda
                }

            } else if(novo.getValor() > this.elemento.getValor()){
                if(this.direita == null){
                    this.direita = novaArvore;
                    //System.out.println("Inseri o elemento " + novo.getValor() + " a direita de " + this.elemento.getValor());
                } else{
                    this.direita.inserir(novo);
                }
            }
        }  
    }
    
    public Arvore remover(Elemento elem){
         //primeiro elemento 
        if(this.elemento.getValor() == elem.getValor()){

            if(this.direita == null && this.esquerda == null){
                return null;
            }
            else{
                // Filhos a esquerda, mas não tem a direita.
                if(this.esquerda != null && this.direita == null){
                    return this.esquerda;
                }
                // Filhos a direita, mas não tem a esquerda.
                else if(this.direita != null && this.esquerda == null){
                    return this.direita;
                }
                else{
                    Arvore aux = this.esquerda;
                    while(aux.direita != null){ // enquanto houver filhos a direita
                        aux = aux.direita;
                    }
                    //troca os elementos da arvore
                    this.elem = aux.getElemento(); // o nó atual recebe o elemento do aux
                                                   // o maior dentre os menores 
                    aux.setElemento(elem);         // insiro o nó folha, o elemento a ser eliminado
                    this.esquerda = esquerda.remover(elem);
                }
            }

        } 
        else if(elem.getValor() < this.elemento.getValor()){
            //sub arvore da esquerda
            this.esquerda = this.esquerda.remover(elem);
        }
        else if(elem.getValor() > this.elemento.getValor()){
            //sub arvore da direita
            this.direita = this.direita.remover(elem);
        }

        return this;

    }

    public boolean busca(int valor){
        if(isEmpty()){
            return false;
        }
        if(this.elemento.getValor() == valor){
            return true;
        } else{
            if(valor < this.elemento.getValor()){
                if(this.esquerda == null){
                    return false;
                } else {
                    return this.esquerda.busca(valor);
                }
            }
            else if(valor > this.elemento.getValor()){
                if(this.direita == null){
                    return false;
                } else {
                    return this.direita.busca(valor);
                }
            }
        } 
        return false;
    }

    public void preOrdem(){
        if(!isEmpty()){
            System.out.print(this.elemento.getValor() + " ");
            if(this.esquerda != null){
                this.esquerda.preOrdem();
            }
            if(this.direita != null){
                this.direita.preOrdem();
            }
        }
    }

    public void inOrdem(){
        if(!isEmpty()){
            if(this.esquerda != null){
                this.esquerda.inOrdem();
            }
            System.out.print(this.elemento.getValor() + " ");
            if(this.direita != null){
                this.direita.inOrdem();
            }
        }
    }

    public void posOrdem(){
        if(!isEmpty()){
            if(this.direita != null){
                this.direita.posOrdem();
            }
            if(this.esquerda != null){
                this.esquerda.posOrdem();
            }

            System.out.print(this.elemento.getValor() + " ");
        }
    }

    public void inOrdemInvertido(){
        if(!isEmpty()){
            if(this.direita != null){
                this.direita.inOrdemInvertido();
            }

            System.out.print(this.elemento.getValor() + " ");

            if(this.esquerda != null){
                this.esquerda.inOrdemInvertido();
            }
        }
    }
}