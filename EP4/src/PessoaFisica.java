/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */

public class PessoaFisica extends Pessoa{
    // Variables
    private String cpf;
    private String rg;

    // Constructor
    public PessoaFisica(String nome, String telefone, String email, String cpf, String rg) {
        super(nome, telefone, email);
        this.cpf = cpf;
        this.rg = rg;
    }

    // Method print
    public void print() {
        System.out.println("- " + this.nome + " (Pessoa Física)");
        System.out.println("\tTelefone: " + this.telefone);
        System.out.println("\tEmail: " + this.email);
        System.out.println("\tCPF: " + this.cpf);
        System.out.println("\tRG: " + this.rg);
    }

    // Getter and Setter CPF
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    // Getter and Setter RG
    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }
}
