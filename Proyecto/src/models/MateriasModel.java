package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Materia;

public class MateriasModel {
	private String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_Control_Esc_Project?useSSL=false";
	private String usuario = "freedb_henryc22";
	private String contra = "G9er4**hJF6s52R";

	public MateriasModel() {

	}

	public List<Materia> obtenerTodos() {
		List<Materia> materias = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT id, nombre, horario, aula\r\n" + "FROM materias");

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String horario = rs.getString("horario");
				String aula = rs.getString("aula");

				Materia materia = new Materia(id, nombre, horario, aula);
				materias.add(materia);
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
		return materias;
	}

	public boolean insertarMateria(Materia materia) {
		Connection connection = null;
		java.sql.PreparedStatement statement = null;
		boolean insertado = false;

		try {
			connection = DriverManager.getConnection(url, usuario, contra);
			String query = "INSERT INTO materias (nombre, horario, aula) VALUES (?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, materia.getNombre());
			statement.setString(2, materia.getHorario());
			statement.setString(3, materia.getAula());

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

	public Materia obtenerMateria(int id) {
		Materia materia = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM materias WHERE id = '" + id + "'");

			while (rs.next()) {
				materia = new Materia(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
		return materia;
	}

	public boolean eliminar(int id) {
		boolean eliminado = false;
		Connection con = null;
		Statement stmt = null;
		boolean rs = false;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.execute("delete from materias where id = " + id + ";");
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

	public boolean editar(int id, Materia mat) {
		Materia materia = mat;
		boolean editado = false;
		Connection con = null;
		Statement stmt = null;
		boolean rs = false;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.execute("update materias set nombre = '" + materia.getNombre() + "',horario = '"
					+ materia.getHorario() + "',aula = '" + materia.getAula() + "' where id = " + id + ";");
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
