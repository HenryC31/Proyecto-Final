package controllers;

import view.DocentesView;

public class DocentesController {
	DocentesView view;

	public DocentesController() {
		view = new DocentesView();
	}

	public void docentes() {
		view.docentes();
	}

}
