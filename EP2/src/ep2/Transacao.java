package ep2;

/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public class Transacao {
    private String data;
    private float valor;
    private String descricao;

    public Transacao(String data, float valor, String descricao) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
