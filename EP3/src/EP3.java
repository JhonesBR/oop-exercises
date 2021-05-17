import java.util.Scanner;

/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public class EP3 {

    public static void main(String[] args) {
        Tab V = new Tab();
        Scanner sc = new Scanner(System.in);

        System.out.println("Definindo o tamanho para 1000");
        V.setSize(1000);
        System.out.println("Tamanho atual da matriz: " + V.getSize());
        System.out.println("✔\n\n");

        System.out.println("Definindo elemento da matriz sem erro");
        V.setV(175079, 500, 500);
        System.out.println("Elemento V[500][500] = " + V.getVMember(500, 500));
        System.out.println("✔\n\n");

        System.out.printf("Insira um N fora dos limites da memória (>%d): ", V.getSize());
        int n = sc.nextInt();
        System.out.printf("Acessando o elemento V[%d][%d]\n", n, n);
        try{
            int element = V.getVMember(n, n);
            System.out.printf("Elemento V[%d][%d] = %d\n", n, n, V.getVMember(n, n));
            System.out.println("✔\n\n");
        } catch(Exception erro){
            System.out.println("❌");
            System.out.println("\tErro: " + erro);

            V.setSize(n);
            System.out.println("\tNovo tamanho da matriz: " + V.getSize());
            System.out.println("Erro tratado ✔\n\n");
        }

        System.out.println("Fim do programa");
    }

}