package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.MenuController;
import models.AuthModel;

public class AuthView {
//	JPanel panel_principal;
	MenuController controlador;
	JFrame controlEsc;
	JPanel login_panel = new JPanel();
	AuthModel modelo = new AuthModel();

	public AuthView() {

	}

	public void iniciar() {
//		controlador = new Auth();
		controlEsc = new JFrame("Control Escolar");
		controlEsc.setVisible(true);
		controlEsc.setSize(900, 600);
		controlEsc.setResizable(false);
		controlEsc.setLocationRelativeTo(null);
		controlEsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icono = new ImageIcon(getClass().getResource("/media/lapiz.png"));
		controlEsc.setIconImage(icono.getImage());
//		login();
//		menu();
		controlEsc.repaint();
		controlEsc.revalidate();

	}

	public void login() {

		controlEsc.setTitle("Control Escolar - Acceder");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		login_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;

				g2d.setColor(Color.black);
				g2d.fillRoundRect(45, 15, 445, 545, 30, 30);

				g2d.setColor(Color.decode("#E7CD70"));
				g2d.fillRoundRect(55, 20, 425, 530, 30, 30);
				try {
					BufferedImage image = ImageIO.read(getClass().getResource("/media/papeleria.png"));
					g2d.drawImage(image, 560, 230, 273, 277, null);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		login_panel.setLayout(null);

		JPanel login_formulario_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;

				try {
					BufferedImage image = ImageIO.read(getClass().getResource("/media/alumno.png"));
					g2d.drawImage(image, 12, 190, 30, 30, null);

					image = ImageIO.read(getClass().getResource("/media/cerrar-con-llave.png"));
					g2d.drawImage(image, 15, 315, 25, 25, null);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		login_formulario_panel.setBounds(60, 25, 415, 520);
		login_formulario_panel.setBackground(Color.decode("#E7CD70"));
		login_formulario_panel.setLayout(null);

		JLabel control_tag = new JLabel("CONTROL");
		control_tag.setBounds(560, 70, 290, 60);
		control_tag.setFont(new Font("Forte", Font.BOLD, 65));
		login_panel.add(control_tag);

		JLabel escolar_tag = new JLabel("ESCOLAR");
		escolar_tag.setBounds(560, 130, 290, 60);
		escolar_tag.setFont(new Font("Forte", Font.BOLD, 65));
		login_panel.add(escolar_tag);

		JLabel login_tag = new JLabel("ACCEDER");
		login_tag.setBounds(110, 40, 200, 50);
		login_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		login_formulario_panel.add(login_tag);

		JLabel usuario_tag = new JLabel("Usuario");
		usuario_tag.setBounds(50, 140, 120, 30);
		usuario_tag.setFont(new Font("Century", Font.PLAIN, 28));
		login_formulario_panel.add(usuario_tag);

		JTextField usuario_txt = new JTextField();
		usuario_txt.setBounds(50, 190, 320, 35);
		usuario_txt.setFont(new Font("Century", Font.PLAIN, 22));
		login_formulario_panel.add(usuario_txt);

		JLabel contra_tag = new JLabel("Contraseña");
		contra_tag.setBounds(50, 260, 150, 30);
		contra_tag.setFont(new Font("Century", Font.PLAIN, 28));
		login_formulario_panel.add(contra_tag);

		JPasswordField contra_psw = new JPasswordField();
		contra_psw.setBounds(50, 310, 320, 35);
		contra_psw.setFont(new Font("Century", Font.PLAIN, 22));
		login_formulario_panel.add(contra_psw);

		JButton login_btn = new JButton("Acceder");
		login_btn.setBounds(143, 400, 135, 50);
		login_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		login_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = new String(contra_psw.getPassword());
				System.out.println(pass);
				if (modelo.login(usuario_txt.getText(), pass)) {
					controlEsc.dispose();
					controlador = new MenuController();
					controlador.menu();
				} else {
					JOptionPane.showMessageDialog(controlEsc, "Verifica los datos papito");
				}
			}
		});
		login_formulario_panel.add(login_btn);

		JLabel olvidaste_tag = new JLabel("¿No tienes cuenta?");
		olvidaste_tag.setBounds(120, 455, 200, 25);
		login_formulario_panel.add(olvidaste_tag);

		JLabel registrate_tag = new JLabel("<html><u>Regístrate</u></html>");
		registrate_tag.setBounds(250, 455, 65, 25);
		registrate_tag.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				controlEsc.getContentPane().removeAll();
				registro();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		login_formulario_panel.add(registrate_tag);

