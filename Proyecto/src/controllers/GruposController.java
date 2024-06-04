package controllers;

import view.GruposView;

public class GruposController {
	GruposView view;

	public GruposController() {
		view = new GruposView();
	}

	public void grupos() {
		view.grupos();
	}

}
