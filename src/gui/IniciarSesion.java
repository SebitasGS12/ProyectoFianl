package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CapaNegocio.NgcAdmin;
import CapaNegocio.NgcEmpleado;
import CapaNegocio.NgcPersona;
import Clases.Admin;
import Clases.Empleado;
import Clases.Persona;
import Formulario.FrmCrearNuevaCuenta;
import Formulario.FrmOlvidarContraseña;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class IniciarSesion extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblDibujo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblDerecha;
	private JLabel lblTitulo;
	private JLabel lblFondo;
	private JTextField txtDNI;
	private JTextField txtPass;
	private JButton btnIniciarSesion;
	private JButton btnOlvidarContraseña;
	private JButton btnCrearNuevaCuenta;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IniciarSesion dialog = new IniciarSesion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IniciarSesion() {
		setTitle("Iniciar Sesion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/img/ico.png")));
		setBounds(200, 100,1100, 700);
		getContentPane().setLayout(null);
				
		btnOlvidarContraseña = new JButton("¿Olvidaste tu contraseña?");
		btnOlvidarContraseña.addActionListener(this);
		btnOlvidarContraseña.setBounds(751, 584, 214, 31);
		getContentPane().add(btnOlvidarContraseña);
		
		btnCrearNuevaCuenta = new JButton("Crear cuenta nueva");
		btnCrearNuevaCuenta.addActionListener(this);
		btnCrearNuevaCuenta.setBounds(751, 232, 214, 21);
		getContentPane().add(btnCrearNuevaCuenta);

		btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setBounds(751, 190, 214, 31);
		btnIniciarSesion.setName("");
		btnIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciarSesion.setAutoscrolls(true);
		btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 12));
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setBackground(SystemColor.textHighlight);
		btnIniciarSesion.setBorderPainted(rootPaneCheckingEnabled);
		getContentPane().add(btnIniciarSesion);
		
		txtPass = new JTextField();
		txtPass.setText("quispevens2");
		txtPass.setBackground(SystemColor.inactiveCaptionBorder);
		txtPass.setBounds(729, 148, 260, 31);
		getContentPane().add(txtPass);
		
		txtDNI = new JTextField();
		txtDNI.setText("73435810");
		txtDNI.setHorizontalAlignment(SwingConstants.CENTER);
		txtDNI.setColumns(10);
		txtDNI.setBackground(SystemColor.inactiveCaptionBorder);
		txtDNI.setBounds(729, 70, 260, 31);
		getContentPane().add(txtDNI);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/img/uno.png")));
		lblNewLabel.setBounds(137, 214, 418, 383);
		getContentPane().add(lblNewLabel);
		
		lblDibujo = new JLabel("");
		lblDibujo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDibujo.setIcon(new ImageIcon(IniciarSesion.class.getResource("/img/dibujo.jpg")));
		lblDibujo.setBounds(667, 264, 396, 309);
		getContentPane().add(lblDibujo);
		
		lblNewLabel_1 = new JLabel("Documento Identificacion");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_1.setBounds(705, 44, 183, 29);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_2.setBounds(705, 112, 91, 29);
		getContentPane().add(lblNewLabel_2);
		
		lblDerecha = new JLabel("");
		lblDerecha.setIcon(new ImageIcon(IniciarSesion.class.getResource("/img/Blanco.jpg")));
		lblDerecha.setBounds(630, 11, 433, 612);
		getContentPane().add(lblDerecha);
		
		lblTitulo = new JLabel("Gestor de Datos");
		lblTitulo.setToolTipText("");
		lblTitulo.setForeground(SystemColor.textHighlight);
		lblTitulo.setFont(new Font("Modern No. 20", Font.BOLD, 62));
		lblTitulo.setBounds(137, 40, 449, 248);
		getContentPane().add(lblTitulo);
		
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(IniciarSesion.class.getResource("/img/FondoBlanco.png")));
		lblFondo.setBounds(0, 0, 1184, 661);
		getContentPane().add(lblFondo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrearNuevaCuenta) {
			actionPerformedBtnCrearNuevaCuenta(e);
		}
		if (e.getSource() == btnIniciarSesion) {
			actionPerformedBtnIniciarSesion(e);
		}
		if (e.getSource() == btnOlvidarContraseña) {
			actionPerformedBtnOlvidarContraseña(e);
		}
	}
	protected void actionPerformedBtnIniciarSesion(ActionEvent e) {
		
		
		NgcPersona gPer = new NgcPersona();
		NgcEmpleado gEmp = new NgcEmpleado();
		NgcAdmin  gAdm =new NgcAdmin();
		String codigo = txtDNI.getText(); 
		String contraseña = txtPass.getText().toString().trim();
		if (codigo.matches("\\d{8}")) {
			try {
				int code= Integer.parseInt(codigo);
				Persona p = gPer.BuscarDNI(code);
				Empleado emp = gEmp.BuscarDNI(code);
				Admin ad = gAdm.BuscarDNI(code);
				if (p.getContraseña().equals(contraseña) && (emp != null  || ad != null)) {
		
					dispose();
					
					MenuPrincipal mp = new MenuPrincipal(p.getDni_Persona());
					mp.setLocationRelativeTo(getContentPane());
					mp.setVisible(true);			
				}else {
					JOptionPane.showMessageDialog(null, "Posibles Errores \n1. Usuario no existe \n2.Verifique su DNI/Contraseña"
							+ "\n3.Administrador todavia no le otorga permisos de Empleado"+ "b");
				}	
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Posibles Errores \n1. Usuario no existe \n2.Verifique su DNI/Contraseña"
						+ "\n3.Administrador todavia no le otorga permisos de Empleado"+ "a");
			}	
		}else {
			JOptionPane.showMessageDialog(null, "Ingrese un DNI valido");
		}

		
		
	}
	protected void actionPerformedBtnCrearNuevaCuenta(ActionEvent e) {
		
		FrmCrearNuevaCuenta cnc = new FrmCrearNuevaCuenta();
		cnc.setLocationRelativeTo(getContentPane());
		cnc.setVisible(true);		
		
	}
	protected void actionPerformedBtnOlvidarContraseña(ActionEvent e) {
	
	
		FrmOlvidarContraseña oc = new FrmOlvidarContraseña();
		oc.setLocationRelativeTo(getContentPane());
		oc.setVisible(true);		
	
	
	}
}
