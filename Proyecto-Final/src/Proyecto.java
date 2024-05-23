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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Proyecto {
	JFrame controlEsc = new JFrame("Control Escolar");
	JPanel menu_panel, login_panel, alumnos_panel, editar_alumnos_panel, agregar_alumnos_panel, agregar_docentes_panel,
			editar_docentes_panel, docentes_panel, agregar_materias_panel, editar_materias_panel, materias_panel,
			grupos_panel;

	boolean iniciado = false;

//	public static void main(String[] args) {
//		Proyecto proyecto = new Proyecto();
//	}

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

	}

	public void login() {

	}

	public void buscador() {
		JFileChooser busc = new JFileChooser();
		int opcion = busc.showOpenDialog(controlEsc);
		File archivo = busc.getSelectedFile();
		try {
			String origen = archivo.getPath();
			ImageIcon icono = new ImageIcon(origen);
			controlEsc.setIconImage(icono.getImage());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Selecciona un archivo válido", "Error en tipo de archivo",
					JOptionPane.WARNING_MESSAGE);
			e2.printStackTrace();
		}
	}

	public void menu() {

	}

	public void alumnos() {
		controlEsc.setTitle("Control Escolar - Alumnos");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		alumnos_panel = new JPanel() {
			@Override
			public void paintComponent(Graphics create) {
				super.paintComponent(create);
				Graphics2D g2d = (Graphics2D) create;

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
					}
				});
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