package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Alumno;

public class AlumnosModel {

	public AlumnosModel() {

	}

	public List<Alumno> obtener() {
		List<Alumno> alumnos = new ArrayList<>();
		String[] dato = new String[5];
		String hola = "";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Control_Esc_Project",
					"freedb_henryc22", "G9er4**hJF6s52R");

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT no_control, nombre, apellido_M, apellido_P, telefono\r\n" + "FROM Alumnos");

			while (rs.next()) {
				int noControl = rs.getInt("no_control");
				String nombre = rs.getString("nombre");
				String apellidoM = rs.getString("apellido_M");
				String apellidoP = rs.getString("apellido_P");
				String telefono = rs.getString("telefono");

				Alumno alumno = new Alumno(noControl, nombre, apellidoP, apellidoM, telefono);
				alumnos.add(alumno);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alumnos;
	}

	public boolean agregar(String no_control, String nombre, String ap_Paterno, String ap_Materno, String curp,
			String fecha_n, String correo, String telefono) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Control_Esc_Project",
					"freedb_henryc22", "G9er4**hJF6s52R");

			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"INSERT INTO Alumnos (no_control, nombre, apellido_M, apellido_P, curp, fecha_n, correo, telefono) VALUES ('"
							+ no_control + "', '" + nombre + "', '" + ap_Paterno + "', '" + ap_Materno + "', '" + curp
							+ "', '" + fecha_n + "', '" + correo + "', '" + telefono + "')");
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
