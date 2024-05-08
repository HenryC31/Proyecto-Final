import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Proyecto {
	JFrame controlEsc = new JFrame("Control Escolar");

	public static void main(String[] args) {
		Proyecto proyecto = new Proyecto();
	}

	public Proyecto() {
		iniciar();
	}

	public void iniciar() {
		controlEsc.setVisible(true);
		controlEsc.setSize(900, 600);
		controlEsc.setResizable(false);
		controlEsc.setLocationRelativeTo(null);
		controlEsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icono = new ImageIcon(getClass().getResource("/media/lapiz.png"));
		controlEsc.setIconImage(icono.getImage());
		login();
		controlEsc.repaint();
		controlEsc.revalidate();
	}

	public void login() {
		controlEsc.setTitle("Control Escolar - Login");

		JPanel login_panel = new JPanel() {
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
		login_panel.setBackground(Color.decode("#E2E2E2"));
		login_panel.setLayout(null);

		JPanel login_formulario_panel = new JPanel();
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

		JLabel login_tag = new JLabel("LOGIN");
		login_tag.setBounds(143, 20, 135, 50);
		login_tag.setFont(new Font("Eras ITC Mediana", Font.BOLD, 40));
		login_formulario_panel.add(login_tag);

		JLabel usuario_tag = new JLabel("Usuario");
		usuario_tag.setBounds(50, 120, 120, 30);
		usuario_tag.setFont(new Font("Century", Font.PLAIN, 28));
		login_formulario_panel.add(usuario_tag);

		JTextField usuario_txt = new JTextField();
		usuario_txt.setBounds(50, 160, 300, 35);
		usuario_txt.setFont(new Font("Century", Font.PLAIN, 22));
		login_formulario_panel.add(usuario_txt);

		JLabel contra_tag = new JLabel("Contraseña");
		contra_tag.setBounds(50, 230, 150, 30);
		contra_tag.setFont(new Font("Century", Font.PLAIN, 28));
		login_formulario_panel.add(contra_tag);

		JPasswordField contra_psw = new JPasswordField();
		contra_psw.setBounds(50, 270, 300, 35);
		contra_psw.setFont(new Font("Century", Font.PLAIN, 22));
		login_formulario_panel.add(contra_psw);

		JButton login_btn = new JButton("Login");
		login_btn.setBounds(143, 400, 135, 50);
		login_btn.setFont(new Font("Eras ITC Mediana", Font.BOLD, 20));
		login_formulario_panel.add(login_btn);

		login_formulario_panel.addMouseListener(new MouseListener() {

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
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getX());
				System.out.println(e.getY());
			}
		});
		login_panel.add(login_formulario_panel);

		controlEsc.add(login_panel);

	}

}
