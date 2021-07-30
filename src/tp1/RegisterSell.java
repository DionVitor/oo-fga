package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterSell {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

//        loadData(clients);

        showLine();
        int choice;

        do {
            showMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    registerClients(clients);
                    break;
                case 2:
                    searchClient(clients);
                    break;
                case 3:
                    registerProduct(products);
                    break;

                case 7:
                    break;
                default:
                    showLine();
                    System.out.println("Escolha inválida! Tente novamente.");
                    showLine();
            }
        } while (choice != 7);

//        for (Client client : clients) {
//            System.out.println(client.name + "" + client.address + "" + client.phone);
//        }
    }

    public static void showMenu() {
        System.out.println("1 - Cadastro de novo cliente\n" +
                           "2 - Busca por cliente\n" +
                           "3 - Cadastro de novo produto\n" +
                           "4 - Busca por produto\n" +
                           "5 - Cadastro de vendas\n" +
                           "6 - Mostrar produtos em estoque\n" +
                           "7 - Sair\n" +
                           "----------------------------------");
    }

    public static void showLine() {
        System.out.println("----------------------------------");
    }

    public static void loadData(ArrayList<Client> clients) {

    }

    public static void registerClients(ArrayList<Client> clients) {
        Scanner input = new Scanner(System.in);

        System.out.println("Quantos clientes você quer cadastrar?");
        int quantityClients = input.nextInt();
        showLine();

        for (int i = 1; i <= quantityClients; i++) {
            System.out.println("Cliente " + i);

            System.out.print("Nome: ");
            String name = input.next();

            System.out.print("Endereço: ");
            String address = input.next();

            System.out.print("Telefone: ");
            String phone = input.next();

            clients.add(new Client(name, address, phone));
            showLine();
        }
    }

    public static void searchClient(ArrayList<Client> clients) {
        Scanner input = new Scanner(System.in);
        boolean validSearch = false;

        System.out.print("Digite o nome do cliente: ");
        String name = input.next();
        showLine();

        for (Client client : clients) {
            if (name.equals(client.name)) {

                System.out.print("Digite o novo nome: ");
                client.name = input.next();
                showLine();

                System.out.print("Digite o novo endereço: ");
                client.address = input.next();
                showLine();

                System.out.print("Digite o novo telefone: ");
                client.phone = input.next();
                showLine();

                validSearch = true;
                break;
            }
        }

        if (!validSearch) {
            System.out.println("Cliente não encontrado!");
            showLine();
        }
    }

    public static void registerProduct(ArrayList<Product> products) {
        Scanner input = new Scanner(System.in);

        System.out.println("Quantos produtos você quer cadastrar?");
        int quantityProducts = input.nextInt();
        showLine();

        for (int i = 1; i <= quantityProducts; i++) {
            System.out.println("Produto " + i);

            System.out.print("Nome: ");
            String name = input.next();

            System.out.print("Descrição: ");
            String description = input.next();

            System.out.print("Valor: ");
            Float value = input.nextFloat();

            System.out.print("Lucro: ");
            Float profit = input.nextFloat();

            System.out.print("Quantidade em estoque: ");
            Integer stock = input.nextInt();

            products.add(new Product(name, description, value, profit, stock));
            showLine();
        }
    }
}
