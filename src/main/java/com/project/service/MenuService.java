package com.project.service;

import com.project.model.Menu;
import com.project.repository.MenuRepository;
import java.util.List;

public class MenuService {

    private final MenuRepository menuRepository = new MenuRepository();

    public MenuService(MenuRepository menuRepository) {
    }

    public List<Menu> getAllMenus() {
        return menuRepository.retrieveMenus();
    }

    public Menu getMenuById(long id) {
        return menuRepository.findById(id);
    }

    public void addMenu(Menu menu) {
        menuRepository.createMenu(menu);
    }

    public void updateMenu(Menu menu) {
        menuRepository.updateMenu(menu);
    }

    public void removeMenu(long id) {
        menuRepository.deleteMenu(id);
    }
}
