package controllers;

import view.AuthView;

public class Auth {
	AuthView view;

	public Auth() {
		view = new AuthView();
	}

	public void login() {
		view.login();
	}

	public void registro() {

	}
}
