public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, double renda, Situacao situacao, String cnpj) {
        super(nome, renda, situacao);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
