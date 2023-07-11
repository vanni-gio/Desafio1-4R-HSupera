
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
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
    public void quarto(){
        var s1 =  "VOD OWT SNEH HCNERF EGDIRTRAP A DNA SE";
        int n = s1.length();
        char[] resultante = new char[n];
        int metade = n/2;
        var strArr1 = s1.substring(0, metade).toCharArray();
        var strArr2 = s1.substring(metade, n).toCharArray();
        for (int i = strArr1.length - 1, j = 0, k = metade; i >= 0 ; i--, j++) {
            resultante[j] = strArr1[i]; // preencher a metada inferior
            resultante[k + j] = strArr2[i]; // preencher a metade superior
        }

        System.out.println(resultante);
    }
    
}
