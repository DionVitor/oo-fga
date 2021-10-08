package tp5.domain;


/**
 * Classe de Cardápio
 *
 * @author Dion Vitor e Eurico Abreu
 * @version 1.0
 */
public class Cardapio extends CRUD {
    private String tipo;
    private final tp5.domain.Produto[] produtos;

    public Cardapio(String tipo, tp5.domain.Produto[] produtos) {
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
