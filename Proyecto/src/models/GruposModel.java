package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Docente;
import clases.Grupo;

public class GruposModel {
	private String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_Control_Esc_Project?useSSL=false";
	private String usuario = "freedb_henryc22";
	private String contra = "G9er4**hJF6s52R";

	public GruposModel() {

	}

	public List<Grupo> obtenerTodos() {
		List<Grupo> grupos = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);

			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT id, nombre, profesor, materia_uno, materia_dos,materia_tres\r\n" + "FROM grupos");

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String profesor = rs.getString("profesor");
				String materia_uno = rs.getString("materia_uno");
				String materia_dos = rs.getString("materia_dos");
				String materia_tres = rs.getString("materia_tres");

				Grupo grupo = new Grupo(id, nombre, profesor, materia_uno, materia_dos, materia_tres);
				grupos.add(grupo);
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
		return grupos;
	}

	public boolean insertarGrupo(Grupo grupo) {
		Connection connection = null;
		java.sql.PreparedStatement statement = null;
		boolean insertado = false;

		try {
			connection = DriverManager.getConnection(url, usuario, contra);
			String query = "INSERT INTO grupos (nombre, profesor, materia_uno, materia_dos, materia_tres) VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, grupo.getNombre());
			statement.setString(2, grupo.getProfesor());
			statement.setString(3, grupo.getMateria_uno());
			statement.setString(4, grupo.getMateria_dos());
			statement.setString(5, grupo.getMateria_tres());

			int rows = statement.executeUpdate();
			insertado = rows > 0;
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
		return insertado;
	}

	public Grupo obtenerGrupo(int id) {
		Grupo grupo = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM grupos WHERE id = '" + id + "'");

			while (rs.next()) {
				grupo = new Grupo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
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
		return grupo;
	}

	public boolean eliminar(int id) {
		boolean eliminado = false;
		Connection con = null;
		Statement stmt = null;
		boolean rs = false;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.execute("delete from grupos where id = " + id + ";");
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

	public boolean editar(int id, Docente docent) {
		Docente docente = docent;
		boolean editado = false;
		Connection con = null;
		Statement stmt = null;
		boolean rs = false;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.execute("update Docentes set nombre = '" + docente.getNombre() + "',ap_paterno = '"
					+ docente.getAp_paterno() + "',ap_materno = '" + docente.getAp_materno() + "',fecha_nac = '"
					+ docente.getFecha_n() + "',correo = '" + docente.getCorreo() + "',telefono = '"
					+ docente.getTelefono() + "' where id = " + id + ";");
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
