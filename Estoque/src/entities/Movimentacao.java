package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe responsável por armazenar as movimentações (Saída e Entrada) dos produtos;
 *
 * Desenvolvida por Rubiale Alves de Melo Filho e revisada por Marcos Vinicios Fernandes Pinheiro
 */

public class Movimentacao {
    private String tipo;
    private LocalDateTime dataHora;
    private int quantidade;
    private String produtoNome;

    public Movimentacao(String tipo, int quantidade, String produtoNome) {
        this.tipo = tipo;
        this.dataHora = LocalDateTime.now();
        this.quantidade = quantidade;
        this.produtoNome = produtoNome;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "--------------Movimentação------------- " +
                "\nTipo: " + tipo +
                "\nData/Hora: " + dataHora.format(formatter) +
                "\nQuantidade: " + quantidade +
                "\nProduto: " + produtoNome;
    }
}
