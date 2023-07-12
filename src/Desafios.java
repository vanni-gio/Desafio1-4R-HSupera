import java.util.Locale;
import java.util.Scanner;

import Desafio1.Solucao1;
import Desafio4.Solucao4;
import Desafio3.Solucao3;
import Desafio2.Solucao2;
// classe que representa o conjunto de desafios propostos pelo RH Supera
public class Desafios {
    private Scanner scanner;

    public Desafios(){
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    public void closeScanner(){
        this.scanner.close();
    }

    // faz a leitura do teclado. Pode ler dos tipos long e double.
    private Number lerEntrada(String tipo) throws Exception{
        System.out.printf("Informe um valor não negativo: ");
        Number numero = null;
        if(tipo.equals("long"))
            numero = (Long) scanner.nextLong();
        else if(tipo.equals("double"))
            numero = (Double) scanner.nextDouble();
        if(numero.intValue() < 0)
            throw new Exception("Valores negativos não são suportados");
        return numero;
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
    public void primeiro () {
        int n = scanner.nextInt(); // lendo o número de iterações totais.
        long[] entradas = new long[n];
        for (int i = 0; i < n; i++) {
            try {
                entradas[i] = (Long) this.lerEntrada("long");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
        new Solucao1(entradas);

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
        double dinheiro = 0;
        try {
            dinheiro = this.lerEntrada("double").doubleValue();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new Solucao2(dinheiro);

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
        int n = 0, k = 0;
        try {
            n = this.lerEntrada("long").intValue();
            k = this.lerEntrada("long").intValue();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            try {
                arr[i] = this.lerEntrada("long").intValue();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        new Solucao3(n, k, arr);
            
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
        int n = 0;
        try {
            n = this.lerEntrada("long").intValue();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.scanner.nextLine(); // remover o enter da entrada anterior

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.err.println("Digite com uma string:");
            String s1 =  this.scanner.nextLine();
            arr[i] = s1;

            if(s1.length() < 2){
                System.out.println("A entrada deve possuir mais que dois caracteres");
                continue;
            }else if(s1.length() > 100){
                System.out.println("A entrada deve possuir menos que 100 caracteres");
            }
        }

        new Solucao4(arr); 
    }
    
}
