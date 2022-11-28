package Formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CapaNegocio.NgcEmpleado;
import CapaNegocio.NgcPersona;
import CapaNegocio.NgcProducto;
import CapaNegocio.NgcProducto_Empleado;
import Clases.Empleado;
import Clases.Persona;
import Clases.Producto;
import Clases.Producto_Empleado;

import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmAgregarProducto extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private static String id;
	private JLabel lblNewLabel;
	private JComboBox cboIdEmp;
	private JLabel lblNewLabel_1;
	private JButton btnAgregar;
	private JLabel lblNewLabel_2;
	private JComboBox cboIDProducto;
	private JTextField txtIdEmp;
	private JTextField txtIdPro;
	private JLabel lblNewLabel_3;
	
	private Producto_Empleado ObjPE;
	private Empleado ObjEmp;
	private Persona ObjPer;
	private Producto ObjPro;

	private NgcProducto_Empleado gPE;
	private NgcEmpleado gEmp;
	private NgcPersona gPer;
	private NgcProducto gPro;
	private JTextField txtStock;
	
	private ArrayList<Producto_Empleado> listaPE;
	private ArrayList<Empleado> listaEmp;
	private ArrayList<Persona> listaPer;
	private ArrayList<Producto> listaPro;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmAgregarProducto dialog = new frmAgregarProducto(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmAgregarProducto(String Id_Emp) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmAgregarProducto.class.getResource("/img/ico.png")));
		id = Id_Emp;
		setTitle("Agregar Producto");
		setType(Type.UTILITY);
		setBounds(100, 100, 341, 462);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 230, 140));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Agregar Nuevo Producto a Empleado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(10, 11, 309, 44);
		contentPanel.add(lblNewLabel);
		
		cboIdEmp = new JComboBox();
		cboIdEmp.addActionListener(this);
		cboIdEmp.setBounds(153, 66, 166, 22);
		contentPanel.add(cboIdEmp);
		
		lblNewLabel_1 = new JLabel("ID Empleado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 66, 222, 22);
		contentPanel.add(lblNewLabel_1);
		
		btnAgregar = new JButton("Agregar Relacion");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(frmAgregarProducto.class.getResource("/img/imgNuevoProducto.png")));
		btnAgregar.setBounds(20, 309, 261, 79);
		contentPanel.add(btnAgregar);
		
		lblNewLabel_2 = new JLabel("ID Producto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 143, 222, 22);
		contentPanel.add(lblNewLabel_2);
		
		cboIDProducto = new JComboBox();
		cboIDProducto.addActionListener(this);
		cboIDProducto.setBounds(153, 145, 166, 22);
		contentPanel.add(cboIDProducto);
		
		txtIdEmp = new JTextField();
		txtIdEmp.setEnabled(false);
		txtIdEmp.setBounds(20, 101, 299, 20);
		contentPanel.add(txtIdEmp);
		txtIdEmp.setColumns(10);
		
		txtIdPro = new JTextField();
		txtIdPro.setEnabled(false);
		txtIdPro.setColumns(10);
		txtIdPro.setBounds(20, 188, 299, 20);
		contentPanel.add(txtIdPro);
		
		lblNewLabel_3 = new JLabel("Stock");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 220, 222, 22);
		contentPanel.add(lblNewLabel_3);
		
		txtStock = new JTextField();
		txtStock.setBounds(20, 253, 124, 20);
		contentPanel.add(txtStock);
		txtStock.setColumns(10);
		
		cargarCBOEmp();
		cargarCBOPro();
		
	}
	private void cargarCBOPro() {
		

		gPro = new NgcProducto();
		listaPro = gPro.Lista();
		
		for (int i = 0; i < listaPro.size(); i++) {
			
			
			cboIDProducto.addItem(listaPro.get(i).getIdProducto() );
			
		}
		
		
		
	}

	private void cargarCBOEmp() {
		
		gEmp = new NgcEmpleado();
		listaEmp = gEmp.Lista();
		
		for (int i = 0; i < listaEmp.size(); i++) {
			
			
			cboIdEmp.addItem(listaEmp.get(i).getID_Emp() );
			
		}
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == cboIDProducto) {
			actionPerformedcboIDProducto(e);
		}
		if (e.getSource() == cboIdEmp) {
			actionPerformedCboIdEmp(e);
		}
	}
	protected void actionPerformedCboIdEmp(ActionEvent e) {
		
		String idEmp = cboIdEmp.getSelectedItem().toString().trim();
		
		try {
			gPer = new NgcPersona();
			gEmp = new NgcEmpleado();
			
			ObjEmp = gEmp.BuscarID(idEmp);
			ObjPer = gPer.BuscarDNI(ObjEmp.getDni_Persona());
			txtIdEmp.setText(ObjPer.getNombrePersona() +" "+ ObjPer.getApellidosPersona() );
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		
		
		
		
	}
	protected void actionPerformedcboIDProducto(ActionEvent e) {
		
		int idp =(int) cboIDProducto.getSelectedItem();
		
		try {
			gPro = new NgcProducto();
			
			
			ObjPro = gPro.Buscar(idp);
			
			txtIdPro.setText(  ObjPro.getNom_pro() );
		} catch (Exception e2) {
			System.out.println(e2);
		}	
		
		
		
	}
	
	boolean validarStock() {
		try {
			int stock = Integer.parseInt(txtStock.getText() );
			
			if ( stock < 1000 && stock > 0 ) {
				return true;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "Inserte un Stock");
		}
		
		
		return false;
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		if ( validarStock()) {
			try {
				int idp =(int) cboIDProducto.getSelectedItem();
				String idEmp = cboIdEmp.getSelectedItem().toString().trim();
				int stock =Integer.parseInt(txtStock.getText() );
				
				
				
				gPE = new NgcProducto_Empleado() ;
				ObjPE = new Producto_Empleado();
				try {
					ObjPE.setId_pro_emp(gPE.CodigoAutogenerado());
					ObjPE.setId_emp(idEmp);
					ObjPE.setId_pro(idp);	
					ObjPE.setStock(stock);
					
					try {
						
						gPE.Insertar(ObjPE);
						JOptionPane.showMessageDialog(contentPanel, "Agregado Correctamente");

						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	
		}else {
			
			JOptionPane.showMessageDialog(contentPanel, "El rango de stock debe ser entre 0 y 1000");
			
		}	
	}
}
