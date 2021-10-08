package tp5.domain;


/**
 * Classe de Cliente
 *
 * @author Dion Vitor e Eurico Abreu
 * @version 1.0
 */
public class Cliente extends CRUD {
    private String nome;
    private String endereco;
    private String telefone;
    private String pagamento;

    public Cliente(String nome, String endereco, String telefone, String pagamento){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.pagamento = pagamento;
    }

    @Override
    public boolean set() {
        return true;
    }

    @Override
    public boolean edit() {
        return false;
    }

    public boolean edit(String name, String endereco, String telefone, String pagamento) {
        this.nome = name;
        this.endereco = endereco;
        this.telefone = telefone;
        this.pagamento = pagamento;
        return true;
    }

    @Override
    public boolean delete() {
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getPagamento() {
        return this.pagamento;
    }
}
