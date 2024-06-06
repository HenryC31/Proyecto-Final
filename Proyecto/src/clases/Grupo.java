package clases;

public class Grupo {
	private int id;
	private String nombre;
	private String profesor;
	private String materia_uno;
	private String materia_dos;
	private String materia_tres;

	public Grupo(String nombre, String profesor, String materia_uno, String materia_dos, String materia_tres) {
		this.nombre = nombre;
		this.profesor = profesor;
		this.materia_dos = materia_dos;
		this.materia_tres = materia_tres;
		this.materia_uno = materia_uno;
	}

	public Grupo(int id, String nombre, String profesor, String materia_uno, String materia_dos, String materia_tres) {
		this.id = id;
		this.nombre = nombre;
		this.profesor = profesor;
		this.materia_dos = materia_dos;
		this.materia_tres = materia_tres;
		this.materia_uno = materia_uno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMateria_uno() {
		return materia_uno;
	}

	public void setMateria_uno(String materia_uno) {
		this.materia_uno = materia_uno;
	}

	public String getMateria_dos() {
		return materia_dos;
	}

	public void setMateria_dos(String materia_dos) {
		this.materia_dos = materia_dos;
	}

	public String getMateria_tres() {
		return materia_tres;
	}

	public void setMateria_tres(String materia_tres) {
		this.materia_tres = materia_tres;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

}
