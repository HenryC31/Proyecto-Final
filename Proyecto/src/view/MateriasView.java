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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import clases.Materia;
import controllers.MenuController;
import models.MateriasModel;

public class MateriasView {

	JFrame controlEsc = new JFrame();
	MenuController menu;
	JPanel materias_panel = new JPanel();
	MateriasModel modelo = new MateriasModel();

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

		JLabel materias_tag = new JLabel("Materias");
		materias_tag.setBounds(350, 50, 240, 50);
		materias_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		materias_panel.add(materias_tag);

//		JPanel tabla_panel = new JPanel();
//		tabla_panel.setBounds(143, 200, 700, 300);

		String[] titulos = { "ID", "Nombre", "Horario", "Aula" };
		List<Materia> materias = modelo.obtenerTodos();
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
		materias_panel.add(scrollPane);

		for (Materia materia : materias) {
			Object[] row = { materia.getId(), materia.getNombre(), materia.getHorario(), materia.getAula() };
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
					JOptionPane.showMessageDialog(materias_panel, "Selecciona una fila");
				}
			}
		});
		materias_panel.add(detalles_btn);

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
		materias_panel.add(agregar_btn);

		controlEsc.add(materias_panel);
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
					BufferedImage image = ImageIO.read(getClass().getResource("/media/papeleria.png"));
					g2d.drawImage(image, 480, 160, 300, 300, null);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
		agregar_panel.setLayout(null);

		JLabel agregar_tag = new JLabel("Agregar Materia");
		agregar_tag.setBounds(282, 30, 335, 50);
		agregar_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		agregar_panel.add(agregar_tag);

		JLabel nombre_tag = new JLabel("Nombre");
		nombre_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_tag.setBounds(74, 115, 84, 19);
		agregar_panel.add(nombre_tag);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre_txt.setColumns(10);
		nombre_txt.setBounds(74, 141, 210, 32);
		agregar_panel.add(nombre_txt);

		JLabel horario_tag = new JLabel("Horario");
		horario_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horario_tag.setBounds(74, 230, 164, 19);
		agregar_panel.add(horario_tag);

		JComboBox<String> horario_cmbox = new JComboBox<>();
		horario_cmbox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		horario_cmbox.addItem("Selecciona el horario");
		horario_cmbox.addItem("8:00 AM - 10:00 AM");
		horario_cmbox.addItem("10:30 AM - 12:30 PM");
		horario_cmbox.addItem("1:00 PM - 3:00 PM");
		horario_cmbox.addItem("3:30 PM - 5:30 PM");
		horario_cmbox.addItem("6:00 PM - 8:00 PM");
		horario_cmbox.setBounds(74, 270, 210, 32);
		agregar_panel.add(horario_cmbox);

		JLabel aula_tag = new JLabel("Aula");
		aula_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		aula_tag.setBounds(74, 392, 172, 19);
		agregar_panel.add(aula_tag);

		JComboBox<String> aula_cmbox = new JComboBox<>();
		aula_cmbox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		aula_cmbox.addItem("Selecciona el aula");
		for (int i = 100; i <= 110; i++) {
			aula_cmbox.addItem("Aula " + i);
		}
		aula_cmbox.setBounds(74, 418, 210, 32);
		agregar_panel.add(aula_cmbox);

		JButton agregar_btn = new JButton("Agregar");
		agregar_btn.setBounds(650, 500, 135, 35);
		agregar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		agregar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Materia materia = new Materia(nombre_txt.getText(), horario_cmbox.getSelectedItem().toString(),
						aula_cmbox.getSelectedItem().toString());

				if (materia.getHorario().equals("Selecciona el horario")
						|| materia.getAula().equals("Selecciona el aula")) {
					JOptionPane.showMessageDialog(agregar_panel, "Debes llenar bien los campos");
				} else {
					if (modelo.insertarMateria(materia)) {
						JOptionPane.showMessageDialog(agregar_panel, "Docente agregado");
						controlEsc.getContentPane().removeAll();
						materias();
					} else {
						JOptionPane.showMessageDialog(agregar_panel, "Ocurrió un problema, revisa los datos");
					}
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
					materias();
				}
			}
		});
		agregar_panel.add(cancelar_btn);

		controlEsc.add(agregar_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void editar(Materia materia) {
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
					BufferedImage image = ImageIO.read(getClass().getResource("/media/papeleria.png"));
					g2d.drawImage(image, 480, 160, 300, 300, null);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
		editar_panel.setLayout(null);

		JLabel agregar_tag = new JLabel("Editar Materia");
		agregar_tag.setBounds(282, 30, 335, 50);
		agregar_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		editar_panel.add(agregar_tag);

		JLabel nombre_tag = new JLabel("Nombre");
		nombre_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_tag.setBounds(74, 115, 84, 19);
		editar_panel.add(nombre_tag);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre_txt.setText(materia.getNombre());
		nombre_txt.setBounds(74, 141, 210, 32);
		editar_panel.add(nombre_txt);

		JLabel id_tag = new JLabel("ID");
		id_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		id_tag.setBounds(326, 111, 164, 19);
		editar_panel.add(id_tag);

		JTextField id_txt = new JTextField();
		id_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id_txt.setColumns(10);
		id_txt.setBounds(326, 141, 210, 32);
		id_txt.setText("" + materia.getId());
		id_txt.setEnabled(false);
		editar_panel.add(id_txt);

		JLabel horario_tag = new JLabel("Horario");
		horario_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horario_tag.setBounds(74, 230, 164, 19);
		editar_panel.add(horario_tag);

		JComboBox<String> horario_cmbox = new JComboBox<>();
		horario_cmbox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		horario_cmbox.addItem(materia.getHorario());
		horario_cmbox.addItem("Selecciona el horario");
		horario_cmbox.addItem("8:00 AM - 10:00 AM");
		horario_cmbox.addItem("10:30 AM - 12:30 PM");
		horario_cmbox.addItem("1:00 PM - 3:00 PM");
		horario_cmbox.addItem("3:30 PM - 5:30 PM");
		horario_cmbox.addItem("6:00 PM - 8:00 PM");
		horario_cmbox.setBounds(74, 270, 210, 32);
		editar_panel.add(horario_cmbox);

		JLabel aula_tag = new JLabel("Aula");
		aula_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		aula_tag.setBounds(74, 392, 172, 19);
		editar_panel.add(aula_tag);

		JComboBox<String> aula_cmbox = new JComboBox<>();
		aula_cmbox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		aula_cmbox.addItem(materia.getAula());
		aula_cmbox.addItem("Selecciona el aula");
		for (int i = 100; i <= 110; i++) {
			aula_cmbox.addItem("Aula " + i);
		}
		aula_cmbox.setBounds(74, 418, 210, 32);
		editar_panel.add(aula_cmbox);

		JButton guardar_btn = new JButton("Guardar");
		guardar_btn.setBounds(650, 500, 135, 35);
		guardar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		guardar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Materia materia = new Materia(nombre_txt.getText(), horario_cmbox.getSelectedItem().toString(),
						aula_cmbox.getSelectedItem().toString());
				if (modelo.editar(materia.getId(), materia)) {
					JOptionPane.showMessageDialog(editar_panel, "Datos guardados con éxito");
					controlEsc.getContentPane().removeAll();
					materias();
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
				if (JOptionPane.showConfirmDialog(editar_panel, "¿Seguro que desea cancelar?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.out.println("si");
					controlEsc.getContentPane().removeAll();
					materias();
				}
			}
		});
		editar_panel.add(cancelar_btn);

		controlEsc.add(editar_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void detalles(int valor) {

		Materia materia = modelo.obtenerMateria(valor);

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
					BufferedImage image = ImageIO.read(getClass().getResource("/media/papeleria.png"));
					g2d.drawImage(image, 480, 160, 300, 300, null);
					image = ImageIO.read(getClass().getResource("/media/boton-de-retroceso.png"));
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

		JLabel agregar_tag = new JLabel("Agregar Materia");
		agregar_tag.setBounds(282, 30, 335, 50);
		agregar_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		detalles_panel.add(agregar_tag);

		JLabel nombre_tag = new JLabel("Nombre");
		nombre_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_tag.setBounds(74, 115, 84, 19);
		detalles_panel.add(nombre_tag);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre_txt.setText(materia.getNombre());
		nombre_txt.setBounds(74, 141, 210, 32);
		detalles_panel.add(nombre_txt);

		JLabel id_tag = new JLabel("ID");
		id_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		id_tag.setBounds(326, 111, 164, 19);
		detalles_panel.add(id_tag);

		JTextField id_txt = new JTextField();
		id_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id_txt.setColumns(10);
		id_txt.setBounds(326, 141, 210, 32);
		id_txt.setText("" + materia.getId());
		id_txt.setEnabled(false);
		detalles_panel.add(id_txt);

		JLabel horario_tag = new JLabel("Horario");
		horario_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horario_tag.setBounds(74, 230, 164, 19);
		detalles_panel.add(horario_tag);

		JComboBox<String> horario_cmbox = new JComboBox<>();
		horario_cmbox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		horario_cmbox.addItem(materia.getHorario());
		horario_cmbox.addItem("Selecciona el horario");
		horario_cmbox.addItem("8:00 AM - 10:00 AM");
		horario_cmbox.addItem("10:30 AM - 12:30 PM");
		horario_cmbox.addItem("1:00 PM - 3:00 PM");
		horario_cmbox.addItem("3:30 PM - 5:30 PM");
		horario_cmbox.addItem("6:00 PM - 8:00 PM");
		horario_cmbox.setBounds(74, 270, 210, 32);
		detalles_panel.add(horario_cmbox);

		JLabel aula_tag = new JLabel("Aula");
		aula_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		aula_tag.setBounds(74, 392, 172, 19);
		detalles_panel.add(aula_tag);

		JComboBox<String> aula_cmbox = new JComboBox<>();
		aula_cmbox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		aula_cmbox.addItem(materia.getAula());
		aula_cmbox.addItem("Selecciona el aula");
		for (int i = 100; i <= 110; i++) {
			aula_cmbox.addItem("Aula " + i);
		}
		aula_cmbox.setBounds(74, 418, 210, 32);
		detalles_panel.add(aula_cmbox);

		JButton agregar_btn = new JButton("Editar");
		agregar_btn.setBounds(650, 500, 135, 35);
		agregar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		agregar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlEsc.getContentPane().removeAll();
				editar(materia);
			}
		});
		detalles_panel.add(agregar_btn);

		JButton eliminar_btn = new JButton("Eliminar");
		eliminar_btn.setBounds(480, 500, 135, 35);
		eliminar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		eliminar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(detalles_panel, "¿Seguro que desea eliminarlo?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.out.println("si");
					if (modelo.eliminar(valor)) {
						JOptionPane.showMessageDialog(detalles_panel, "Materia eliminada con éxito");
						controlEsc.getContentPane().removeAll();
						materias();
					}
				}
			}
		});
		detalles_panel.add(eliminar_btn);

		horario_cmbox.setEnabled(false);
		aula_cmbox.setEnabled(false);
		nombre_txt.setEnabled(false);

		controlEsc.add(detalles_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}
}
