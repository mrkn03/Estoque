package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *Classe responsável por Ler e Armazenar dados em um arquivo .txt;
 *
 * Desenvolvida por Marcos Vinicios Fernandes Pinheiro
 */

public class ArquivoUtils {
    private static final String FILE_NAME = "estoque.txt";

    // Metodo para salvar a lista de produtos em um arquivo
    public void salvarProdutos(List<Produto> produtos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Produto produto : produtos) {
                writer.write(produto.toFileFormat());
                writer.newLine();
            }
            System.out.println("Produtos salvos com sucesso no arquivo.");
        } catch (IOException error) {
            System.err.println("Erro ao salvar produtos no arquivo: " + error.getMessage());
        }
    }

    // Metodo para carregar a lista de produtos de um arquivo
    public List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Produto produto = Produto.fromFileFormat(linha);
                if (produto != null) {
                    produtos.add(produto);
                }
            }
            System.out.println("Produtos carregados com sucesso do arquivo.");
        } catch (IOException error) {
            System.err.println("Erro ao carregar produtos do arquivo: " + error.getMessage());
        }
        return produtos;
    }
}
