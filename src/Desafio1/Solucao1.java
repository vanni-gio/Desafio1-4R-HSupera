package Desafio1;

import java.util.LinkedList;

public class Solucao1 {

    // Considerando a entrada de valores inteiros não negativos, ordene estes valores segundo
    //    o seguinte critério:
    //      • Primeiro os Pares
    //      • Depois os Ímpares
    // Sendo que deverão ser apresentados os pares em ordem crescente e depois os ímpares
    // em ordem decrescente.
    // Entrada
    // A primeira linha de entrada contém um único inteiro positivo N (1 < N <= 105) Este é o
    // número de linhas de entrada que vem logo a seguir. As próximas N linhas conterão, cada
    // uma delas, um valor inteiro não negativo.
    // Saída
    // Apresente todos os valores lidos na entrada segundo a ordem apresentada acima. Cada
    // número deve ser impresso em uma linha, conforme exemplo abaixo.
    public Solucao1 (long[] entradas){
        LinkedList<Long> listaPar = new LinkedList<Long>();
        LinkedList<Long> listaImpar = new LinkedList<Long>();
       
        for (int i = 0; i < entradas.length; i++) {

            if(entradas[i]%2 == 0){ // se par
                this.inserirOrdenadoPorCategoria(listaPar, entradas[i], true);
            }else{ // se impar
                this.inserirOrdenadoPorCategoria(listaImpar, entradas[i], false);
            }
        }

        listaPar.addAll(listaImpar); //concatena as duas listas
        
        //imprime a lista
        listaPar.forEach((e) -> {
            System.out.println(e);
        });

    }

    // insere um elemento em uma lista, caso o elemento for par é inserido em ordem crescente, caso contrário se for ìmpar
    private void inserirOrdenadoPorCategoria(LinkedList<Long> list, Long element, boolean ispar){
        // procura o indice para inserir o elemento.
        int indexToAdd = 0;
        for (Long e : list) {
            if(ispar){
                // insere em ordem crescente
                if(element <= e){
                    indexToAdd = list.indexOf(e);
                    break;
                }else{
                    indexToAdd++;
                }
            }else{
                // insere em ordem decrescente
                if(element >= e){
                    indexToAdd = list.indexOf(e);
                    break;
                }else{
                    indexToAdd++;
                }
            }
        }
        list.add(indexToAdd, element);
    }
}
