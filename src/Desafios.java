
import java.util.LinkedList;
import java.util.Scanner;
public class Desafios {
    private Scanner scanner;
    public Desafios(){
        this.scanner = new Scanner(System.in);
    }

    public void closeScanner(){
        this.scanner.close();
    }

    private long lerEntrada(){
        System.out.printf("Informe um valor não negativo: ");
        long valor = scanner.nextLong();
        assert(valor >= 0):
        "O valor não pode ser negativo";
        return valor;
    }


    private void inserirOrdenado(LinkedList<Long> list, Long element){
        // procura o indice para inserir o elemento.
        int indexToAdd = 0;
        for (Long e : list) {
            if(element <= e){
                indexToAdd = list.indexOf(e);
                break;
            }else{
                indexToAdd++;
            }
        }
        list.add(indexToAdd, element);
    }

    public void primeiro () throws Exception{
        int n = scanner.nextInt(); // lendo o número de iterações totais.
        LinkedList<Long> listaPar = new LinkedList<Long>();
        LinkedList<Long> listaImpar = new LinkedList<Long>();
       

        
        for (int i = 0; i < n; i++) {
            long entrada = this.lerEntrada();
            if(entrada < 0)
                throw new Exception("Valores negativos não são suportados");

            var ispar = ((entrada % 2) == 0);
            
            if(ispar){ // se par
                this.inserirOrdenado(listaPar, entrada);
            }else{ // se impar
                this.inserirOrdenado(listaImpar, entrada);
            }
        }

        listaPar.addAll(listaImpar); //concatena as duas listas
        
        //imprime a lista
        listaPar.forEach((e) -> {
            System.out.println(e);
        });

    }
    public void segundo(){

    }
    public void terceiro(){

    }
    public void quarto(){

    }
    
}
