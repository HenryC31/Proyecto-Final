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
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Alumno;
import controllers.MenuController;
import models.AlumnosModel;

public class AlumnosView {
	MenuController menu;
	JFrame controlEsc = new JFrame();
	JPanel alumnos_panel = new JPanel();
	AlumnosModel modelo = new AlumnosModel();

	public AlumnosView() {
		controlEsc.setTitle("Control Escolar - Alumnos");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		controlEsc.setVisible(true);
		controlEsc.setSize(900, 600);
		controlEsc.setResizable(false);
		controlEsc.setLocationRelativeTo(null);
		controlEsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icono = new ImageIcon(getClass().getResource("/media/lapiz.png"));
		controlEsc.setIconImage(icono.getImage());
	}

	public void alumnos() {

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

			}
		};
		alumnos_panel.setLayout(null);

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

		alumnos_panel.add(regresar_btn);

		JLabel alumnos_tag = new JLabel("ALUMNOS");
		alumnos_tag.setBounds(340, 50, 210, 50);
		alumnos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		alumnos_panel.add(alumnos_tag);

//		JPanel tabla_panel = new JPanel();
//		tabla_panel.setBounds(143, 200, 700, 300);

		String[] titulos = { "No. Control", "Nombre", "Ap. Paterno", "Ap. Materno", "Teléfono", "Grupo",
				"Información" };
		List<Alumno> alumnos = modelo.obtener();
		DefaultTableModel model = new DefaultTableModel(titulos, 0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(75, 120, 750, 350);
		alumnos_panel.add(scrollPane);

		for (Alumno alumno : alumnos) {
			Object[] row = { alumno.getNo_control(), alumno.getNombre(), alumno.getAp_Paterno(), alumno.getAp_Materno(),
					alumno.getTelefono(), "", "" };
			model.addRow(row);
		}

		JButton detalles_btn = new JButton("Detalles");
		detalles_btn.setBounds(143, 500, 135, 35);
		detalles_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		detalles_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlEsc.getContentPane().removeAll();
				detalles();
			}
		});
		alumnos_panel.add(detalles_btn);

		JButton agregar_btn = new JButton("Agregar");
		agregar_btn.setBounds(600, 500, 135, 35);
		agregar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		agregar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlEsc.getContentPane().removeAll();
				agregar();
			}
		});
		alumnos_panel.add(agregar_btn);

		controlEsc.add(alumnos_panel);
		controlEsc.repaint();
		controlEsc.revalidate();

	}

	public void agregar() {
		JPanel agregar_panel = new JPanel() {
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
		agregar_panel.setLayout(null);

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
				alumnos();
			}
		});

		agregar_panel.add(regresar_btn);

		JLabel alumnos_tag = new JLabel("Agregar Alumno");
		alumnos_tag.setBounds(270, 50, 325, 50);
		alumnos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		agregar_panel.add(alumnos_tag);

		JLabel nombre_tag = new JLabel("Nombre");
		nombre_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_tag.setBounds(74, 115, 84, 19);
		agregar_panel.add(nombre_tag);

		JLabel ap_paterno_tag = new JLabel("Apellido Paterno");
		ap_paterno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_paterno_tag.setBounds(326, 111, 164, 19);
		agregar_panel.add(ap_paterno_tag);

		JTextField ap_paterno_txt = new JTextField();
		ap_paterno_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_paterno_txt.setColumns(10);
		ap_paterno_txt.setBounds(326, 141, 210, 32);
		agregar_panel.add(ap_paterno_txt);

		JLabel ap_materno_tag = new JLabel("Apellido Materno");
		ap_materno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_materno_tag.setBounds(586, 115, 172, 19);
		agregar_panel.add(ap_materno_tag);

		JTextField ap_materno_txt = new JTextField();
		ap_materno_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_materno_txt.setColumns(10);
		ap_materno_txt.setBounds(586, 145, 210, 32);
		agregar_panel.add(ap_materno_txt);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_txt.setColumns(10);
		nombre_txt.setBounds(74, 141, 210, 32);
		agregar_panel.add(nombre_txt);

		JLabel fecha_nac_tag = new JLabel("Fecha Nacimiento");
		fecha_nac_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fecha_nac_tag.setBounds(74, 184, 172, 19);
		agregar_panel.add(fecha_nac_tag);

		JTextField fecha_nac_txt = new JTextField();
		fecha_nac_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fecha_nac_txt.setColumns(10);
		fecha_nac_txt.setBounds(74, 210, 210, 32);
		agregar_panel.add(fecha_nac_txt);

		JLabel curp_tag = new JLabel("CURP");
		curp_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		curp_tag.setBounds(74, 253, 172, 19);
		agregar_panel.add(curp_tag);

		JTextField curp_txt = new JTextField();
		curp_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		curp_txt.setColumns(10);
		curp_txt.setBounds(74, 279, 210, 32);
		agregar_panel.add(curp_txt);

		JLabel no_control_tag = new JLabel("No. Control");
		no_control_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		no_control_tag.setBounds(74, 323, 172, 19);
		agregar_panel.add(no_control_tag);

		JTextField no_control_txt = new JTextField();
		no_control_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		no_control_txt.setColumns(10);
		no_control_txt.setBounds(74, 349, 210, 32);
		agregar_panel.add(no_control_txt);

		JLabel correo_tag = new JLabel("Correo Electrónico");
		correo_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correo_tag.setBounds(74, 392, 172, 19);
		agregar_panel.add(correo_tag);

		JTextField correo_txt = new JTextField();
		correo_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correo_txt.setColumns(10);
		correo_txt.setBounds(74, 418, 210, 32);
		agregar_panel.add(correo_txt);

		JLabel telefono_tag = new JLabel("Teléfono");
		telefono_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefono_tag.setBounds(74, 461, 172, 19);
		agregar_panel.add(telefono_tag);

		JTextField telefono_txt = new JTextField();
		telefono_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefono_txt.setColumns(10);
		telefono_txt.setBounds(74, 487, 210, 32);
		agregar_panel.add(telefono_txt);

		JLabel grupo_tag = new JLabel("Grupo");
		grupo_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grupo_tag.setBounds(326, 184, 77, 19);
		agregar_panel.add(grupo_tag);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setToolTipText("1°A\r\n1°B\r\n2°A\r\n2°B\r\n3°A\r\n3°B");
		comboBox.setBounds(326, 210, 210, 31);
		agregar_panel.add(comboBox);

		JButton agregar_btn = new JButton("Agregar");
		agregar_btn.setBounds(650, 500, 135, 35);
		agregar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		agregar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (modelo.agregar(no_control_txt.getText(), nombre_txt.getText(), ap_paterno_txt.getText(),
						ap_materno_txt.getText(), curp_txt.getText(), fecha_nac_txt.getText(), correo_txt.getText(),
						telefono_txt.getText())) {
					JOptionPane.showMessageDialog(agregar_panel, "Alumno agregado con éxito");
					controlEsc.getContentPane().removeAll();
					alumnos();
				} else {
					JOptionPane.showMessageDialog(agregar_panel, "Ocurrió un problema, revisa los datos");
				}

			}
		});
		agregar_panel.add(agregar_btn);

		JButton cancelar_btn = new JButton("Cancelar");
		cancelar_btn.setBounds(480, 500, 135, 35);
		cancelar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		cancelar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(alumnos_panel, "¿Seguro que desea cancelar?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.out.println("si");
					controlEsc.getContentPane().removeAll();
					alumnos();
				}
			}
		});
		agregar_panel.add(cancelar_btn);

		controlEsc.add(agregar_panel);
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
				alumnos();
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

	public void eliminar() {

	}

}
