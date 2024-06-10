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

	private String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_Control_Esc_Project?useSSL=false";
	private String usuario = "freedb_henryc22";
	private String contra = "G9er4**hJF6s52R";

	public AlumnosModel() {

	}

	public List<Alumno> obtenerTodos() {
		List<Alumno> alumnos = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);

			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT no_control, nombre, apellido_M, apellido_P, telefono, grupo\r\n" + "FROM Alumnos");

			while (rs.next()) {
				int noControl = rs.getInt("no_control");
				String nombre = rs.getString("nombre");
				String apellidoM = rs.getString("apellido_M");
				String apellidoP = rs.getString("apellido_P");
				String telefono = rs.getString("telefono");
				String grupo = rs.getString("grupo");

				Alumno alumno = new Alumno(noControl, nombre, apellidoP, apellidoM, telefono, grupo);
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

	public boolean insertarAlumno(Alumno alumno) {
		Connection connection = null;
		java.sql.PreparedStatement statement = null;
		boolean inserted = false;

		try {
			connection = DriverManager.getConnection(url, usuario, contra);
			String query = "INSERT INTO Alumnos (no_control, nombre, apellido_M, apellido_P, curp, fecha_n, correo, telefono, grupo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, alumno.getNo_control());
			statement.setString(2, alumno.getNombre());
			statement.setString(3, alumno.getAp_Materno());
			statement.setString(4, alumno.getAp_Paterno());
			statement.setString(5, alumno.getCurp());
			statement.setDate(6, alumno.getFecha_n());
			statement.setString(7, alumno.getCorreo());
			statement.setString(8, alumno.getTelefono());
			statement.setString(9, alumno.getGrupo());

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

	public Alumno obtenerAlumno(int no_control) {
		Alumno alumno = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Alumnos WHERE no_control = '" + no_control + "'");

			while (rs.next()) {
				alumno = new Alumno(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(5),
						rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9));
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
		return alumno;
	}

	public boolean eliminar(int no_control) {
		boolean eliminado = false;
		Connection con = null;
		Statement stmt = null;
		boolean rs = false;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.execute("delete from Alumnos where no_control = " + no_control + ";");
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

	public boolean editar(int no_control, Alumno alumn) {
		Alumno alumno = alumn;
		boolean editado = false;
		Connection con = null;
		Statement stmt = null;
		boolean rs = false;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.execute("update Alumnos set nombre = '" + alumno.getNombre() + "',apellido_M = '"
					+ alumno.getAp_Materno() + "',apellido_P = '" + alumno.getAp_Paterno() + "',curp = '"
					+ alumno.getCurp() + "',fecha_n = '" + alumno.getFecha_n() + "',correo = '" + alumno.getCorreo()
					+ "',telefono = '" + alumno.getTelefono() + "',grupo = '" + alumno.getGrupo()
					+ "' where no_control = " + no_control + ";");
			editado = true;
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
		return editado;
	}
}
