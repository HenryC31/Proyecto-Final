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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Proyecto {
	JFrame controlEsc = new JFrame("Control Escolar");
	JPanel menu_panel, login_panel, alumnos_panel, editar_alumnos_panel, agregar_alumnos_panel, agregar_docentes_panel,
			editar_docentes_panel, docentes_panel, agregar_materias_panel, editar_materias_panel, materias_panel,
			grupos_panel;

	boolean iniciado = false;

	public static void main(String[] args) {
		Proyecto proyecto = new Proyecto();
	}

	public Proyecto() {
		iniciar();
	}
//
//	public void quitar_paneles() {
//		for (int i = 0; i < paneles.length; i++) {
//			controlEsc.getContentPane().remove(paneles[i]);
//		}
//	}

	public void iniciar() {
		controlEsc.setVisible(true);
		controlEsc.setSize(900, 600);
		controlEsc.setResizable(false);
		controlEsc.setLocationRelativeTo(null);
		controlEsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icono = new ImageIcon(getClass().getResource("/media/lapiz.png"));
		controlEsc.setIconImage(icono.getImage());
		login();
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
//				quitar_paneles();
				controlEsc.getContentPane().removeAll();
				iniciado = true;
				menu();

			}
		});
		login_formulario_panel.add(login_btn);

		JLabel crear_cuenta_tag = new JLabel("<html>¿No tienes cuenta?  <u>Regístrate</u></html>");
		crear_cuenta_tag.setBounds(120, 460, 180, 25);
		login_formulario_panel.add(crear_cuenta_tag);

		login_panel.add(login_formulario_panel);
		controlEsc.add(login_panel);
		controlEsc.repaint();
		controlEsc.revalidate();

	}

	public void menu() {
		controlEsc.setTitle("Control Escolar - Menú");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		menu_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;

				g2d.setColor(Color.black);
				g2d.fillRoundRect(20, 10, 850, 545, 30, 30);

				g2d.setColor(Color.decode("#E7CD70"));
				g2d.fillRoundRect(30, 15, 830, 535, 30, 30);

				try {
					BufferedImage image = ImageIO.read(getClass().getResource("/media/alumno (1).png"));
					g2d.drawImage(image, 115, 160, 130, 130, null);

					image = ImageIO.read(getClass().getResource("/media/instructor.png"));
					g2d.drawImage(image, 380, 160, 130, 130, null);

					image = ImageIO.read(getClass().getResource("/media/papeleria.png"));
					g2d.drawImage(image, 650, 160, 130, 130, null);

					image = ImageIO.read(getClass().getResource("/media/reunion.png"));
					g2d.drawImage(image, 115, 360, 130, 130, null);

					image = ImageIO.read(getClass().getResource("/media/salida.png"));
					g2d.drawImage(image, 650, 360, 130, 130, null);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		menu_panel.setLayout(null);

		JLabel menu_tag = new JLabel("MENÚ");
		menu_tag.setBounds(380, 50, 135, 50);
		menu_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		menu_panel.add(menu_tag);

		JLabel alumnos_tag = new JLabel("Alumnos");
		alumnos_tag.setBounds(140, 300, 130, 20);
		alumnos_tag.setFont(new Font("", Font.BOLD, 20));

		JLabel docentes_tag = new JLabel("Docentes");
		docentes_tag.setBounds(395, 300, 130, 20);
		docentes_tag.setFont(new Font("", Font.BOLD, 20));

		JLabel materias_tag = new JLabel("Materias");
		materias_tag.setBounds(675, 300, 130, 20);
		materias_tag.setFont(new Font("", Font.BOLD, 20));

		JLabel grupos_tag = new JLabel("Grupos");
		grupos_tag.setBounds(145, 500, 130, 20);
		grupos_tag.setFont(new Font("", Font.BOLD, 20));

		JLabel salir_tag = new JLabel("Salir");
		salir_tag.setBounds(695, 500, 130, 20);
		salir_tag.setFont(new Font("", Font.BOLD, 20));

		menu_panel.add(alumnos_tag);
		menu_panel.add(docentes_tag);
		menu_panel.add(materias_tag);
		menu_panel.add(grupos_tag);
		menu_panel.add(salir_tag);

		JButton alumnos_btn = new JButton();
		alumnos_btn.setBounds(95, 150, 170, 160);
		alumnos_btn.setBorderPainted(false);
		alumnos_btn.setContentAreaFilled(false);
		alumnos_btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#E7CD70"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#FFF5D1"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controlEsc.getContentPane().removeAll();
				alumnos();
			}
		});
		menu_panel.add(alumnos_btn);

		JButton docentes_btn = new JButton();
		docentes_btn.setBounds(380, 160, 130, 160);
		docentes_btn.setBorderPainted(false);
		docentes_btn.setContentAreaFilled(false);
		docentes_btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#E7CD70"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#FFF5D1"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controlEsc.getContentPane().removeAll();
				docentes();
			}
		});
		menu_panel.add(docentes_btn);

		JButton materias_btn = new JButton();
		materias_btn.setBounds(650, 160, 130, 160);
		materias_btn.setBorderPainted(false);
		materias_btn.setContentAreaFilled(false);
		materias_btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#E7CD70"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#FFF5D1"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controlEsc.getContentPane().removeAll();
				materias();
			}
		});
		menu_panel.add(materias_btn);

		JButton grupos_btn = new JButton();
		grupos_btn.setBounds(115, 360, 130, 160);
		grupos_btn.setBorderPainted(false);
		grupos_btn.setContentAreaFilled(false);
		grupos_btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#E7CD70"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#FFF5D1"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controlEsc.getContentPane().removeAll();
				grupos();
			}
		});
		menu_panel.add(grupos_btn);

		JButton salir_btn = new JButton();
		salir_btn.setBounds(650, 360, 130, 160);
		salir_btn.setBorderPainted(false);
		salir_btn.setContentAreaFilled(false);
		salir_btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#E7CD70"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controlEsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				fondo_alumno.setBackground(Color.decode("#FFF5D1"));
