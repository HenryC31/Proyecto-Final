package clases;

public class Materia {
	private int id;
	private String nombre;
	private String horario;
	private String aula;

	public Materia(String nombre, String horario, String aula) {
		this.nombre = nombre;
		this.horario = horario;
		this.aula = aula;
	}

	public Materia(int id, String nombre, String horario, String aula) {
		this.id = id;
		this.nombre = nombre;
		this.horario = horario;
		this.aula = aula;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

}
