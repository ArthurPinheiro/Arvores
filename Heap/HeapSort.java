public class HeapSort{


    public static void main(String[] args) {
        
        int[] lista = {19,5,18,68,44,10,36,74,28};

        System.out.print("Lista antes: ");

        for (int i : lista) {
            System.out.print(i + " ");
        }

        System.out.println();

        ordenar(lista);

        System.out.print("Lista depois: ");
        for (int i : lista) {
            System.out.print(i + " ");
        }

    }

    public static void ordenarArvore(int[] lista, int posicao, int tamanhoDoVetor){

        int indiceFilhoUm = 2 * posicao + 1;
        int indiceFilhoDois = indiceFilhoUm + 1;

        if(indiceFilhoUm < tamanhoDoVetor){
            if(indiceFilhoDois < tamanhoDoVetor){

                /**
                 * Se ainda estivermos dentro do vetor, teste qual o maior filho
                 */

                if(lista[indiceFilhoUm] < lista[indiceFilhoDois]){
                    indiceFilhoUm = indiceFilhoDois;
                }
            }

            /**
             * Comparação do filho um, com o nó pai
             */

            if(lista[indiceFilhoDois] > lista[posicao]){
                int aux = lista[indiceFilhoUm];
                lista[indiceFilhoUm] =  lista[posicao];
                lista[posicao] = aux;

                //Remontagem da árvore
                ordenarArvore(lista, indiceFilhoUm, tamanhoDoVetor);
            }
        }
    }

    public static void montarArvoreHeap(int[] lista){
        for(int posicao = (lista.length - 1) / 2; posicao >= 0; posicao--){
            ordenarArvore(lista, posicao, lista.length);
        }
    }

    public static void ordenar(int[] lista){

        //Montagem da árvore
        montarArvoreHeap(lista);

        int n = lista.length;

        /**
         * Para uma arvore de tamanho n, ordene-a n-1 vezes
         */
        for(int i = lista.length -1; i > 0; i--){
            int aux = lista[i];
            lista[i] = lista[0];
            lista[0] = aux;

            ordenarArvore(lista, 0, --n);
        }
    }

}