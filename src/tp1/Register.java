package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
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
                case 4:
                    searchProduct(products);
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
//            System.out.println(client.name + " " + client.address + " " + client.phone);
//        }

        for (Product product : products) {
            System.out.println(product.name + " " + product.description + " " + product.value + " " + product.profit + " " + product.stock);
        }
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
                System.out.println("Dados atuais do cliente:");
                System.out.println("Nome: " + client.name + "\n" +
                                   "Endereço: " + client.address + "\n" +
                                   "Telefone: " + client.phone);
                showLine();

                System.out.print("Deseja alterar os dados? [S/N] ");
                String choice = input.next();
                showLine();

                switch (choice) {
                    case "S":
                    case "s":
                        System.out.print("Digite o novo nome: ");
                        client.name = input.next();
                        showLine();

                        System.out.print("Digite o novo endereço: ");
                        client.address = input.next();
                        showLine();

                        System.out.print("Digite o novo telefone: ");
                        client.phone = input.next();
                        showLine();
                        break;
                    default:
                        break;
                }

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

    public static void searchProduct(ArrayList<Product> products) {
        Scanner input = new Scanner(System.in);
        boolean validSearch = false;

        System.out.print("Digite o nome do produto: ");
        String name = input.next();
        showLine();

        for (Product product : products) {
            if (name.equals(product.name)) {
                System.out.println("Dados atuais do produto:");
                System.out.println("Nome: " + product.name + "\n" +
                                   "Descrição: " + product.description + "\n" +
                                   "Valor: " + product.value + "\n" +
                                   "Lucro: " + product.profit + "\n" +
                                   "Quantidade em estoque: " + product.stock);
                showLine();

                System.out.print("Deseja alterar os dados? [S/N] ");
                String choice = input.next();
                showLine();

                switch (choice) {
                    case "S":
                    case "s":
                        System.out.print("Digite o novo nome: ");
                        product.name = input.next();
                        showLine();

                        System.out.print("Digite a nova descrição: ");
                        product.description = input.next();
                        showLine();

                        System.out.print("Digite o novo valor: ");
                        product.value = input.nextFloat();
                        showLine();

                        System.out.print("Digite o novo lucro: ");
                        product.profit = input.nextFloat();
                        showLine();

                        System.out.print("Digite a nova quantidade em estoque: ");
                        product.stock = input.nextInt();
                        showLine();
                        break;
                    default:
                        break;
                }

                validSearch = true;
                break;
            }
        }

        if (!validSearch) {
            System.out.println("Produto não encontrado!");
            showLine();
        }
    }

    public static void registerSell() {

    }
}