//				controlEsc.repaint();
//				controlEsc.revalidate();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				iniciado = false;
				controlEsc.getContentPane().removeAll();
				login();
			}
		});
		menu_panel.add(salir_btn);

		controlEsc.add(menu_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void alumnos() {
		controlEsc.setTitle("Control Escolar - Alumnos");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		alumnos_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;

				pintar_bases(alumnos_panel, g2d);
			}
		};
		alumnos_panel.setLayout(null);

		JLabel alumnos_tag = new JLabel("ALUMNOS");
		alumnos_tag.setBounds(340, 50, 210, 50);
		alumnos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		alumnos_panel.add(alumnos_tag);

		controlEsc.add(alumnos_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void docentes() {
		controlEsc.setTitle("Control Escolar - Docentes");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		docentes_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;

				pintar_bases(docentes_panel, g2d);
			}
		};
		docentes_panel.setLayout(null);

		JLabel docentes_tag = new JLabel("DOCENTES");
		docentes_tag.setBounds(320, 50, 240, 50);
		docentes_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		docentes_panel.add(docentes_tag);

		controlEsc.add(docentes_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void materias() {
		controlEsc.setTitle("Control Escolar - Materias");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		materias_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;
				pintar_bases(materias_panel, g2d);
			}
		};
		materias_panel.setLayout(null);

		JLabel materias_tag = new JLabel("MATERIAS");
		materias_tag.setBounds(330, 50, 220, 50);
		materias_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		materias_panel.add(materias_tag);

		controlEsc.add(materias_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void grupos() {
		controlEsc.setTitle("Control Escolar - Grupos");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		grupos_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;
				pintar_bases(grupos_panel, g2d);
			}
		};
		grupos_panel.setLayout(null);

		JLabel grupos_tag = new JLabel("GRUPOS");
		grupos_tag.setBounds(340, 50, 180, 50);
		grupos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		grupos_panel.add(grupos_tag);

		controlEsc.add(grupos_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void pintar_bases(JPanel panel, Graphics2D g2d) {
		g2d.setColor(Color.black);
		g2d.fillRoundRect(20, 10, 850, 545, 30, 30);

		g2d.setColor(Color.decode("#E7CD70"));
		g2d.fillRoundRect(30, 15, 830, 535, 30, 30);
		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/media/boton-de-retroceso.png"));
			g2d.drawImage(image, 40, 25, 50, 50, null);

		} catch (IOException e) {
			e.printStackTrace();
		}

		JButton regresar_btn = new JButton();
		regresar_btn.setBounds(40, 25, 50, 50);
		regresar_btn.setBorderPainted(false);
		regresar_btn.setContentAreaFilled(false);
		regresar_btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

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
		regresar_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlEsc.getContentPane().removeAll();
				menu();
			}
		});
		panel.add(regresar_btn);
	}
}
