package tp5.repositories;

import tp5.domain.Cliente;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Classe de manipulação de dados de clientes
 *
 * @author Dion Vitor e Eurico Abreu
 * @version 1.0
 */
public class ClientRepository {
    private final ArrayList<Cliente> clients;

    public ClientRepository(ArrayList<Cliente> clients) {
        this.clients = clients;
    }

    /**
     * Método para salvar os dados de clientes
     *
     * @param name nome do cliente
     * @param address endereço do cliente
     * @param phone telefone do cliente
     * @param payment pagamento do cliente
     */
    public void registerClient(String name, String address, String phone, String payment) {
        Cliente client = new Cliente(name, address, phone, payment);
        this.clients.add(client);
    }

    /**
     * Método para deletar os dados de clientes
     *
     * @param name nome do cliente
     */
    public void deleteClient(String name) {
        this.clients.removeIf(client -> Objects.equals(client.getNome(), name));
    }

    /**
     * Método para editar os dados de clientes
     *
     * @param name nome do cliente
     * @param address endereço do cliente
     * @param phone telefone do cliente
     * @param payment pagamento do cliente
     */
    public void editClient(String name, String address, String phone, String payment) {
        for (Cliente client : this.clients) {
            if (Objects.equals(client.getNome(), name)) {
                client.edit(name, address, phone, payment);
            }
        }
    }
}
