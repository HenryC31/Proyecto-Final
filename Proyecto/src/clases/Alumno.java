package clases;

import java.sql.Date;

public class Alumno {
	private int no_control;
	private String nombre;
	private String ap_Paterno;
	private String ap_Materno;
	private String curp;
	private Date fecha_n;
	private String correo;
	private String telefono;
	private String grupo;

	public Alumno(int no_control, String nombre, String ap_Paterno, String ap_Materno, String curp, Date fecha_n,
			String correo, String telefono, String grupo) {
		this.no_control = no_control;
		this.nombre = nombre;
		this.ap_Paterno = ap_Paterno;
		this.ap_Materno = ap_Materno;
		this.curp = curp;
		this.fecha_n = fecha_n;
		this.correo = correo;
		this.telefono = telefono;
		this.grupo = grupo;
	}

	public Alumno(int no_control, String nombre, String ap_Paterno, String ap_Materno, String telefono, String grupo) {
		this.no_control = no_control;
		this.nombre = nombre;
		this.ap_Paterno = ap_Paterno;
		this.ap_Materno = ap_Materno;
		this.telefono = telefono;
		this.grupo = grupo;
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

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Date getFecha_n() {
		return fecha_n;
	}

	public void setFecha_n(Date fecha_n) {
		this.fecha_n = fecha_n;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
