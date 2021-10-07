package tp5.repositories;

import tp5.domain.Cardapio;
import tp5.domain.Produto;

import java.util.ArrayList;
import java.util.Objects;


public class MenuRepository {
    private final ArrayList<Cardapio> menus;

    public MenuRepository(ArrayList<Cardapio> menus) {
        this.menus = menus;
    }

    public void registerMenu(String type) {
        Cardapio menu = new Cardapio(type, new Produto[] {});
        this.menus.add(menu);
    }

    public void deleteMenu(String type) {
        this.menus.removeIf(menu -> Objects.equals(menu.getTipo(), type));
    }

    public void editMenu(String type, String newType) {
        for (Cardapio menu : this.menus) {
            if (Objects.equals(menu.getTipo(), type)) {
                menu.edit(newType);
            }
        }
    }
}
