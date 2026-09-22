import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Product> produtos;

    public Estoque() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Product p) {
        produtos.add(p);
    }

    public void venderProduto(int indice, int quantidade)
            throws ProdutoIndisponivelException {

        produtos.get(indice).vender(quantidade);
    }

    public double calcularValorTotalEstoque() {
        double total = 0;

        for (Product produto : produtos) {
            total += produto.calcularValorTotal();
        }

        return total;
    }
}