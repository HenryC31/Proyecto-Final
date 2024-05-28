package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnosModel {

	public AlumnosModel() {

	}

	public String consultar() {
		List<String[]> datos = new ArrayList<>();
		String[] dato = new String[5];
		String hola = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Control_Esc_Project",
					"freedb_henryc22", "G9er4**hJF6s52R");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT no_control, nombre, apellido_M, apellido_P, curp, fecha_n, correo, telefono\r\n"
							+ "FROM Alumnos");

			while (rs.next()) {
//				dato[0] = rs.getString(1);
//				dato[1] = rs.getString(2);
//				dato[2] = rs.getString(3);
//				dato[3] = rs.getString(4);
//				dato[4] = rs.getString(8);
//				datos.add(dato);
				hola = rs.getInt(1) + rs.getString(2) + rs.getString(3);

//				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + rs.getString(4) + " "
//						+ rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8));
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//		return datos;
		return hola;
	}
}
