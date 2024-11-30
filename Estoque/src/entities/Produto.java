package entities;

/**
 * Class responsável por receber todos os dados necessários do produto, há também uma implementação necessária para que
 * o produto seja armazenado em um arquivo .txt convertendo para uma "linha";
 *
 * Desenvolvida por Miguel Amm Coelho e revisada por Marcos Vinicios Fernandes Pinheiro
 */

public class Produto{
    private String nome;
    private double preco;
    private int quantidade;
    private int codigo;
    private Categoria categoria;

    public Produto() {
        this.nome = "";
        this.preco = 0;
        this.quantidade = 0;
        this.codigo = 0;
    }

    public Produto(String nome, double preco, int codigo, int quantidade, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    // Metodo para converter o produto em formato de texto para arquivo
    public String toFileFormat() {
        return nome + ";" + preco + ";" + codigo + ";" + quantidade + ";" + categoria;
    }

    // Metodo para criar um produto a partir de uma linha do arquivo
    public static Produto fromFileFormat(String linha) {
        try {
            String[] partes = linha.split(";");
            String nome = partes[0];
            double preco = Double.parseDouble(partes[1]);
            int codigo = Integer.parseInt(partes[2]);
            int quantidade = Integer.parseInt(partes[3]);
            Categoria categoria = Categoria.valueOf(partes[4]);
            return new Produto(nome, preco, codigo, quantidade, categoria);
        } catch (Exception error) {
            System.err.println("Erro ao ler produto do arquivo: " + error.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "-----------------Produto---------------" +
                "\nnome: " + nome +
                "\nCodigo: " + codigo +
                "\nPreço: " + preco +
                "\nQuantidade: " + quantidade;
    }
}
