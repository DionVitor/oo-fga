package tp1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        loadData(clients, products);

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
                case 5:
                    registerSell(clients, products);
                    break;
                case 6:
                    showStock(products);
                    break;
                case 7:
                    break;
                default:
                    showLine();
                    System.out.println("Escolha inválida! Tente novamente.");
                    showLine();
            }
        } while (choice != 7);
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

    public static void loadData(ArrayList<Client> clients, ArrayList<Product> products) {
        String[] names = {"João", "Marcelo", "Eurico", "Jonas", "Dion", "Miguel", "Micaele", "Rita", "Lucas", "Pedro"};
        for (String name : names) {
            clients.add(new Client(name, "endereço", "61998822230"));
        }

        String[] productsNames = {
                "Manga", "Iphone", "Goiaba", "TV", "Garrafa", "Fones de ouvido",
                "Livro", "Compurador", "Acetona", "Mouse"
        };
        for (String name : productsNames) {
            products.add(new Product(name, "descrição", 100, 50, 10));
        }
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

    public static void registerSell(ArrayList<Client> clients, ArrayList<Product> products) {
        Scanner input = new Scanner(System.in);
        boolean validClientSearch = false;
        boolean validProductSearch;
        String registerMoreProducts;
        Integer quantityProducts;

        System.out.println("Clientes:");
        for (Client client : clients) {
            System.out.println(client.name);
        }
        showLine();

        System.out.print("Selecione um usuário: ");
        String choice = input.next();
        showLine();

        for (Client client : clients) {
            if (client.name.equals(choice)) {
                validClientSearch = true;
                break;
            }
        }

        if (validClientSearch) {
            do {
                validProductSearch = false;
                quantityProducts = 0;

                System.out.println("Produtos: ");
                for (Product product : products) {
                    System.out.println(product.name);
                }
                showLine();

                System.out.print("Selecione um produto: ");
                String productChoice = input.next();
                showLine();

                for (Product product : products) {
                    if (product.name.equals(productChoice)) {
                        validProductSearch = true;
                        quantityProducts = product.stock;
                        break;
                    }
                }
                if (!validProductSearch) {
                    System.out.println("Produto inválido");
                    showLine();
                } else {
                    System.out.print("Quantos produtos: ");
                    int quantityProductsChoice = input.nextInt();

                    if (quantityProductsChoice > quantityProducts) {
                        System.out.println("Impossível comprar mais que o estoque.");
                    } else {
                        for (Product product : products) {
                            if (product.name.equals(productChoice)) {
                                product.stock -= quantityProductsChoice;
                            }
                        }
                    }
                }

                System.out.print("Deseja tentar cadastrar mais: [S/N] ");
                registerMoreProducts = input.next();
                showLine();

            } while (!registerMoreProducts.equals("N"));

        } else {
            System.out.println("Usuário inválido.");
            showLine();
        }
    }

    public static void showStock(ArrayList<Product> products) {
        showLine();
        for (Product product : products) {
            System.out.println(product.name + " - " + product.stock);
        }
        showLine();
    }
}
