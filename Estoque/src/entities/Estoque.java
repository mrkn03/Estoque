package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável para armazenar o produto em um ArrayList do tipo Produto;
 * há nela funções para adicionar produto, listar produtos, remover produto, atualizar quantidade e exibir movimentações;
 *
 * Desenvolvida por Rafael Pim Santos e revisada por Marcos Vinicios Fernandes Pinheiro
 */

public class Estoque {
    private ArrayList<Produto> produtos;
    private ArrayList<Movimentacao> movimentacoes;

    public Estoque() {
        this.produtos = new ArrayList<>();
        this.movimentacoes = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = (ArrayList<Produto>) produtos;
    }

    // Metodo para adicionar um produto ao estoque
    public void adicionarProduto(Produto produto) {

        produtos.add(produto);
        movimentacoes.add(new Movimentacao("Entrada", produto.getQuantidade(), produto.getNome()));
    }

    // Metodo para listar todos os produtos e verificar se estoque é considerado baixo
    public void listarProdutos() {

        if(produtos.isEmpty()) {
            System.out.printf("-> Nenhum produto cadastrado!");
        }

        for (Produto produto : produtos) {
            System.out.println(produto);
            if (produto.getQuantidade() <= 5) {
                System.out.println("-> ALERTA: Estoque baixo para o produto: " + produto.getNome());
            }
        }
    }

    //Metodo para listar produtos por categoria
    public void listarPorCategoria(Categoria categoria) {

        boolean produtoExistente = false;

        System.out.println("\nProdutos na categoria: " + categoria);
        for (Produto produto : produtos) {
            if (produto.getCategoria() == categoria) {
                System.out.println(produto);
                produtoExistente = true;
            }
        }

        if (!produtoExistente) {
            System.out.println("-> Não há produtos nesta categoria!");
        }
    }

    //Metodo para listar os itens abaixo da quantidade delimitada
    public void listarPorQuantidadeAbaixoDe(int valor) {

        System.out.println("Produtos com quantidade abaixo de " + valor + ":");
        for (Produto produto : produtos) {
            if (produto.getQuantidade() < valor) {
                System.out.println(produto);
            }
        }
    }

    // Metodo para remover um produto do estoque com base no c�digo
    public void removerProduto(int codigo) {

        Produto produtoRemovido = null;
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtoRemovido = produto;
                break;
            }
        }
        if (produtoRemovido != null) {
            movimentacoes.add(new Movimentacao("Saída", produtoRemovido.getQuantidade(), produtoRemovido.getNome()));
            produtos.remove(produtoRemovido);
        }
    }

    //Metodo para atualizar quantidade
    public void atualizarQuantidade(int codigo, int novaQuantidade) {

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                int diferenca = novaQuantidade - produto.getQuantidade();
                String tipo = diferenca >= 0 ? "Entrada" : "Saída";
                movimentacoes.add(new Movimentacao(tipo, Math.abs(diferenca), produto.getNome()));
                produto.setQuantidade(novaQuantidade);
                break;
            }
        }
    }

    public void exibirRelatorioMovimentacoes() {

        System.out.println("Relatório de Movimentações:");
        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println(movimentacao);
        }
    }
}

