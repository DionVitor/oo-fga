package tp3;

import tp3.CRUD;

public class Produto extends CRUD {
    private final String nome;
    private final double preco;
    private final String descricao;
    private final int estoque;

    public Produto(String nome, double preco, String descricao, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
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
