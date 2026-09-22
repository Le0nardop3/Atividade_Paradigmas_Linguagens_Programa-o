public class EstoqueApp {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        try {
            // 2 produtos comuns
            ProdutoComum arroz = new ProdutoComum(
                "Arroz",
                25.00,
                10
            );

            ProdutoComum feijao = new ProdutoComum(
                "Feijão",
                8.50,
                20
            );

            // 2 produtos perecíveis
            ProdutoPerecivel leite = new ProdutoPerecivel(
                "Leite",
                6.00,
                15,
                10
            );

            ProdutoPerecivel iogurte = new ProdutoPerecivel(
                "Iogurte",
                4.00,
                12,
                2
            );

            estoque.adicionarProduto(arroz);
            estoque.adicionarProduto(feijao);
            estoque.adicionarProduto(leite);
            estoque.adicionarProduto(iogurte);

            System.out.println("=== PRODUTOS CADASTRADOS ===");
            System.out.println(arroz.getDescricao());
            System.out.println(feijao.getDescricao());
            System.out.println(leite.getDescricao());
            System.out.println(iogurte.getDescricao());

        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }

        // Tentativa de cadastrar produto com quantidade negativa
        try {
            ProdutoComum produtoInvalido = new ProdutoComum(
                "Produto Inválido",
                10.00,
                -5
            );

            estoque.adicionarProduto(produtoInvalido);

        } catch (QuantidadeInvalidaException e) {
            System.out.println(
                "Quantidade inválida capturada: " + e.getMessage()
            );
        }

        // Venda válida
        try {
            estoque.venderProduto(0, 3);
            System.out.println("Venda realizada com sucesso.");
        } catch (ProdutoIndisponivelException e) {
            System.out.println(
                "Erro na venda: " + e.getMessage()
            );
        }

        // Tentativa de vender mais do que o disponível
        try {
            estoque.venderProduto(0, 20);
        } catch (ProdutoIndisponivelException e) {
            System.out.println(
                "Produto indisponível capturado: " + e.getMessage()
            );
        }

        // Valor total do estoque
        System.out.printf(
            "Valor total do estoque: R$ %.2f%n",
            estoque.calcularValorTotalEstoque()
        );
    }
}