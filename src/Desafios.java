import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Desafios {
    private Scanner scanner;
    public Desafios(){
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    public void closeScanner(){
        this.scanner.close();
    }

    private Number lerEntrada(String tipo){
        System.out.printf("Informe um valor não negativo: ");
        Number numero = null;
        if(tipo.equals("long"))
            numero = (Long) scanner.nextLong();
        else if(tipo.equals("double"))
            numero = (Double) scanner.nextDouble();
        return numero;
    }

    private boolean isPar(Number num){
        return num.intValue()%2 == 0;
    }

    private void inserirOrdenadoPorCategoria(LinkedList<Long> list, Long element, boolean ispar){
        // procura o indice para inserir o elemento.
        int indexToAdd = 0;
        for (Long e : list) {
            if(ispar){
                if(element <= e){
                    indexToAdd = list.indexOf(e);
                    break;
                }else{
                    indexToAdd++;
                }
            }else if(!ispar){
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
    public void primeiro () throws Exception{
        int n = scanner.nextInt(); // lendo o número de iterações totais.
        LinkedList<Long> listaPar = new LinkedList<Long>();
        LinkedList<Long> listaImpar = new LinkedList<Long>();
       
        for (int i = 0; i < n; i++) {
            long entrada = (Long) this.lerEntrada("long");
            if(entrada < 0)
                throw new Exception("Valores negativos não são suportados");

            var ispar = this.isPar(entrada);
            
            if(ispar){ // se par
                this.inserirOrdenadoPorCategoria(listaPar, entrada, true);
            }else{ // se impar
                this.inserirOrdenadoPorCategoria(listaImpar, entrada, false);
            }
        }

        listaPar.addAll(listaImpar); //concatena as duas listas
        
        //imprime a lista
        listaPar.forEach((e) -> {
            System.out.println(e);
        });

    }

    // Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor
    // monetário. A seguir, calcule o menor número de notas e moedas possíveis no qual o valor
    // pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas
    // possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. A seguir mostre a relação de notas
    // necessárias.
    // Entrada
    // O arquivo de entrada contém um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).
    // Saída
    // Imprima a quantidade mínima de notas e moedas necessárias para trocar o valor inicial,
    // conforme exemplo fornecido.
    public void segundo(){
        double dinheiro = this.lerEntrada("double").doubleValue();
        double[] notasOuMoedas = {100.0, 50.0, 20.0, 10.0, 5.0, 2.0, 1, 0.50, 0.25, 0.10, 0.05, 0.01};
        int[] notasOuMoedasNecessarias = new int[notasOuMoedas.length];

        for (int i = 0; i < notasOuMoedas.length; i++) {
            double notaOuMoeda = notasOuMoedas[i];
            double resto = dinheiro % notasOuMoedas[i];
            var qtdNecessaria = (dinheiro - (resto))/notaOuMoeda;
            dinheiro -= notaOuMoeda*qtdNecessaria;
            notasOuMoedasNecessarias[i] = (int)qtdNecessaria;
        }

        for (int i = 0; i < notasOuMoedasNecessarias.length; i++) {
            if(i == 0)
                System.out.println("NOTAS:");
                
            if(i > 5)
                System.out.printf("%d \t notas(s) \t de \t R$ %.2f\n", notasOuMoedasNecessarias[i], notasOuMoedas[i]);
            else
                System.out.printf("%d \t moeda(s) \t de \t R$ %.2f\n", notasOuMoedasNecessarias[i], notasOuMoedas[i]);

            if(i == 5)
                 System.out.println("MOEDAS:");
        }



    }

    // Dado um array de inteiros e um valor alvo, determine o número de pares entre os elementos
    // do array em que a sua diferença seja igual ao valor alvo.

    // Exemplo
    // K = 1
    // arr = [1,2,3,4]
    // Existem 3 valores cuja diferença é igual ao valor alvo K: 2-1 = 1, 3-2 = 1, 4-3 = 1.

    // Descrição do problema:
    // Os pares têm os seguintes parâmetros:
    // int k: Um Inteiro, valor alvo.
    // int arr[n]: Um array de Inteiros.

    // Retorno
    // int: O número de pares que satisfazem o critério.

    // Formatos de Entrada
    // Seu código deve conter duas entradas n e k, que representam o tamanho do array e o valor
    // alvo.
    // Seu código deve conter um array de inteiros, de tamanho n.
    public void terceiro(){
        int n = this.lerEntrada("long").intValue();
        int k = this.lerEntrada("long").intValue();
        int[] arr = new int[n];
        int contador = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = this.lerEntrada("long").intValue();
            int aux = 0;
            while (aux < i) {
                if(arr[i] - arr[aux] == k)
                    contador++;
                else if(arr[aux] - arr[i] == k)
                    contador++;
                aux++;
            }
        }
        System.out.println(contador);
    }


    // A sua impressora foi infectada por um vírus e está imprimindo de forma incorreta. Depois
    // de olhar para várias páginas impressas por um tempo, você percebe que ele está
    // imprimindo cada linha de dentro para fora. Em outras palavras, a metade esquerda de cada
    // linha está sendo impressa a partir do meio da página até a margem esquerda. Do mesmo
    // modo, a metade direita de cada linha está sendo impressa à partir da margem direita e
    // prosseguindo em direção ao centro da página.

    // Por exemplo a linha:
    // THIS LINE IS GIBBERISH
    // está sendo impressa como:
    // I ENIL SIHTHSIREBBIG S

    // Da mesma forma, a linha " MANGOS " está sendo impressa incorretamente como
    // "NAM SOG". Sua tarefa é desembaralhar (decifrar) a string a partir da forma como ela foi
    // impressa para a sua forma original. Você pode assumir que cada linha conterá um número
    // par de caracteres.
    // Entrada
    // A entrada contém vários casos de teste. A primeira linha de entrada contém um
    // inteiro N que indica a quantidade de casos de teste. Seguem N linhas, cada uma com uma
    // frase com no mínimo 2 e no máximo 100 caracteres de letras maiúsculas e espaços que
    // deverá ser desembaralhada (decifrada) à partir da forma impressa para a sua forma
    // original, conforme especificação acima.
    // Saída
    // Para cada linha de entrada deverá ser impressa uma linha de saída com a frase decifrada,
    // conforme a especificação acima.
    public void quarto(){
        int n = this.lerEntrada("long").intValue();
        for (int i = 0; i < n; i++) {
            System.err.println("Digite com uma string:");
            String s1 =  this.scanner.nextLine();
            s1 = s1.toUpperCase();
            
            if(s1.length() < 2){
                System.out.println("A entrada deve possuir mais que dois caracteres");
                continue;
            }else if(s1.length() > 100){
                System.out.println("A entrada deve possuir menos que 100 caracteres");
            }


            int len = s1.length();
            char[] resultante = new char[len];
            int metade = len/2;
            char[] strArr1 = s1.substring(0, metade).toCharArray();
            char[] strArr2 = s1.substring(metade, len).toCharArray();
            // percorre o vetor na ordem inversa
            for (int j = strArr1.length - 1, k = 0, m = metade; j >= 0 ; j--, k++) {
                resultante[k] = strArr1[j]; // preencher a metada inferior
                resultante[m + k] = strArr2[j]; // preencher a metade superior
            }
            System.out.println(resultante);
        }
    }
    
}
