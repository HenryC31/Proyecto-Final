package clases;

import java.sql.Date;

public class Docente {

	private String rfc;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private Date fecha_n;
	private String correo;
	private String telefono;

	public Docente(String rfc, String nombre, String ap_Paterno, String ap_Materno, Date fecha_n, String correo,
			String telefono) {
		this.rfc = rfc;
		this.nombre = nombre;
		this.ap_paterno = ap_Paterno;
		this.ap_materno = ap_Materno;
		this.fecha_n = fecha_n;
		this.correo = correo;
		this.telefono = telefono;
	}

	public Docente(String rfc, String nombre, String ap_Paterno, String ap_Materno, String telefono) {
		this.rfc = rfc;
		this.nombre = nombre;
		this.ap_paterno = ap_Paterno;
		this.ap_materno = ap_Materno;
		this.telefono = telefono;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
