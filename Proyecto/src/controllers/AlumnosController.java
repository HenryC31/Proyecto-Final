package controllers;

import view.AlumnosView;

public class AlumnosController {
	AlumnosView view;

	public AlumnosController() {
		view = new AlumnosView();
	}

	public void alumnos() {
		view.alumnos();
	}

}
