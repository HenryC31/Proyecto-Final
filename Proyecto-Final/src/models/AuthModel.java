package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthModel {

	private String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_Control_Esc_Project";
	private String usuario = "freedb_henryc22";
	private String contra = "G9er4**hJF6s52R";

	public AuthModel() {

	}

	public boolean login(String usu, String contrase) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, usuario, contra);
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT * FROM cuentas WHERE usuario = '" + usu + "' and contra = '" + contrase + "'");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				return true;
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
		return false;
	}
}
