package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Docente;

public class DocentesModel {

	private String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_Control_Esc_Project?useSSL=false";
	private String usuario = "freedb_henryc22";
	private String contra = "G9er4**hJF6s52R";

	public DocentesModel() {

	}

	public List<Docente> obtenerTodos() {
		List<Docente> docentes = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT rfc, nombre, ap_paterno, ap_materno, telefono\r\n" + "FROM Docentes");

			while (rs.next()) {
				String rfc = rs.getString("rfc");
				String nombre = rs.getString("nombre");
				String apellidoM = rs.getString("ap_paterno");
				String apellidoP = rs.getString("ap_materno");
				String telefono = rs.getString("telefono");

				Docente docente = new Docente(rfc, nombre, apellidoP, apellidoM, telefono);
				docentes.add(docente);
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
		return docentes;
	}

	public boolean insertarDocente(Docente docente) {
		Connection connection = null;
		java.sql.PreparedStatement statement = null;
		boolean inserted = false;

		try {
			connection = DriverManager.getConnection(url, usuario, contra);
			String query = "INSERT INTO Docentes (rfc, nombre, ap_paterno, ap_materno, fecha_n, correo, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, docente.getRfc());
			statement.setString(2, docente.getNombre());
			statement.setString(4, docente.getAp_paterno());
			statement.setString(3, docente.getAp_materno());
			statement.setDate(5, docente.getFecha_n());
			statement.setString(6, docente.getCorreo());
			statement.setString(7, docente.getTelefono());

			int rows = statement.executeUpdate();
			inserted = rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return inserted;
	}

	public Docente obtenerDocente(String rfc) {
		Docente docente = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Docentes WHERE rfc = '" + rfc + "'");

			while (rs.next()) {
				docente = new Docente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getString(6), rs.getString(7));
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
		return docente;
	}

	public boolean eliminar(String rfc) {
		boolean eliminado = false;
		Connection con = null;
		Statement stmt = null;
		boolean rs = false;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.execute("delete from Alumnos where rfc = " + rfc + ";");
			eliminado = true;
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eliminado;
	}

//	public boolean editar(int no_control, Alumno alumn) {
//		Alumno alumno = alumn;
//		boolean editado = false;
//		Connection con = null;
//		Statement stmt = null;
//		boolean rs = false;
//		try {
//			con = DriverManager.getConnection(url, usuario, contra);
//			stmt = con.createStatement();
//			rs = stmt.execute("update Alumnos set nombre = '" + alumno.getNombre() + "',apellido_M = '"
//					+ alumno.getAp_Materno() + "',apellido_P = '" + alumno.getAp_Paterno() + "',curp = '"
//					+ alumno.getCurp() + "',fecha_n = '" + alumno.getFecha_n() + "',correo = '" + alumno.getCorreo()
//					+ "',telefono = '" + alumno.getTelefono() + "' where no_control = " + no_control + ";");
//			editado = true;
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					stmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return editado;
//	}

}
