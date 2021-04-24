package ep2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public class EP2 {
    
    public static void main(String[] args) {
        // Criação das contas
        List<Conta> contas = new ArrayList<Conta>();
        contas.add(new ContaCorrenteComum(123, "Varese Salvador Timóteo", 10000));
        contas.add(new ContaCorrenteLimite(456, "Ulisses Martins Dias", 8000, 750));
        contas.add(new ContaPoupanca(789, "Guilherme Palermo Coelho", 5000));
    
        // Operações na conta 1
        contas.get(0).deposito(100);   // Depósito de R$100,00
        contas.get(0).retirada(5000);  // Retirada de R$5000,00
        contas.get(0).extrato();       // Impressão do Extrato
        
        // Operações na conta 2
        contas.get(1).deposito(300);   // Depósito de R$300,00
        contas.get(1).retirada(8400);  // Retirada de R$8400,00
        contas.get(1).extrato();       // Impressão do Extrato
        
        // Operações na conta 3
        contas.get(2).deposito(100);   // Depósito de R$100,00
        contas.get(2).retirada(3000);  // Retirada de R$3000,00
        contas.get(2).extrato();       // Impressão do Extrato
    }
    
}