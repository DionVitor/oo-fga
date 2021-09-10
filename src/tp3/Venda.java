package tp3;

import tp3.CRUD;

public class Venda extends CRUD {
    private final String nome_cliente;
    private final String nome_produto;
    private final int quant_produto;

    public Venda(String nome_cliente, String nome_produto, int quant_produto) {
        this.nome_cliente = nome_cliente;
        this.nome_produto = nome_produto;
        this.quant_produto = quant_produto;
    }

    @Override
    public boolean set() {
        return true;
    }

    @Override
    public boolean edit() {
        return true;
    }

    @Override
    public boolean delete() {
        return true;
    }
}
