package controllers;

import view.MateriasView;

public class MateriasController {
	MateriasView view;

	public MateriasController() {
		view = new MateriasView();
	}

	public void materias() {
		view.materias();
	}

}
