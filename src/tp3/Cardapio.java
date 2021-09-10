package tp3;

import tp3.Produto;
import tp3.CRUD;

public class Cardapio extends CRUD {
    private final String tipo;
    private final Produto[] produtos;

    public Cardapio(String tipo, Produto[] produtos) {
        this.tipo = tipo;
        this.produtos = produtos;
    }

    public boolean set() {
        return true;
    }

    public boolean edit() {
        return true;
    }

    public boolean delete() {
        return true;
    }
}
