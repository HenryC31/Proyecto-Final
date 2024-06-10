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
import java.util.ArrayList;
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

import clases.Docente;
import clases.Grupo;
import clases.Materia;
import controllers.MenuController;
import models.DocentesModel;
import models.GruposModel;
import models.MateriasModel;

public class GruposView {
	MenuController menu;
	JFrame controlEsc = new JFrame();
	JPanel grupos_panel = new JPanel();
	GruposModel modelo = new GruposModel();
	MateriasModel materiasModel = new MateriasModel();
	DocentesModel docentesModel = new DocentesModel();

	public GruposView() {
		controlEsc.setTitle("Control Escolar - Grupos");
		controlEsc.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		controlEsc.setVisible(true);
		controlEsc.setSize(900, 600);
		controlEsc.setResizable(false);
		controlEsc.setLocationRelativeTo(null);
		controlEsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icono = new ImageIcon(getClass().getResource("/media/lapiz.png"));
		controlEsc.setIconImage(icono.getImage());
	}

	public void grupos() {
		grupos_panel = new JPanel() {
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
		grupos_panel.setLayout(null);

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

		grupos_panel.add(regresar_btn);

		JLabel materias_tag = new JLabel("Materias");
		materias_tag.setBounds(350, 50, 240, 50);
		materias_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		grupos_panel.add(materias_tag);

//		JPanel tabla_panel = new JPanel();
//		tabla_panel.setBounds(143, 200, 700, 300);

		String[] titulos = { "ID", "Nombre", "Profesor", "Materia 1", "Materia 2", "Materia 3" };
		List<Grupo> grupos = modelo.obtenerTodos();
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
		grupos_panel.add(scrollPane);

		for (Grupo grupo : grupos) {
//			System.out.println(grupo.getId() + "  " + grupo.getNombre() + "  "
//					+ modelo.obtenerNombreMateria(grupo.getMateria_uno()));
			Object[] row = { grupo.getId(), grupo.getNombre(), grupo.getProfesor(), grupo.getMateria_uno(),
					grupo.getMateria_dos(), grupo.getMateria_tres() };
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
					JOptionPane.showMessageDialog(grupos_panel, "Selecciona una fila");
				}
			}
		});
		grupos_panel.add(detalles_btn);

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
		grupos_panel.add(agregar_btn);

		controlEsc.add(grupos_panel);
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void agregar() {
		List<String> prof = new ArrayList<>();
		List<Docente> docentes = docentesModel.obtenerTodos();
		for (Docente docente : docentes) {
			prof.add(docente.getNombre() + " " + docente.getAp_paterno() + " " + docente.getAp_materno());
		}

		List<String> mat = new ArrayList<>();
		List<Materia> materias = materiasModel.obtenerTodos();
		for (Materia materia : materias) {
			mat.add(materia.getNombre());
		}

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

		JLabel grupos_tag = new JLabel("Agregar Grupo");
		grupos_tag.setBounds(282, 30, 335, 50);
		grupos_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		agregar_panel.add(grupos_tag);

		JLabel id_tag = new JLabel("Id");
		id_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		id_tag.setBounds(74, 115, 84, 19);
		agregar_panel.add(id_tag);

		JTextField id_txt = new JTextField();
		id_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id_txt.setColumns(10);
		id_txt.setBounds(74, 141, 210, 32);
		agregar_panel.add(id_txt);

		JLabel nombre_tag = new JLabel("Grupo");
		nombre_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre_tag.setBounds(326, 111, 164, 19);
		agregar_panel.add(nombre_tag);

		JTextField nombre_txt = new JTextField();
		nombre_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre_txt.setColumns(10);
		nombre_txt.setBounds(326, 141, 210, 32);
		agregar_panel.add(nombre_txt);

		JLabel profesor_tag = new JLabel("Profesor");
		profesor_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profesor_tag.setBounds(586, 111, 172, 19);
		agregar_panel.add(profesor_tag);

		JComboBox<String> profesor_txt = new JComboBox<String>();
		profesor_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		for (int i = 0; i < prof.size(); i++) {
			profesor_txt.addItem(prof.get(i));
		}
		profesor_txt.setBounds(586, 141, 210, 32);
		agregar_panel.add(profesor_txt);

		JLabel materia_uno_tag = new JLabel("Materia 1");
		materia_uno_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		materia_uno_tag.setBounds(74, 184, 300, 19);
		agregar_panel.add(materia_uno_tag);

		JComboBox<String> materia_uno_txt = new JComboBox<String>();
		materia_uno_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		for (int i = 0; i < mat.size(); i++) {
			materia_uno_txt.addItem(mat.get(i));
		}
		materia_uno_txt.setBounds(74, 210, 210, 32);
		agregar_panel.add(materia_uno_txt);

		JLabel materia_dos_tag = new JLabel("Materia 2");
		materia_dos_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		materia_dos_tag.setBounds(74, 280, 172, 19);
		agregar_panel.add(materia_dos_tag);

		JComboBox<String> materia_dos_txt = new JComboBox<String>();
		materia_dos_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		for (int i = 0; i < mat.size(); i++) {
			materia_dos_txt.addItem(mat.get(i));
		}
		materia_dos_txt.setBounds(74, 305, 210, 32);
		agregar_panel.add(materia_dos_txt);

		JLabel materia_tres_tag = new JLabel("Materia 3");
		materia_tres_tag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		materia_tres_tag.setBounds(74, 392, 172, 19);
		agregar_panel.add(materia_tres_tag);

		JComboBox<String> materia_tres_txt = new JComboBox<String>();
		materia_tres_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		for (int i = 0; i < mat.size(); i++) {
			materia_tres_txt.addItem(mat.get(i));
		}
		materia_tres_txt.setBounds(74, 418, 210, 32);
		agregar_panel.add(materia_tres_txt);

		id_txt.setEnabled(false);

		JButton agregar_btn = new JButton("Agregar");
		agregar_btn.setBounds(650, 500, 135, 35);
		agregar_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		agregar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (materia_uno_txt.getSelectedItem().toString().equals(materia_dos_txt.getSelectedItem().toString())
						|| materia_uno_txt.getSelectedItem().toString()
								.equals(materia_tres_txt.getSelectedItem().toString())
						|| materia_dos_txt.getSelectedItem().toString().equals(
								materia_tres_txt.getSelectedItem().toString())
						|| nombre_txt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(controlEsc, "Llena los campos correctamente");
				} else {
					Grupo grupo = new Grupo(nombre_txt.getText(), profesor_txt.getSelectedItem().toString(),
							materia_uno_txt.getSelectedItem().toString(), materia_dos_txt.getSelectedItem().toString(),
							materia_tres_txt.getSelectedItem().toString());

					if (modelo.insertarGrupo(grupo)) {
						JOptionPane.showMessageDialog(agregar_panel, "Grupo agregado");
						controlEsc.getContentPane().removeAll();
						grupos();
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
					grupos();
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
				detalles(2);
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

	public void detalles(int valor) {

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
				grupos();
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
