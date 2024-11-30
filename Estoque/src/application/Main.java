package application;

import entities.ArquivoUtils;
import entities.Categoria;
import entities.Estoque;
import entities.Produto;
import java.util.Scanner;

/**
 * Classe Main responsável pela interação com usuário a partir do Terminal, havendo um Menu interativo onde será solicitado
 * todos os dados do produto;
 *
 * Desenvolvida por Marcos Vinicios Fernandes Pinheiro
 */

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner sc = new Scanner(System.in);
        ArquivoUtils arquivo = new ArquivoUtils();

        //Carrega o arquivo .txt do projeto
        estoque.setProdutos(arquivo.carregarProdutos());

        int opcao;
        do {
            System.out.println("\n----------Sistema de Estoque----------");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Listar produtos por categoria");
            System.out.println("4. Listar produtos com abaixo de certa quantidade");
            System.out.println("5. Remover produto");
            System.out.println("6. Atualizar quantidade");
            System.out.println("7. Exibir relatório de movimentações");
            System.out.println("8. Sair");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    // Exibir categorias disponíveis
                    System.out.println("Selecione a categoria:");
                    Categoria[] categorias = Categoria.values();
                    for (int i = 0; i < categorias.length; i++) {
                        System.out.println((i + 1) + ". " + categorias[i]);
                    }
                    System.out.print("Escolha uma categoria: ");
                    int categoriaIndex = sc.nextInt() - 1;

                    //Verifica se a opção informada pelo usuária esta correta
                    if (categoriaIndex >= 0 && categoriaIndex < categorias.length) {
                        Categoria categoria = categorias[categoriaIndex];
                        estoque.adicionarProduto(new Produto(nome, preco, codigo, quantidade, categoria));
                    } else {
                        System.out.println("-> Categoria inválida.");
                    }
                }
                case 2 -> estoque.listarProdutos();
                case 3 -> {
                    System.out.println("Selecione a categoria:");
                    Categoria[] categorias = Categoria.values();
                    for (int i = 0; i < categorias.length; i++) {
                        System.out.println((i + 1) + ". " + categorias[i]);
                    }

                    System.out.print("\nEscolha uma categoria: ");
                    int categoriaIndex = sc.nextInt() - 1;

                    //Verifica se a opção informada pelo usuária esta correta
                    if (categoriaIndex >= 0 && categoriaIndex < categorias.length) {
                        Categoria categoria = categorias[categoriaIndex];
                        estoque.listarPorCategoria(categoria);
                    } else {
                        System.out.println("-> Categoria inválida.");
                    }
                }
                case 4 -> {
                    System.out.print("Quantidade limite: ");
                    int valor = sc.nextInt();
                    estoque.listarPorQuantidadeAbaixoDe(valor);
                }
                case 5 -> {
                    System.out.print("Código do produto a remover: ");
                    int codigo = sc.nextInt();
                    estoque.removerProduto(codigo);
                }
                case 6 -> {
                    System.out.print("Código do produto: ");
                    int codigo = sc.nextInt();
                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = sc.nextInt();
                    estoque.atualizarQuantidade(codigo, novaQuantidade);
                }
                case 7 -> estoque.exibirRelatorioMovimentacoes();
                case 8 -> {
                    System.out.println("Saindo...");
                    arquivo.salvarProdutos(estoque.getProdutos());
                }
                default -> System.out.println("-> Opção inválida.");
            }
        } while (opcao != 8);
    }
}
