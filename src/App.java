public class App {
    public static void main(String[] args) throws Exception {
        Desafios desafios = new Desafios();
        
        System.out.println("Inicio desafio 1");
        desafios.primeiro();
        System.out.println("Fim do desafio 1");

        System.out.println("Inicio desafio 2");
        desafios.segundo();
        System.out.println("Fim do desafio 2");

        System.out.println("Inicio desafio 3");
        desafios.terceiro();
        System.out.println("Fim do desafio 3");

        System.out.println("Inicio desafio 4");
        desafios.quarto();
        System.out.println("Fim do desafio 4");


        desafios.closeScanner();
    }
}
