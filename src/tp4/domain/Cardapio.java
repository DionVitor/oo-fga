package tp4.domain;

public class Cardapio extends CRUD {
    private String tipo;
    private final Produto[] produtos;

    public Cardapio(String tipo, Produto[] produtos) {
        this.tipo = tipo;
        this.produtos = produtos;
    }

    @Override
    public boolean set() {
        return true;
    }

    @Override
    public boolean edit() {
        return false;
    }

    public boolean edit(String type) {
        this.tipo = type;
        return true;
    }

    @Override
    public boolean delete() {
        return true;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Produto[] getProdutos() {
        return this.produtos;
    }
}
