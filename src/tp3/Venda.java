package tp3;

import tp3.CRUD;

public class Venda extends CRUD {
    private final String nomeCliente;
    private final String nomeProduto;
    private final int quantProduto;

    public Venda(String nomeCliente, String nomeProduto, int quantProduto) {
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.quantProduto = quantProduto;
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

    public void emitirNota(){}

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public int getQuantProduto() {
        return this.quantProduto;
    }
}