		login_panel.add(login_formulario_panel);
		controlEsc.add(login_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void registro() {

		controlEsc.setTitle("Control Escolar - Registro");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		JPanel registro_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;

				g2d.setColor(Color.black);
				g2d.fillRoundRect(45, 15, 445, 545, 30, 30);

				g2d.setColor(Color.decode("#E7CD70"));
				g2d.fillRoundRect(55, 20, 425, 530, 30, 30);
				try {
					BufferedImage image = ImageIO.read(getClass().getResource("/media/papeleria.png"));
					g2d.drawImage(image, 560, 230, 273, 277, null);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		registro_panel.setLayout(null);

		JPanel registro_formulario_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;

				try {
					BufferedImage image = ImageIO.read(getClass().getResource("/media/alumno.png"));
					g2d.drawImage(image, 12, 205, 30, 30, null);

					image = ImageIO.read(getClass().getResource("/media/nombre.png"));
					g2d.drawImage(image, 15, 125, 25, 25, null);

					image = ImageIO.read(getClass().getResource("/media/cerrar-con-llave.png"));
					g2d.drawImage(image, 15, 295, 25, 25, null);

					g2d.drawImage(image, 15, 380, 25, 25, null);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		registro_formulario_panel.setBounds(60, 25, 415, 520);
		registro_formulario_panel.setBackground(Color.decode("#E7CD70"));
		registro_formulario_panel.setLayout(null);

		JLabel control_tag = new JLabel("CONTROL");
		control_tag.setBounds(560, 70, 290, 60);
		control_tag.setFont(new Font("Forte", Font.BOLD, 65));
		registro_panel.add(control_tag);

		JLabel escolar_tag = new JLabel("ESCOLAR");
		escolar_tag.setBounds(560, 130, 290, 60);
		escolar_tag.setFont(new Font("Forte", Font.BOLD, 65));
		registro_panel.add(escolar_tag);

		JLabel login_tag = new JLabel("REGISTRO");
		login_tag.setBounds(100, 10, 220, 50);
		login_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		registro_formulario_panel.add(login_tag);

		JLabel nombre_tag = new JLabel("Nombre");
		nombre_tag.setBounds(50, 80, 120, 30);
		nombre_tag.setFont(new Font("Century", Font.PLAIN, 28));
		registro_formulario_panel.add(nombre_tag);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setBounds(50, 120, 320, 35);
		nombre_txt.setFont(new Font("Century", Font.PLAIN, 22));
		registro_formulario_panel.add(nombre_txt);

		JLabel usuario_tag = new JLabel("Usuario");
		usuario_tag.setBounds(50, 165, 120, 30);
		usuario_tag.setFont(new Font("Century", Font.PLAIN, 28));
		registro_formulario_panel.add(usuario_tag);

		JTextField usuario_txt = new JTextField();
		usuario_txt.setBounds(50, 205, 320, 35);
		usuario_txt.setFont(new Font("Century", Font.PLAIN, 22));
		registro_formulario_panel.add(usuario_txt);

		JLabel contra_tag = new JLabel("Contraseña");
		contra_tag.setBounds(50, 250, 150, 30);
		contra_tag.setFont(new Font("Century", Font.PLAIN, 28));
		registro_formulario_panel.add(contra_tag);

		JPasswordField contra_psw = new JPasswordField();
		contra_psw.setBounds(50, 290, 320, 35);
		contra_psw.setFont(new Font("Century", Font.PLAIN, 22));
		registro_formulario_panel.add(contra_psw);

		JLabel confirmar_tag = new JLabel("Confirmar Contraseña");
		confirmar_tag.setBounds(50, 335, 300, 30);
		confirmar_tag.setFont(new Font("Century", Font.PLAIN, 28));
		registro_formulario_panel.add(confirmar_tag);

		JPasswordField confirmar_psw = new JPasswordField();
		confirmar_psw.setBounds(50, 375, 320, 35);
		confirmar_psw.setFont(new Font("Century", Font.PLAIN, 22));
		registro_formulario_panel.add(confirmar_psw);

		JButton registro_btn = new JButton("Registrarse");
		registro_btn.setBounds(210, 450, 155, 50);
		registro_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		registro_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cont = new String(contra_psw.getPassword());
				String conf = new String(confirmar_psw.getPassword());
				if (nombre_txt.getText().isEmpty() || usuario_txt.getText().isEmpty() || contra_psw.getText().isEmpty()
						|| confirmar_psw.getText().isEmpty()) {
					JOptionPane.showMessageDialog(registro_panel, "Por favor, rellena todos los campos");
				} else {
					if (cont.equals(conf)) {
						if (modelo.registro(nombre_txt.getText(), usuario_txt.getText(), cont)) {
							JOptionPane.showMessageDialog(registro_panel, "Registro exitoso");
							controlEsc.getContentPane().removeAll();
							login();
						} else {
							JOptionPane.showMessageDialog(registro_panel, "Algo salió mal");
						}
						System.out.println("Si jala");
					} else {
						JOptionPane.showMessageDialog(registro_panel, "Las contraseñas no coinciden");
					}
				}
			}
		});
		registro_formulario_panel.add(registro_btn);

		JButton cancelar_btn = new JButton("Cancelar");
		cancelar_btn.setBounds(50, 450, 135, 50);
		cancelar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		cancelar_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(registro_panel, "¿Seguro que desea cancelar?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.out.println("si");
					controlEsc.getContentPane().removeAll();
					login();
				}
			}
		});
		registro_formulario_panel.add(cancelar_btn);

		registro_panel.add(registro_formulario_panel);
		controlEsc.add(registro_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

}
