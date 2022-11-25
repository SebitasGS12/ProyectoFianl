package Formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CapaNegocio.NgcPersona;
import Clases.Persona;
import Datos.EmailSender;

import java.awt.Color;
import java.awt.Toolkit;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class FrmCrearNuevaCuenta extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JTextField txtCorreo;
	private JButton btnCrearCuenta;
	private JTextField txtContraseña;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNombre;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtNombre;
	private JTextField txtAp;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JLabel lblCheckNombre;
	private JLabel lblCheckAp;
	private JLabel lblCheckDNI;
	private JLabel lblCheckEdad;
	private JButton btnContinuar;
	private JButton btnVerificar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmCrearNuevaCuenta dialog = new FrmCrearNuevaCuenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmCrearNuevaCuenta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCrearNuevaCuenta.class.getResource("/img/ico.png")));
		setModal(true);
		setTitle("Crear Nueva Cuenta");
		setBounds(100, 100, 518, 414);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 482, 149);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Datos Personales");
		lblNewLabel.setForeground(new Color(255, 51, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 0, 197, 17);
		panel.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(10, 22, 111, 14);
		panel.add(lblNombre);
		
		lblNewLabel_6 = new JLabel("Apellidos");
		lblNewLabel_6.setBounds(10, 53, 111, 14);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Edad");
		lblNewLabel_7.setBounds(10, 115, 46, 14);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("DNI");
		lblNewLabel_8.setBounds(10, 84, 46, 14);
		panel.add(lblNewLabel_8);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(131, 19, 162, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtAp = new JTextField();
		txtAp.setColumns(10);
		txtAp.setBounds(131, 50, 162, 20);
		panel.add(txtAp);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(131, 81, 162, 20);
		panel.add(txtDni);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(131, 112, 162, 20);
		panel.add(txtEdad);
		
		lblCheckNombre = new JLabel("");
		lblCheckNombre.setBounds(303, 22, 156, 14);
		panel.add(lblCheckNombre);
		
		lblCheckAp = new JLabel("");
		lblCheckAp.setBounds(303, 53, 156, 14);
		panel.add(lblCheckAp);
		
		lblCheckDNI = new JLabel("");
		lblCheckDNI.setBounds(303, 84, 156, 14);
		panel.add(lblCheckDNI);
		
		lblCheckEdad = new JLabel("");
		lblCheckEdad.setBounds(303, 115, 156, 14);
		panel.add(lblCheckEdad);
		
		

		panel_1 = new JPanel();
		panel_1.setBounds(10, 205, 482, 161);
		panel_1.setLayout(null);

		
		lblNewLabel_1 = new JLabel("Correo Y Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 195, 19);
		panel_1.add(lblNewLabel_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(90, 40, 165, 20);
		panel_1.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(140, 71, 115, 20);
		panel_1.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Correo");
		lblNewLabel_2.setBounds(10, 41, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3.setBounds(10, 74, 70, 14);
		panel_1.add(lblNewLabel_3);
		
		btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setBounds(324, 40, 135, 53);

		
		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(this);
		btnVerificar.setBounds(140, 102, 118, 23);
		panel_1.add(btnVerificar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(this);
		btnContinuar.setBounds(181, 171, 124, 23);
		contentPanel.add(btnContinuar);
		btnCrearCuenta.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVerificar) {
			actionPerformedBtnVerifcar(e);
		}
		if (e.getSource() == btnContinuar) {
			actionPerformedBtnContinuar(e);
		}
		if (e.getSource() == btnCrearCuenta) {
			
			actionPerformedBtnCrearCuenta(e);
			
		}
	}
	protected void actionPerformedBtnCrearCuenta(ActionEvent e) {


		
		EmailSender em = new EmailSender();
		
		String correo = txtCorreo.getText();
		
		String titulo = "Envio de Datos";
		String con = " Hola "+ txtNombre.getText() + " " + txtAp.getText() ;
		
		String datos = "\n Tu DNI es : "+ txtDni.getText() + " y tu edad es: "+ txtEdad.getText();
		
		String infor = "\n El correo ingresado es : "+ txtCorreo.getText() +" y te enviamos tu contraseña :"+ txtContraseña.getText();
		
		String des = "\nUn administrador verificara tus datos para poder darte acceso al programa como empleado";
		try {
			NgcPersona gPer = new NgcPersona();
			Persona pe = new Persona();
			pe.setDni_Persona(Integer.parseInt(txtDni.getText()));
			pe.setNombrePersona(txtNombre.getText().trim());
			pe.setApellidosPersona(txtAp.getText().trim());
			pe.setCorreo( txtCorreo.getText());
			pe.setEdad(Integer.parseInt(txtEdad.getText()));
			pe.setContraseña( txtContraseña.getText().trim());
			em.enviarConGMail(correo, "Envio de Datos", con  + datos + infor + des);
			gPer.Insertar(pe);
			
			JOptionPane.showMessageDialog(contentPanel,"Cuenta Creada Verifica tu Correo :) ");
			dispose();
			
			
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(contentPanel,e);
		}
		
		
		
		
		//Agregar como persona
		
	}

	private boolean verificarDatosPersonales() {

		boolean flag = false;
		int cont = 4;
		
		String nombre,apellido,edad,dni;
		nombre = txtNombre.getText().trim();
		apellido = txtAp.getText().trim();
		edad = txtEdad.getText().trim();
		dni = txtDni.getText().trim();
		
		if (nombre.matches("[A-Za-z]{3,20}\\s[A-Za-z]{3,20}|[A-Za-z]{3,20}")) {

			lblCheckNombre.setText("Valido");
			lblCheckNombre.setForeground(Color.GREEN);
			
			
		}else {
			lblCheckNombre.setText("Invalido Verifique datos");
			lblCheckNombre.setForeground(Color.red);
			cont--;
		}
	
		if (apellido.matches("[A-Za-z]{3,20}\\s[A-Za-z]{3,20}|[A-Za-z]{3,20}")) {

			lblCheckAp.setText("Valido");
			lblCheckAp.setForeground(Color.GREEN);
		}else {
			lblCheckAp.setText("Invalido Verifique datos");
			lblCheckAp.setForeground(Color.red);
			cont--;
		}

		if (dni.matches("\\d{8}")) {

			lblCheckDNI.setText("Valido");
			lblCheckDNI.setForeground(Color.GREEN);
		}else {
			lblCheckDNI.setText("Invalido Verifique datos");
			lblCheckDNI.setForeground(Color.red);
			cont--;
		}
		
		if (edad.matches("[2-7][0-9]")) {

			lblCheckEdad.setText("Valido");
			lblCheckEdad.setForeground(Color.GREEN);
		}else {
			lblCheckEdad.setText("Invalido Verifique datos");
			lblCheckEdad.setForeground(Color.red);
			cont--;
		}
		
		
		
		if(cont == 4) {
			flag = true;
		}
		
		return flag;
		
	}
	protected void actionPerformedBtnContinuar(ActionEvent e) {
		
		if (verificarDatosPersonales()) {
			contentPanel.add(panel_1);
			panel_1.repaint();
		}else {
			JOptionPane.showMessageDialog(contentPanel,"Verifique Datos Personales");
			
		}
		
	}
	protected void actionPerformedBtnVerifcar(ActionEvent e) {
	
		try {
			String correo,contra,verificarcontra;
			String aux = "";
			correo = txtCorreo.getText();
			contra = txtContraseña.getText();
		
			
			if(!correo.matches("\\w+@[^@\\s]+.[^@\\s]")) {
				aux += "Verificar Correo";
			}
			
			if(!contra.matches("[A-Za-z0-9]{4,40}")) {
				aux += "\nVerificar Contraseña";
			}

			if (aux == "") {
				JOptionPane.showMessageDialog(contentPanel, "Datos Validos!");	
				
				panel_1.add(btnCrearCuenta);
				
				panel_1.repaint();
				
			}else {
				JOptionPane.showMessageDialog(contentPanel, aux);	
			}
			
		} catch (Exception
				e2) {
			JOptionPane.showMessageDialog(btnContinuar, e);
		}
		
	}
}
