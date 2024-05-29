package clases;

public class Alumno {
	private int no_control;
	private String nombre;
	private String ap_Paterno;
	private String ap_Materno;
	private String telefono;

	public Alumno(int no_control, String nombre, String ap_Paterno, String ap_Materno, String telefono) {
		this.no_control = no_control;
		this.nombre = nombre;
		this.ap_Paterno = ap_Paterno;
		this.ap_Materno = ap_Materno;
		this.telefono = telefono;
	}

	public int getNo_control() {
		return no_control;
	}

	public void setNo_control(int no_control) {
		this.no_control = no_control;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_Paterno() {
		return ap_Paterno;
	}

	public void setAp_Paterno(String ap_Paterno) {
		this.ap_Paterno = ap_Paterno;
	}

	public String getAp_Materno() {
		return ap_Materno;
	}

	public void setAp_Materno(String ap_Materno) {
		this.ap_Materno = ap_Materno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}