package controllers;

import view.AuthView;

public class Auth {
	AuthView view;

	public Auth() {
		view = new AuthView();
	}

	public void iniciar() {
		view.iniciar();
	}

	public void login() {
		view.login();
	}

	public void registro() {
		view.registro();
	}
}
