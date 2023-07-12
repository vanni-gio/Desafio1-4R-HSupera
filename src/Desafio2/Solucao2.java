package Desafio2;

public class Solucao2 {
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
    public Solucao2(double dinheiro){
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
}
