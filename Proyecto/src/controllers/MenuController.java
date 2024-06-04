package controllers;

import view.MenuView;

public class MenuController {
	MenuView view;

	public MenuController() {
		view = new MenuView();
	}

	public void menu() {
		view.menu();
	}
}
