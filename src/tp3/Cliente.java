package tp3;

import tp3.CRUD;

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

    public boolean set(){
        return true;
    }
    public boolean edit(){
        return true;
    }
    public boolean delete(){
        return true;
    }
}