package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

public class MenuView {
	JFrame controlEsc;
	JPanel menu_panel;

	public MenuView() {
		iniciar();
	}

	public void iniciar() {
//		controlador = new Auth();
		controlEsc = new JFrame("Control Escolar - Menú");
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
//				alumnos();
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
//				docentes();
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
//				materias();
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
//				grupos();
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
//				iniciado = false;
//				controlEsc.getContentPane().removeAll();
//				login();
			}
		});
		menu_panel.add(salir_btn);

		controlEsc.add(menu_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}
}
