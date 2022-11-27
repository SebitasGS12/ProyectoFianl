package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JLabel lbltxt;
	private JLabel lblFondo;
	private JLabel lblAyuda;
	private JLabel lblAyudaTxt;
	private JPanel panel;
	private JLabel lblIniciarSesion;
	private JPanel panel2;
	private JLabel lblIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/img/ico.png")));
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbltxt = new JLabel("Menu Principal");
		lbltxt.setForeground(Color.WHITE);
		lbltxt.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxt.setToolTipText("");
		lbltxt.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lbltxt.setBounds(10, 11, 185, 47);
		contentPane.add(lbltxt);
		
		
		
		lblAyuda = new JLabel("");
		lblAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAyuda.setIcon(new ImageIcon(Inicio.class.getResource("/img/FotoAyuda.png")));
		lblAyuda.setBounds(84, 301, 150, 155);
		lblAyuda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				Ayuda ay = new Ayuda();
				ay.setLocationRelativeTo(contentPane);
				ay.setVisible(true);
			}
		
		});
		
		contentPane.add(lblAyuda);
		
		
		panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(99, 273, 119, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblAyudaTxt = new JLabel("AYUDA");
		lblAyudaTxt.setBounds(25, 11, 71, 22);
		panel.add(lblAyudaTxt);
		lblAyudaTxt.setForeground(new Color(255, 69, 0));
		lblAyudaTxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblAyudaTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblIniciarSesion = new JLabel("");
		lblIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIniciarSesion.setIcon(new ImageIcon(Inicio.class.getResource("/img/FotoInciarSesion.png")));
		lblIniciarSesion.setBounds(459, 48, 260, 323);
		lblIniciarSesion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				IniciarSesion is = new IniciarSesion();
				is.setLocationRelativeTo(contentPane);
				is.setVisible(true);
			}
		});
		contentPane.add(lblIniciarSesion);
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(152, 251, 152));
		panel2.setBounds(496, 345, 176, 47);
		contentPane.add(panel2);
		
		lblIniciar = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciar.setForeground(new Color(255, 69, 0));
		lblIniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIniciar.setBounds(25, 11, 126, 22);
		panel2.add(lblIniciar);
		
		lblFondo = new JLabel("");
		lblFondo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblFondo.setIcon(new ImageIcon(Inicio.class.getResource("/img/Fondo.jpg")));
		lblFondo.setBounds(0, 0, 884, 501);
		
		contentPane.add(lblFondo);
		
	}
}
