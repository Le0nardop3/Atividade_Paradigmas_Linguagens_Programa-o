public abstract class Product implements Vendavel {

    private String nome;
    private double preco;
    private int quantidade;

    public Product(String nome, double preco, int quantidade) throws QuantidadeInvalidaException {
        if (preco < 0 || quantidade < 0) {
            throw new QuantidadeInvalidaException("Preço ou quantidade não podem ser negativos.");
        }

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public abstract double calcularValorTotal();

    public String getDescricao() {
        return String.format(
            "Nome: %s | Preço: %.2f | Quantidade: %d",
            nome, preco, quantidade
        );
    }
}