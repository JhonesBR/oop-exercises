/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String email, String cnpj) {
        super(nome, telefone, email);
        this.cnpj = cnpj;
    }

    public void print() {
        System.out.println("- " + this.nome + " (Pessoa Jurídica)");
        System.out.println("\tTelefone: " + this.telefone);
        System.out.println("\tEmail: " + this.email);
        System.out.println("\tCNPJ: " + this.cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
