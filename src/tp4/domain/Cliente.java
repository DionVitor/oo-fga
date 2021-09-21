package tp4.domain;

public class Cliente extends CRUD {
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final String pagamento;

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
