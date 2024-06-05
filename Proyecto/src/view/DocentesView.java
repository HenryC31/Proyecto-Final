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
import java.sql.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import clases.Docente;
import controllers.MenuController;
import models.DocentesModel;

public class DocentesView {

	JFrame controlEsc = new JFrame();
	MenuController menu;
	JPanel docentes_panel = new JPanel();
	DocentesModel modelo = new DocentesModel();

	public DocentesView() {

		controlEsc.setTitle("Control Escolar - Docentes");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		controlEsc.setVisible(true);
		controlEsc.setSize(900, 600);
		controlEsc.setResizable(false);
		controlEsc.setLocationRelativeTo(null);
		controlEsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icono = new ImageIcon(getClass().getResource("/media/lapiz.png"));
		controlEsc.setIconImage(icono.getImage());
	}

	public void docentes() {

		docentes_panel = new JPanel() {
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
		docentes_panel.setLayout(null);

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

		docentes_panel.add(regresar_btn);

		JLabel docentes_tag = new JLabel("DOCENTES");
		docentes_tag.setBounds(340, 50, 210, 50);
		docentes_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		docentes_panel.add(docentes_tag);

//		JPanel tabla_panel = new JPanel();
//		tabla_panel.setBounds(143, 200, 700, 300);

		String[] titulos = { "ID", "RFC", "Nombre", "Ap. Paterno", "Ap. Materno", "Teléfono", "Grupo", "Información" };
		List<Docente> docentes = modelo.obtenerTodos();
		DefaultTableModel model = new DefaultTableModel(titulos, 0) {
			// Bloque para evitar que se editen las celdas
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table = new JTable(model);

		// Bloque para centrar los datos en la tabla
		DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(75, 120, 750, 350);
		docentes_panel.add(scrollPane);

		for (Docente docente : docentes) {
			Object[] row = { docente.getId(), docente.getRfc(), docente.getNombre(), docente.getAp_paterno(),
					docente.getAp_materno(), docente.getTelefono(), "", "" };
			model.addRow(row);
		}

		JButton detalles_btn = new JButton("Detalles");
		detalles_btn.setBounds(143, 500, 135, 35);
		detalles_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		detalles_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					Object value = table.getValueAt(table.getSelectedRow(), 0);
					Integer valor = (Integer) value;
					controlEsc.getContentPane().removeAll();
					detalles(valor);

				} else {
					JOptionPane.showMessageDialog(docentes_panel, "Selecciona una fila");
				}
			}
		});
		docentes_panel.add(detalles_btn);

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
		docentes_panel.add(agregar_btn);

		controlEsc.add(docentes_panel);
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

			}
		};
		agregar_panel.setLayout(null);

		JLabel alumnos_tag = new JLabel("Agregar Docente");
		alumnos_tag.setBounds(282, 30, 335, 50);
		alumnos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		agregar_panel.add(alumnos_tag);

		JLabel nombre_tag = new JLabel("Nombre");
		nombre_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_tag.setBounds(74, 115, 84, 19);
		agregar_panel.add(nombre_tag);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre_txt.setColumns(10);
		nombre_txt.setBounds(74, 141, 210, 32);
		agregar_panel.add(nombre_txt);

		JLabel ap_paterno_tag = new JLabel("Apellido Paterno");
		ap_paterno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_paterno_tag.setBounds(326, 111, 164, 19);
		agregar_panel.add(ap_paterno_tag);

		JTextField ap_paterno_txt = new JTextField();
		ap_paterno_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ap_paterno_txt.setColumns(10);
		ap_paterno_txt.setBounds(326, 141, 210, 32);
		agregar_panel.add(ap_paterno_txt);

		JLabel ap_materno_tag = new JLabel("Apellido Materno");
		ap_materno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_materno_tag.setBounds(586, 111, 172, 19);
		agregar_panel.add(ap_materno_tag);

		JTextField ap_materno_txt = new JTextField();
		ap_materno_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ap_materno_txt.setColumns(10);
		ap_materno_txt.setBounds(586, 141, 210, 32);
		agregar_panel.add(ap_materno_txt);

		JLabel fecha_nac_tag = new JLabel("Fecha Nacimiento (YYYY-MM-DD)");
		fecha_nac_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fecha_nac_tag.setBounds(74, 184, 300, 19);
		agregar_panel.add(fecha_nac_tag);

		JTextField fecha_nac_txt = new JTextField();
		fecha_nac_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fecha_nac_txt.setColumns(10);
		fecha_nac_txt.setBounds(74, 210, 210, 32);
		agregar_panel.add(fecha_nac_txt);

		JLabel rfc_tag = new JLabel("RFC");
		rfc_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rfc_tag.setBounds(74, 253, 172, 19);
		agregar_panel.add(rfc_tag);

		JTextField rfc_txt = new JTextField();
		rfc_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rfc_txt.setColumns(10);
		rfc_txt.setBounds(74, 279, 210, 32);
		agregar_panel.add(rfc_txt);

		JLabel correo_tag = new JLabel("Correo Electrónico");
		correo_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correo_tag.setBounds(74, 392, 172, 19);
		agregar_panel.add(correo_tag);

		JTextField correo_txt = new JTextField();
		correo_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		correo_txt.setColumns(10);
		correo_txt.setBounds(74, 418, 210, 32);
		agregar_panel.add(correo_txt);

		JLabel telefono_tag = new JLabel("Teléfono");
		telefono_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefono_tag.setBounds(74, 461, 172, 19);
		agregar_panel.add(telefono_tag);

		JTextField telefono_txt = new JTextField();
		telefono_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		telefono_txt.setColumns(10);
		telefono_txt.setBounds(74, 487, 210, 32);
		agregar_panel.add(telefono_txt);

		JButton agregar_btn = new JButton("Agregar");
		agregar_btn.setBounds(650, 500, 135, 35);
		agregar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		agregar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Docente docente = new Docente(rfc_txt.getText(), nombre_txt.getText(), ap_paterno_txt.getText(),
						ap_materno_txt.getText(), Date.valueOf(fecha_nac_txt.getText()), correo_txt.getText(),
						telefono_txt.getText());

				if (modelo.insertarDocente(docente)) {
					JOptionPane.showMessageDialog(agregar_panel, "Docente agregado");
					controlEsc.getContentPane().removeAll();
					docentes();
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
				if (JOptionPane.showConfirmDialog(agregar_panel, "¿Seguro que desea cancelar?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.out.println("si");
					controlEsc.getContentPane().removeAll();
					docentes();
				}
			}
		});
		agregar_panel.add(cancelar_btn);

		controlEsc.add(agregar_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void editar(Docente docente) {
		JPanel editar_panel = new JPanel() {
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
		editar_panel.setLayout(null);

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
				docentes();
			}
		});

		editar_panel.add(regresar_btn);

		JLabel alumnos_tag = new JLabel("Editar");
		alumnos_tag.setBounds(340, 50, 210, 50);
		alumnos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		editar_panel.add(alumnos_tag);

		JLabel nombre_tag = new JLabel("Nombre");
		nombre_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_tag.setBounds(74, 115, 84, 19);
		editar_panel.add(nombre_tag);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre_txt.setColumns(10);
		nombre_txt.setBounds(74, 141, 210, 32);
		nombre_txt.setText(docente.getNombre());
		editar_panel.add(nombre_txt);

		JLabel ap_paterno_tag = new JLabel("Apellido Paterno");
		ap_paterno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_paterno_tag.setBounds(326, 111, 164, 19);
		editar_panel.add(ap_paterno_tag);

		JTextField ap_paterno_txt = new JTextField();
		ap_paterno_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ap_paterno_txt.setColumns(10);
		ap_paterno_txt.setBounds(326, 141, 210, 32);
		ap_paterno_txt.setText(docente.getAp_paterno());
		editar_panel.add(ap_paterno_txt);

		JLabel ap_materno_tag = new JLabel("Apellido Materno");
		ap_materno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_materno_tag.setBounds(586, 111, 172, 19);
		editar_panel.add(ap_materno_tag);

		JTextField ap_materno_txt = new JTextField();
		ap_materno_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ap_materno_txt.setColumns(10);
		ap_materno_txt.setBounds(586, 141, 210, 32);
		ap_materno_txt.setText(docente.getAp_materno());
		editar_panel.add(ap_materno_txt);

		JLabel fecha_nac_tag = new JLabel("Fecha Nacimiento (YYYY-MM-DD)");
		fecha_nac_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fecha_nac_tag.setBounds(74, 184, 300, 19);
		editar_panel.add(fecha_nac_tag);

		JTextField fecha_nac_txt = new JTextField();
		fecha_nac_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fecha_nac_txt.setColumns(10);
		fecha_nac_txt.setBounds(74, 210, 210, 32);
		fecha_nac_txt.setText(docente.getFecha_n().toString());
		editar_panel.add(fecha_nac_txt);

		JLabel rfc_tag = new JLabel("RFC");
		rfc_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rfc_tag.setBounds(74, 253, 172, 19);
		editar_panel.add(rfc_tag);

		JTextField rfc_txt = new JTextField();
		rfc_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rfc_txt.setColumns(10);
		rfc_txt.setBounds(74, 279, 210, 32);
		rfc_txt.setText(docente.getRfc());
		editar_panel.add(rfc_txt);

		JLabel id_tag = new JLabel("ID");
		id_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		id_tag.setBounds(74, 323, 172, 19);
		editar_panel.add(id_tag);

		JTextField id_txt = new JTextField();
		id_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id_txt.setColumns(10);
		id_txt.setBounds(74, 349, 210, 32);
		id_txt.setText("" + docente.getId());
		editar_panel.add(id_txt);

		JLabel correo_tag = new JLabel("Correo Electrónico");
		correo_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correo_tag.setBounds(74, 392, 172, 19);
		editar_panel.add(correo_tag);

		JTextField correo_txt = new JTextField();
		correo_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		correo_txt.setColumns(10);
		correo_txt.setBounds(74, 418, 210, 32);
		correo_txt.setText(docente.getCorreo());
		editar_panel.add(correo_txt);

		JLabel telefono_tag = new JLabel("Teléfono");
		telefono_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefono_tag.setBounds(74, 461, 172, 19);
		editar_panel.add(telefono_tag);

		JTextField telefono_txt = new JTextField();
		telefono_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		telefono_txt.setColumns(10);
		telefono_txt.setBounds(74, 487, 210, 32);
		telefono_txt.setText(docente.getTelefono());
		editar_panel.add(telefono_txt);

		id_txt.setEnabled(false);

		JButton guardar_btn = new JButton("Guardar");
		guardar_btn.setBounds(650, 500, 135, 35);
		guardar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		guardar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Docente docente = new Docente(rfc_txt.getText(), nombre_txt.getText(), ap_paterno_txt.getText(),
						ap_materno_txt.getText(), Date.valueOf(fecha_nac_txt.getText()), correo_txt.getText(),
						telefono_txt.getText());
				if (modelo.editar(docente.getId(), docente)) {
					JOptionPane.showMessageDialog(editar_panel, "Datos guardados con éxito");
					controlEsc.getContentPane().removeAll();
					docentes();
				} else {
					JOptionPane.showMessageDialog(editar_panel, "Algo salió mal");
				}

			}
		});

		editar_panel.add(guardar_btn);

		JButton cancelar_btn = new JButton("Cancelar");
		cancelar_btn.setBounds(480, 500, 135, 35);
		cancelar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		cancelar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(editar_panel, "¿Seguro que quieres cancelar?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.out.println("si");
					controlEsc.getContentPane().removeAll();
					docentes();
				}
			}
		});
		editar_panel.add(cancelar_btn);

		controlEsc.add(editar_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void detalles(int id) {

		Docente docente = modelo.obtenerDocente(id);

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
				docentes();
			}
		});

		detalles_panel.add(regresar_btn);

		JLabel detalles_tag = new JLabel("Detalles");
		detalles_tag.setBounds(340, 50, 210, 50);
		detalles_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		detalles_panel.add(detalles_tag);

		JLabel nombre_tag = new JLabel("Nombre");
		nombre_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_tag.setBounds(74, 115, 84, 19);
		detalles_panel.add(nombre_tag);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre_txt.setColumns(10);
		nombre_txt.setBounds(74, 141, 210, 32);
		nombre_txt.setText(docente.getNombre());
		detalles_panel.add(nombre_txt);

		JLabel ap_paterno_tag = new JLabel("Apellido Paterno");
		ap_paterno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_paterno_tag.setBounds(326, 111, 164, 19);
		detalles_panel.add(ap_paterno_tag);

		JTextField ap_paterno_txt = new JTextField();
		ap_paterno_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ap_paterno_txt.setColumns(10);
		ap_paterno_txt.setBounds(326, 141, 210, 32);
		ap_paterno_txt.setText(docente.getAp_paterno());
		detalles_panel.add(ap_paterno_txt);

		JLabel ap_materno_tag = new JLabel("Apellido Materno");
		ap_materno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ap_materno_tag.setBounds(586, 111, 172, 19);
		detalles_panel.add(ap_materno_tag);

		JTextField ap_materno_txt = new JTextField();
		ap_materno_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ap_materno_txt.setColumns(10);
		ap_materno_txt.setBounds(586, 141, 210, 32);
		ap_materno_txt.setText(docente.getAp_materno());
		detalles_panel.add(ap_materno_txt);

		JLabel fecha_nac_tag = new JLabel("Fecha Nacimiento (YYYY-MM-DD)");
		fecha_nac_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fecha_nac_tag.setBounds(74, 184, 300, 19);
		detalles_panel.add(fecha_nac_tag);

		JTextField fecha_nac_txt = new JTextField();
		fecha_nac_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fecha_nac_txt.setColumns(10);
		fecha_nac_txt.setBounds(74, 210, 210, 32);
		fecha_nac_txt.setText(docente.getFecha_n().toString());
		detalles_panel.add(fecha_nac_txt);

		JLabel rfc_tag = new JLabel("RFC");
		rfc_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rfc_tag.setBounds(74, 253, 172, 19);
		detalles_panel.add(rfc_tag);

		JTextField rfc_txt = new JTextField();
		rfc_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rfc_txt.setColumns(10);
		rfc_txt.setBounds(74, 279, 210, 32);
		rfc_txt.setText(docente.getRfc());
		detalles_panel.add(rfc_txt);

		JLabel id_tag = new JLabel("ID");
		id_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		id_tag.setBounds(74, 323, 172, 19);
		detalles_panel.add(id_tag);

		JTextField id_txt = new JTextField();
		id_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id_txt.setColumns(10);
		id_txt.setBounds(74, 349, 210, 32);
		id_txt.setText("" + docente.getId());
		detalles_panel.add(id_txt);

		JLabel correo_tag = new JLabel("Correo Electrónico");
		correo_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correo_tag.setBounds(74, 392, 172, 19);
		detalles_panel.add(correo_tag);

		JTextField correo_txt = new JTextField();
		correo_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		correo_txt.setColumns(10);
		correo_txt.setBounds(74, 418, 210, 32);
		correo_txt.setText(docente.getCorreo());
		detalles_panel.add(correo_txt);

		JLabel telefono_tag = new JLabel("Teléfono");
		telefono_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefono_tag.setBounds(74, 461, 172, 19);
		detalles_panel.add(telefono_tag);

		JTextField telefono_txt = new JTextField();
		telefono_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		telefono_txt.setColumns(10);
		telefono_txt.setBounds(74, 487, 210, 32);
		telefono_txt.setText(docente.getTelefono());
		detalles_panel.add(telefono_txt);

		ap_paterno_txt.setEditable(false);
		ap_materno_txt.setEditable(false);
		nombre_txt.setEditable(false);
		fecha_nac_txt.setEditable(false);
		rfc_txt.setEditable(false);
		id_txt.setEditable(false);
		correo_txt.setEditable(false);
		telefono_txt.setEditable(false);

		JButton editar_btn = new JButton("Editar");
		editar_btn.setBounds(650, 500, 135, 35);
		editar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		editar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlEsc.getContentPane().removeAll();
				editar(docente);
			}
		});

		detalles_panel.add(editar_btn);

		JButton eliminar_btn = new JButton("Eliminar");
		eliminar_btn.setBounds(480, 500, 135, 35);
		eliminar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		eliminar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(detalles_panel, "¿Seguro que desea eliminarlo?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.out.println("si");
					if (modelo.eliminar(id)) {
						JOptionPane.showMessageDialog(detalles_panel, "Docente eliminado con éxito");
						controlEsc.getContentPane().removeAll();
						docentes();
					}
				}
			}
		});
		detalles_panel.add(eliminar_btn);

		controlEsc.add(detalles_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

}
