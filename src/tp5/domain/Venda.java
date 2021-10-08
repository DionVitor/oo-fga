package tp5.domain;


/**
 * Classe de Venda
 *
 * @author Dion Vitor e Eurico Abreu
 * @version 1.0
 */
public class Venda extends CRUD {
    private String nomeCliente;
    private String nomeProduto;
    private String quantProduto;

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
        return false;
    }

    public void edit(String nameClient, String nameProduct, String quantity) {
        this.nomeCliente = nameClient;
        this.nomeProduto = nameProduct;
        this.quantProduto = quantity;
    }

    @Override
    public boolean delete() {
        return true;
    }

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
