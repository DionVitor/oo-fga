package tp5.domain;

public class    Produto extends CRUD {
    private String nome;
    private String preco;
    private String descricao;
    private String estoque;

    public Produto(String nome, String preco, String descricao, String estoque){
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

    public boolean edit(String name, String price, String desc, String invent) {
        this.nome = name;
        this.preco = price;
        this.descricao = desc;
        this.estoque = invent;
        return true;
    }

    @Override
    public boolean delete() {
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPreco() {
        return this.preco;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getEstoque() {
        return this.estoque;
    }
}
