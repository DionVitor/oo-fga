package tp5.repositories;

import tp5.domain.Cliente;

import java.util.ArrayList;
import java.util.Objects;

public class ClientRepository {
    private final ArrayList<Cliente> clients;

    public ClientRepository(ArrayList<Cliente> clients) {
        this.clients = clients;
    }

    public void registerClient(String name, String address, String phone, String payment) {
        Cliente client = new Cliente(name, address, phone, payment);
        this.clients.add(client);
    }

    public void deleteClient(String name) {
        this.clients.removeIf(client -> Objects.equals(client.getNome(), name));
    }

    public void editClient(String name, String address, String phone, String payment) {
        for (Cliente client : this.clients) {
            if (Objects.equals(client.getNome(), name)) {
                client.edit(name, address, phone, payment);
            }
        }
    }
}
