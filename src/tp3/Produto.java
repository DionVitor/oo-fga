package tp3;

import tp3.CRUD;

public class Produto extends CRUD {
    private String nome;
    private double preco;
    private String descricao;
    private int estoque;

    public boolean set(){
        return true;
    };
    public boolean edit(){
        return true;
    };
    public boolean delete(){
        return true;
    };
}
