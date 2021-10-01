package tp4.domain;

public class Venda extends CRUD {
    private final String nomeCliente;
    private final String nomeProduto;
    private final String quantProduto;

    public Venda(String nomeCliente, String nomeProduto, String quantProduto) {
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

    public String getQuantProduto() {
        return this.quantProduto;
    }
}
