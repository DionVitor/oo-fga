package tp4.domain;

public class Cardapio extends CRUD {
    private final String tipo;
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
