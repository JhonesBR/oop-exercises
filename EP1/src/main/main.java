package main;

/**
 *
 * @author Joao Vitor Oliveira de Melo 175079
 */
public class main {
    public static void main(String[] args) {
        // Contas iniciadas sem saldo
	caixa varese = new caixa(123456, "Varese Salvador Timóteo");
        caixa guilherme = new caixa(789456, "Guilherme Palermo Coelho");
        
        // Depósito
        System.out.println("----------------------------------------------------");
        System.out.println("Depósitos:\n");
        varese.deposito(10000);
        guilherme.deposito(7000);
        
        // Transferência válida
        System.out.println("----------------------------------------------------");
        System.out.println("Transferência válida:");
        varese.transferencia(guilherme, 500);
        // Transferência inválida
        System.out.println("Transferência inválida:");
        varese.transferencia(guilherme, 90000);
        
        // Saque válido
        System.out.println("----------------------------------------------------");
        System.out.println("Saque válido:");
        guilherme.saque(200);
        // Saque inválido
        System.out.println("Saque inválido:");
        guilherme.saque(90000);
        
        // Pagamento válido
        System.out.println("----------------------------------------------------");
        System.out.println("Pagamento válido:");
        guilherme.pagamento(1000);
        // Pagamento inválido
        System.out.println("Pagamento inválido:");
        guilherme.pagamento(90000);
        
        // Consultas
        System.out.println("----------------------------------------------------");
        System.out.println("Consultas:\n");
        varese.consultaSaldo();
        guilherme.consultaSaldo();
        System.out.println("----------------------------------------------------");
    }
}
