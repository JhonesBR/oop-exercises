/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */

public class EP4 {

    public static void main(String[] args) {

        PessoaFisica pessoa1 = new PessoaFisica("Francisco", "(91)81918-6371", "francisco@gmail.com", "536.781.736-08", "31.607.261-8");
        PessoaJuridica pessoa2 = new PessoaJuridica("Doces & Salgados Ltda", "(19)2918-1256", "docesesalgados@gmail.com.br", "99.374.884/0001-01");

        pessoa1.print();
        System.out.println("");
        pessoa2.print();

    }

}