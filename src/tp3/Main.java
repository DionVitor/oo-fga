package tp3;

import tp3.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "Asa Sul", "61-998822230", "Dinheiro");
        Produto produto = new Produto("Maça", 12.50, "Uma deliciosa fruta.", 10);
        Produto[] produtos = {produto};
        Cardapio cardapio = new Cardapio("Frutas", produtos);
        Venda venda = new Venda("João", "Maça", 2);

        System.out.println(cliente.getNome());
        System.out.println(cliente.getEndereco());
        System.out.println(cliente.getTelefone());
        System.out.println(cliente.getPagamento());

        System.out.println(cliente.set());
        System.out.println(cliente.edit());
        System.out.println(cliente.delete());

        System.out.println(produto.getNome());
        System.out.println(produto.getPreco());
        System.out.println(produto.getDescricao());
        System.out.println(produto.getEstoque());

        System.out.println(produto.set());
        System.out.println(produto.edit());
        System.out.println(produto.delete());

        System.out.println(Arrays.toString(cardapio.getProdutos()));
        System.out.println(cardapio.getTipo());

        System.out.println(cardapio.set());
        System.out.println(cardapio.edit());
        System.out.println(cardapio.delete());

        System.out.println(venda.getNomeCliente());
        System.out.println(venda.getNomeProduto());
        System.out.println(venda.getQuantProduto());

        System.out.println(venda.set());
        System.out.println(venda.edit());
        System.out.println(venda.delete());
    }
}