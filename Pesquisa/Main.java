public class Main{
    public static void main(String[] args) {
        
        Arvore arvore = new Arvore( new Elemento(10));
        
        arvore.inserir(new Elemento(5));
        arvore.inserir(new Elemento(1));
        arvore.inserir(new Elemento(8));
        arvore.inserir(new Elemento(12));
        arvore.inserir(new Elemento(15));
        arvore.inserir(new Elemento(18));
       /* 
        System.out.println("O elemento 5  " + (arvore.busca(5) ? "existe ": " não existe"));
        System.out.println("O elemento 12  " + (arvore.busca(12) ? "existe ": " não existe"));
        System.out.println("O elemento 54  " + (arvore.busca(54) ? "existe ": " não existe"));
       */

       arvore.preOrdem();
       System.out.println(" ");

       arvore.inOrdem();
       System.out.println(" ");

       arvore.posOrdem();
       System.out.println(" ");

       arvore.inOrdemInvertido();
       System.out.println(" ");
    }
}

