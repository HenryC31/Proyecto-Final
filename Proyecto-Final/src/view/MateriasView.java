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
import javax.swing.JPanel;

import controllers.MenuController;

public class MateriasView {

	MenuController menu;
	JFrame controlEsc = new JFrame();
	JPanel materias_panel = new JPanel();

	public MateriasView() {
		controlEsc.setTitle("Control Escolar - Materias");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		controlEsc.setVisible(true);
		controlEsc.setSize(900, 600);
		controlEsc.setResizable(false);
		controlEsc.setLocationRelativeTo(null);
		controlEsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icono = new ImageIcon(getClass().getResource("/media/lapiz.png"));
		controlEsc.setIconImage(icono.getImage());
	}

	public void materias() {
		materias_panel = new JPanel() {
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

			}
		};
		materias_panel.setLayout(null);

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
				controlEsc.dispose();
				menu = new MenuController();
				menu.menu();
			}
		});

		materias_panel.add(regresar_btn);

		JLabel materias_tag = new JLabel("MATERIAS");
		materias_tag.setBounds(340, 50, 210, 50);
		materias_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		materias_panel.add(materias_tag);

		JButton detalles_btn = new JButton("Detalles");
		detalles_btn.setBounds(143, 450, 135, 50);
		detalles_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		detalles_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlEsc.getContentPane().removeAll();
				detalles();
			}
		});
		materias_panel.add(detalles_btn);

		JButton agregar_btn = new JButton("Agregar");
		agregar_btn.setBounds(500, 450, 135, 50);
		agregar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		agregar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlEsc.getContentPane().removeAll();
				agregar();
			}
		});
		materias_panel.add(agregar_btn);

		controlEsc.add(materias_panel);
		controlEsc.repaint();
		controlEsc.revalidate();

	}

	public void agregar() {
		JPanel detalles_panel = new JPanel() {
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

			}
		};
		detalles_panel.setLayout(null);

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
				materias();
			}
		});

		detalles_panel.add(regresar_btn);

		JLabel alumnos_tag = new JLabel("Agregar");
		alumnos_tag.setBounds(340, 50, 210, 50);
		alumnos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		detalles_panel.add(alumnos_tag);

		controlEsc.add(detalles_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void editar() {
		JPanel detalles_panel = new JPanel() {
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

			}
		};
		detalles_panel.setLayout(null);

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
				detalles();
			}
		});

		detalles_panel.add(regresar_btn);

		JLabel alumnos_tag = new JLabel("Editar");
		alumnos_tag.setBounds(340, 50, 210, 50);
		alumnos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		detalles_panel.add(alumnos_tag);

		controlEsc.add(detalles_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void detalles() {

		JPanel detalles_panel = new JPanel() {
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

			}
		};
		detalles_panel.setLayout(null);

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
				materias();
			}
		});

		detalles_panel.add(regresar_btn);

		JLabel alumnos_tag = new JLabel("Detalles");
		alumnos_tag.setBounds(340, 50, 210, 50);
		alumnos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		detalles_panel.add(alumnos_tag);

		JButton editar_btn = new JButton("Editar");
		editar_btn.setBounds(143, 450, 135, 50);
		editar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		editar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlEsc.getContentPane().removeAll();
				editar();
			}
		});
		detalles_panel.add(editar_btn);

		controlEsc.add(detalles_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}
}
