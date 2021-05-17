import java.util.Scanner;

/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public class EP3 {

    public static void main(String[] args) {
        Tab V = new Tab();
        Scanner sc = new Scanner(System.in);

        // Define o tamanho da matriz para 1000x1000
        System.out.println("Definindo o tamanho para 1000...");
        V.setSize(1000);
        System.out.println("Tamanho atual da matriz: " + V.getSize());
        System.out.println("✔\n\n");

        // Define e acessa o elemento V[500][500]
        System.out.println("Definindo elemento da matriz sem erro...");
        V.setV(175079, 500, 500);
        System.out.println("Elemento V[500][500] = " + V.getVMember(500, 500));
        System.out.println("✔\n\n");

        // Pede por um elemento fora da região de memória de V para gerar erro intencional
        System.out.printf("Insira um N fora dos limites da memória (>%d): ", V.getSize());
        int N = sc.nextInt();
        System.out.printf("Acessando o elemento V[%d][%d]...\n", N, N);

        // Tratando o erro com try/catch
        try{
            int element = V.getVMember(N, N);
            // Continua para elemento válido caso insira um valor correto
            System.out.printf("Elemento V[%d][%d] = %d\n", N, N, V.getVMember(N, N));
            System.out.println("✔\n\n");
        } catch(Exception erro){
            System.out.println("❌");
            System.out.println("\tErro: " + erro);  // Exibe o erro

            // Define o tamanho da tabela V para N
            V.setSize(N);
            System.out.println("\tNovo tamanho da matriz: " + V.getSize());
            System.out.println("Erro tratado ✔\n\n");
        }

        // Finaliza o programa caso não houve erro
        System.out.println("Fim do programa");
    }

}