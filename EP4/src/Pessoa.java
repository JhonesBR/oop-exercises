/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */

public class Pessoa {
    // Variables
    String nome;
    String telefone;
    String email;

    // Constructor
    public Pessoa(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getter and Setter Nome
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // Getter and Setter Telefone
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Getter and Setter Email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
