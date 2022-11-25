package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CapaNegocio.NgcAdmin;
import CapaNegocio.NgcEmpleado;
import CapaNegocio.NgcPersona;
import Clases.Admin;
import Clases.Persona;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSalir;
	private JLabel lblFondo;
	private JButton btnVendedores;
	private JButton btnInventario;
	private JButton btnVentas;
	private JLabel lblNewLabel;
	private JLabel lblgestorDeInventario;
	private JLabel lblgestorDeVentas;
	private static int Dni; 
	private JLabel lblBienvenida;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal(Dni);
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
	NgcPersona gPer = new NgcPersona();
	NgcAdmin gAdm = new NgcAdmin();
	
	
	
	public MenuPrincipal(int Code) {
		this.Dni = Code;
		setTitle("Menu Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/img/ico.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(180,217,231));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVentas = new JButton("");
		btnVentas.addActionListener(this);
		
		lblgestorDeInventario = new JLabel("<html>Gestor De <br> Inventario</html>");
		lblgestorDeInventario.setForeground(new Color(0, 191, 255));
		lblgestorDeInventario.setFont(new Font("Verdana", Font.BOLD, 25));
		lblgestorDeInventario.setHorizontalAlignment(SwingConstants.CENTER);
		lblgestorDeInventario.setBounds(464, 384, 166, 61);
		contentPane.add(lblgestorDeInventario);
		
		lblgestorDeVentas = new JLabel("<html>Gestor De <br> Ventas</html>");
		lblgestorDeVentas.setForeground(new Color(0, 191, 255));
		lblgestorDeVentas.setFont(new Font("Verdana", Font.BOLD, 25));
		lblgestorDeVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblgestorDeVentas.setBounds(836, 384, 166, 61);
		contentPane.add(lblgestorDeVentas);
		
		lblNewLabel = new JLabel("<html>Gestor De <br> Vendedores </html>");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 277, 166, 64);
		contentPane.add(lblNewLabel);
		btnVentas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/btnVentas.png")));
		btnVentas.setDefaultCapable(false);
		btnVentas.setContentAreaFilled(false);
		btnVentas.setBorderPainted(false);
		btnVentas.setBounds(801, 133, 231, 402);
		contentPane.add(btnVentas);
		
		btnInventario = new JButton("");
		btnInventario.addActionListener(this);

		btnInventario.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/btnInventario.png")));
		btnInventario.setDefaultCapable(false);
		btnInventario.setContentAreaFilled(false);
		btnInventario.setBorderPainted(false);
		btnInventario.setBounds(435, 133, 231, 402);
		contentPane.add(btnInventario);
		
		btnVendedores = new JButton("");
		btnVendedores.addActionListener(this);
		btnVendedores.setBorderPainted(false);
		btnVendedores.setDefaultCapable(false);
		btnVendedores.setContentAreaFilled(false);
		btnVendedores.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/btnVendedores.png")));
		btnVendedores.setBounds(87, 34, 231, 402);
		contentPane.add(btnVendedores);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/btnSalir (1).png")));
		btnSalir.setBounds(26, 450, 144, 150);
		contentPane.add(btnSalir);
		
		lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/fondoMP.png")));
		lblFondo.setBounds(0, 172, 1280, 439);
		contentPane.add(lblFondo);
		
		lblBienvenida = new JLabel("");
		lblBienvenida.setForeground(new Color(46, 139, 87));
		lblBienvenida.setFont(new Font("HP Simplified", Font.ITALIC, 30));
		lblBienvenida.setBackground(new Color(240, 240, 240));
		lblBienvenida.setBounds(350, 29, 706, 56);
		
		
		cargarTitulo(Code);
		
		
	}

	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnInventario) {
			actionPerformedBtnInventario(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnVendedores) {
			actionPerformedBtnVendedores(e);
		}
		if (e.getSource() == btnVentas) {
			actionPerformedBtnVentas(e);
		}
	}
	protected void actionPerformedBtnVentas(ActionEvent e) {
		
		dispose();
		GestorVentas gv = new GestorVentas(this.Dni);
		gv.setLocationRelativeTo(contentPane);
		gv.setVisible(true);
		
	}
	protected void actionPerformedBtnVendedores(ActionEvent e) {
		
		Admin a = gAdm.BuscarDNI(Dni);
		if(a != null) {
			dispose();
			GestorVendedores gv = new GestorVendedores(this.Dni);
			gv.setLocationRelativeTo(contentPane);
			gv.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Usted no Posee los Permisos para Entrar");
		}
		
		
		
		
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		int flag = JOptionPane.showConfirmDialog( null, "¿Desea Cerrar Sesion?", "Alerta", 0);
		
		if(flag == 0) {
			dispose();
			IniciarSesion is = new IniciarSesion();
			is.setLocationRelativeTo(contentPane);
			is.setVisible(true);
		};
		
	}
	protected void actionPerformedBtnInventario(ActionEvent e) {
		
		

		dispose();
		GestorProducto gi = new GestorProducto(this.Dni);
		gi.setLocationRelativeTo(contentPane);
		gi.setVisible(true);

		
		
	}
	
	
	private String tipo(Persona x) {
		String val = "" ; 
		NgcAdmin nAdmin = new NgcAdmin();
		Admin a = nAdmin.BuscarDNI(x.getDni_Persona());
		
		if ( a != null) {
			val = " Administrador ";
		}else if(a == null) {
			val = " Empleado ";
		}
		
		return val;
		
	}
	
	private void cargarTitulo(int code) {
		
		Persona objP = gPer.BuscarDNI(code);

		lblBienvenida.setText("Hola  "+ tipo(objP) + objP.getNombrePersona() + " " + objP.getApellidosPersona() );
		contentPane.add(lblBienvenida);
		
	}
	
}
