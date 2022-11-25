package Formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import Datos.EmailSender;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

import CapaNegocio.NgcPersona;
import Clases.Persona;

import javax.swing.border.BevelBorder;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmOlvidarContraseña extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel label;
	private JTextField txtCorreo;
	private JButton btnEnviar;
	private JPanel panel;
	private JButton btnSiguiente;
	private JPanel panel_1;
	private JTextField txtDNI;
	private JLabel lblPorfavorIntroduzcaSu;
	private JButton btnEnviar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmOlvidarContraseña dialog = new FrmOlvidarContraseña();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmOlvidarContraseña() {
		setModal(true);
		setTitle("Olvidar Contrase\u00F1a");
		setBounds(100, 100, 339, 397);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Recuperar Contrase\u00F1a");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 303, 22);
		contentPanel.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(10, 166, 303, 87);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(20, 43, 259, 20);
		panel.add(txtCorreo);
		txtCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		txtCorreo.setColumns(10);
		
		label = new JLabel("Porfavor Introduzca su correo electronico");
		label.setBounds(10, 11, 269, 19);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnEnviar = new JButton("New button");
		btnEnviar.setBounds(342, 40, 89, 23);
		panel.add(btnEnviar);
		
		btnSiguiente = new JButton("Recuperar");
		btnSiguiente.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		btnSiguiente.addActionListener(this);
		btnSiguiente.setBounds(95, 293, 126, 36);
		contentPanel.add(btnSiguiente);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(204, 255, 255));
		panel_1.setBounds(10, 53, 303, 87);
		contentPanel.add(panel_1);
		
		txtDNI = new JTextField();
		txtDNI.setHorizontalAlignment(SwingConstants.LEFT);
		txtDNI.setColumns(10);
		txtDNI.setBounds(20, 43, 259, 20);
		panel_1.add(txtDNI);
		
		lblPorfavorIntroduzcaSu = new JLabel("Porfavor Introduzca su DNI");
		lblPorfavorIntroduzcaSu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorfavorIntroduzcaSu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPorfavorIntroduzcaSu.setBounds(10, 11, 269, 19);
		panel_1.add(lblPorfavorIntroduzcaSu);
		
		btnEnviar_1 = new JButton("New button");
		btnEnviar_1.setBounds(342, 40, 89, 23);
		panel_1.add(btnEnviar_1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSiguiente) {
			actionPerformedBtnSiguiente(e);
		}
	}
	protected void actionPerformedBtnSiguiente(ActionEvent e) {
		
		try {
			
			Persona p = EncontrarPersona();
			try {
				
				String correo = txtCorreo.getText();
				EmailSender em = new EmailSender();
				
				if ( correo.matches("\\w+@[^@\\s]+.[^@\\s]")) {
					
					if ( correo.equals(p.getCorreo()) ) {
						em.enviarConGMail(correo, "Recuperacion de Contraseña", " ------------ "
								+ "\n Hola "+ p.getNombrePersona() + " " + p.getApellidosPersona() + "\n Te enviamos tu contraseña: "+ p.getContraseña()
								+ "\n Recuerda no compartirla con nadie");
						
						dispose();
						
					}else {
						
						JOptionPane.showMessageDialog(contentPanel," Introdusca el correo registrado con la cuenta ");
					}
					
					
					
					
					
				}else {
					JOptionPane.showMessageDialog(contentPanel," Escriba correctamente el correo ");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(contentPanel," Verifique el Correo ");
			}
			
			
		} catch (Exception e2) {

			JOptionPane.showMessageDialog(contentPanel," Verifique el DNI ");

		}
		
		
		
		
	}

	private Persona EncontrarPersona() {

		NgcPersona gPer = new NgcPersona();
		int dni =  Integer.parseInt( txtDNI.getText());
		
		
		return gPer.BuscarDNI(dni);
	
		
	}
}
