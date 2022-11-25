package Formulario;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSplitPane;

import CapaNegocio.NgcEmpleado;
import CapaNegocio.NgcPersona;
import Clases.Empleado;
import Clases.Persona;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEditarVendedor extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JComboBox cboDatos;
	private JLabel lblNewLabel_1;
	private JPanel panelPersona;
	private JPanel panelVendedor;
	private NgcPersona gPer;
	private NgcEmpleado gEmp;
	private Empleado objEmp;
	private Persona objPersona;
	private ArrayList<Persona> listaPersona ;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtNombre;
	private JLabel lblNewLabel_6;
	private JTextField txtApellidos;
	private JLabel lblNewLabel_7;
	private JTextField txtCorreo;
	private JLabel lblNewLabel_8;
	private JSpinner spEdad;
	private JButton btnValidarEmpleado;
	private JButton btnValidarPersona;
	private JButton btnGuardarDatos;
	private JTextField txtPuesto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditarVendedor dialog = new FrmEditarVendedor();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FrmEditarVendedor() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmEditarVendedor.class.getResource("/img/ico.png")));
		setTitle("Editar Vendedor");
		setBounds(100, 100, 328, 595);
		getContentPane().setBackground(new Color(176, 224, 230));
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(10, 66, 74, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel);
		
		cboDatos = new JComboBox();
		cboDatos.addActionListener(this);
		cboDatos.setBounds(90, 68, 134, 22);
		getContentPane().add(cboDatos);
		
		lblNewLabel_1 = new JLabel("<html><p>Seleccion una Persona <br>y edite sus datos</p></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 288, 44);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_1);
		
		panelPersona = new JPanel();
		panelPersona.setBounds(20, 99, 288, 235);
		getContentPane().add(panelPersona);
		panelPersona.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Datos de la persona");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 253, 14);
		panelPersona.add(lblNewLabel_2);
		
		lblNewLabel_5 = new JLabel("Nombre");
		lblNewLabel_5.setBounds(10, 36, 63, 14);
		panelPersona.add(lblNewLabel_5);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setBounds(83, 33, 180, 20);
		panelPersona.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Apellidos");
		lblNewLabel_6.setBounds(10, 66, 63, 14);
		panelPersona.add(lblNewLabel_6);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(83, 66, 180, 20);
		panelPersona.add(txtApellidos);
		
		lblNewLabel_7 = new JLabel("Correo");
		lblNewLabel_7.setBounds(10, 109, 63, 14);
		panelPersona.add(lblNewLabel_7);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(83, 106, 180, 20);
		panelPersona.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Edad");
		lblNewLabel_8.setBounds(10, 148, 63, 14);
		panelPersona.add(lblNewLabel_8);
		
		spEdad = new JSpinner();
		spEdad.setForeground(Color.YELLOW);
		spEdad.setModel(new SpinnerNumberModel(20, 20, 79, 1));
		spEdad.setBounds(83, 145, 180, 20);
		panelPersona.add(spEdad);
		
		btnValidarPersona = new JButton("Validar");
		btnValidarPersona.addActionListener(this);
		btnValidarPersona.setBounds(83, 201, 89, 23);
		panelPersona.add(btnValidarPersona);
		
		panelVendedor = new JPanel();
		panelVendedor.setBounds(10, 347, 288, 109);
		
		panelVendedor.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Datos del Empleado");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 253, 14);
		panelVendedor.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Puesto");
		lblNewLabel_4.setBounds(10, 36, 64, 14);
		panelVendedor.add(lblNewLabel_4);
		
		btnValidarEmpleado = new JButton("Validar");
		btnValidarEmpleado.addActionListener(this);
		btnValidarEmpleado.setBounds(84, 75, 89, 23);
		panelVendedor.add(btnValidarEmpleado);
		
		txtPuesto = new JTextField();
		txtPuesto.setBounds(87, 33, 86, 20);
		panelVendedor.add(txtPuesto);
		txtPuesto.setColumns(10);
		
		btnGuardarDatos = new JButton("Editar Datos");
		btnGuardarDatos.addActionListener(this);
		btnGuardarDatos.setIcon(new ImageIcon(FrmEditarVendedor.class.getResource("/img/imgGuardarDatos.png")));
		btnGuardarDatos.setBounds(20, 462, 238, 85);
		getContentPane().add(btnGuardarDatos);
		
		cargarCbo();
	}
	
	
	public void cargarCbo() {
		
		gPer = new NgcPersona();
		listaPersona = gPer.Lista();
		
		for (int i = 0; i < listaPersona.size(); i++) {
			
			cboDatos.addItem(listaPersona.get(i).getDni_Persona() );
			
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardarDatos) {
			actionPerformedBtnGuardarDatos(e);
		}
		if (e.getSource() == btnValidarEmpleado) {
			ValidarEmpleado();
		}
		if (e.getSource() == btnValidarPersona) {
			ValidarPersona();
		}
		if (e.getSource() == cboDatos) {
			actionPerformedCboDatos(e);
		}
	}
	protected void actionPerformedCboDatos(ActionEvent e) {
		
		int dni = Integer.parseInt( cboDatos.getSelectedItem().toString());
		txtNombre.setForeground(Color.black);
		txtApellidos.setForeground(Color.black);
		txtCorreo.setForeground(Color.black);
		
		try {
			gPer = new NgcPersona();
			
			objPersona =  gPer.BuscarDNI(dni);	
			txtNombre.setText(objPersona.getNombrePersona());
			txtApellidos.setText(objPersona.getApellidosPersona());
			txtCorreo.setText(objPersona.getCorreo());
			spEdad.setValue(objPersona.getEdad());
			
			try {
				
				gEmp = new NgcEmpleado();
				if (gEmp.BuscarDNI(dni) != null) {
					
					getContentPane().add(panelVendedor);
					getContentPane().repaint();
					
					objEmp = gEmp.BuscarDNI(dni);
					txtPuesto.setText( objEmp.getPuesto() );
				}else {
					
					getContentPane().remove(panelVendedor);;
					getContentPane().repaint();
					
				}

				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getContentPane(),e2);
			}	
				
				
				
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(getContentPane(),e2);
		}
		
			
		
		
		
	}
	protected boolean ValidarPersona() {
		
		String errores  = " ";
		
		try {
			if (getNombre().matches("[A-Za-z]{3,20}\\s[A-Za-z]{3,20}|[A-Za-z]{3,20}")) {
				
				txtNombre.setForeground(Color.GREEN);
				
			}else {
			
				txtNombre.setForeground(Color.red);
				errores += "\n * El Nombre";
			}
			
			
			if (getApellidos().matches("[A-Za-z]{3,20}\\s[A-Za-z]{3,20}|[A-Za-z]{3,20}")) {
				txtApellidos.setForeground(Color.GREEN);
				
			}else {
			
				txtApellidos.setForeground(Color.red);
				errores += "\n * El Apellido";
			}
			
			
			if (getCorreo().matches("\\w+@[^@\\s]+.([a-z]+)")) {
				
				txtCorreo.setForeground(Color.GREEN);
				
			}else {
				
				txtCorreo.setForeground(Color.red);
				errores += "\n * El Correo";
			} 
			
			
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

		if(!errores.equals(" ")) {
			
			JOptionPane.showMessageDialog(getContentPane(),"Verifique los siguientes datos :" + errores);
		}else {
			return true;
		}
		
		return false;
		
		
	}
	
	
	protected boolean ValidarEmpleado() {
		String errores  = " ";
		try {
			 
			if (getPuesto().matches("[A-Z][0-9]{2}")) {

				txtPuesto.setForeground(Color.GREEN);
				
			}else {
				
				txtPuesto.setForeground(Color.red);
				errores += "\n * El Puesto";
			} 
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		if(!errores.equals(" ")) {
			
			JOptionPane.showMessageDialog(getContentPane(),"Verifique los siguientes datos :" + errores);
		}else {
			return true;
		}
		
		return false;
		
	}

	protected void actionPerformedBtnGuardarDatos(ActionEvent e) {
		try {
			gPer = new NgcPersona();
			gEmp = new NgcEmpleado();
			
			if ( ValidarPersona() ) {
				
				try {
					
					objPersona = gPer.BuscarDNI(getDni());
					
					objPersona.setNombrePersona(getNombre());
					objPersona.setApellidosPersona(getApellidos());
					objPersona.setCorreo(getCorreo());
					objPersona.setEdad(getEdad());

					
					
					gPer.Modificar( objPersona );
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(),e2);
				}
			}
			
			if ( ValidarEmpleado()) {
				try {
					objEmp = gEmp.BuscarDNI(getDni());
					
					objEmp.setPuesto(getPuesto()); 
					
					gEmp.Modificar(objEmp);
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(),e2);
				}
			}
			
			
			JOptionPane.showMessageDialog(getContentPane(),"Editado Correctamente");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(getContentPane(),e2);
		}
		
		
		
		
		
	}
	
	private int getDni() {
		return Integer.parseInt(""+cboDatos.getSelectedItem()) ;
	}

	private String getNombre() {
		return txtNombre.getText().toString().trim();
			
	}
	
	private String getApellidos() {
		return txtApellidos.getText().toString().trim();
			
	}
	
	private String getCorreo() {
		return txtCorreo.getText().toString().trim();
			
	}
	
	private int getEdad() {
		
		return Integer.parseInt(""+spEdad.getValue());		
	}
	
	
	private String getPuesto() {
		
		return txtPuesto.getText().toString().trim();
		
	}
}
