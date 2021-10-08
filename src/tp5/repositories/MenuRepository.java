package tp5.repositories;

import tp5.domain.Cardapio;
import tp5.domain.Produto;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Classe de manipulação de dados de cardápios
 *
 * @author Dion Vitor e Eurico Abreu
 * @version 1.0
 */
public class MenuRepository {
    private final ArrayList<Cardapio> menus;

    public MenuRepository(ArrayList<Cardapio> menus) {
        this.menus = menus;
    }

    /**
     * Método para salvar os dados de cardápio
     *
     * @param type nome do cardápio
     */
    public void registerMenu(String type) {
        Cardapio menu = new Cardapio(type, new Produto[] {});
        this.menus.add(menu);
    }
    /**
     * Método para deletar os dados de cardápio
     *
     * @param type nome do cardápio
     */
    public void deleteMenu(String type) {
        this.menus.removeIf(menu -> Objects.equals(menu.getTipo(), type));
    }

    /**
     * Método para editar os dados de cardápio
     *
     * @param type nome do cardápio
     * @param newType nome novo do cardápio
     */
    public void editMenu(String type, String newType) {
        for (Cardapio menu : this.menus) {
            if (Objects.equals(menu.getTipo(), type)) {
                menu.edit(newType);
            }
        }
    }
}
