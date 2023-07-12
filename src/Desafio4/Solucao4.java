package Desafio4;

public class Solucao4 {
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
    public Solucao4(String[] arr){

        for (int i = 0; i < arr.length; i++) {

            String str = arr[i].toUpperCase();

            int len = str.length();
            char[] resultante = new char[len];
            int metade = len/2;
            char[] strArr1 = str.substring(0, metade).toCharArray();
            char[] strArr2 = str.substring(metade, len).toCharArray();
            // percorre o vetor na ordem inversa
            for (int j = strArr1.length - 1, k = 0, m = metade; j >= 0 ; j--, k++) {
                resultante[k] = strArr1[j]; // preencher a metada inferior
                resultante[m + k] = strArr2[j]; // preencher a metade superior
            }
            System.out.println(resultante);
        }
    }
}
