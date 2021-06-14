/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */

public class PessoaFisica extends Pessoa{
    private String cpf;
    private String rg;

    public PessoaFisica(String nome, String telefone, String email, String cpf, String rg) {
        super(nome, telefone, email);
        this.cpf = cpf;
        this.rg = rg;
    }

    public void print() {
        System.out.println("- " + this.nome + " (Pessoa Física)");
        System.out.println("\tTelefone: " + this.telefone);
        System.out.println("\tEmail: " + this.email);
        System.out.println("\tCPF: " + this.cpf);
        System.out.println("\tRG: " + this.rg);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
