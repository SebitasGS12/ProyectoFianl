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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmEditarRelacion extends JDialog implements ActionListener {

	private static int idpeInicio ;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdEmp;
	private JTextField txtIdPro;
	private JTextField textField_2;
	private JButton btnEditarRelacion;
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
	private JComboBox cboIDProducto;
	private JComboBox cboIdEmp;
	private JLabel lblNewLabel;
	private JComboBox cboPE;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmEditarRelacion dialog = new FrmEditarRelacion(idpeInicio);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 */
	public FrmEditarRelacion(int idPE) {
		idpeInicio = idPE;
		setBounds(100, 100, 348, 482);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(175, 238, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEditarRelacionProducto = new JLabel("Editar Relacion Producto  Empleado");
			lblEditarRelacionProducto.setHorizontalAlignment(SwingConstants.CENTER);
			lblEditarRelacionProducto.setForeground(new Color(255, 165, 0));
			lblEditarRelacionProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEditarRelacionProducto.setBackground(Color.BLUE);
			lblEditarRelacionProducto.setBounds(10, 11, 309, 44);
			contentPanel.add(lblEditarRelacionProducto);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("ID Empleado");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(20, 91, 129, 22);
			contentPanel.add(lblNewLabel_1);
		}
		{
			cboIdEmp = new JComboBox();
			cboIdEmp.addActionListener(this);
			cboIdEmp.setBounds(153, 91, 166, 22);
			contentPanel.add(cboIdEmp);
		}
		{
			txtIdEmp = new JTextField();
			txtIdEmp.setEnabled(false);
			txtIdEmp.setColumns(10);
			txtIdEmp.setBounds(20, 126, 299, 20);
			contentPanel.add(txtIdEmp);
		}
		{
			cboIDProducto = new JComboBox();
			cboIDProducto.addActionListener(this);
			cboIDProducto.setBounds(153, 170, 166, 22);
			contentPanel.add(cboIDProducto);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("ID Producto");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(20, 168, 222, 22);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtIdPro = new JTextField();
			txtIdPro.setEnabled(false);
			txtIdPro.setColumns(10);
			txtIdPro.setBounds(20, 213, 299, 20);
			contentPanel.add(txtIdPro);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Stock");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_3.setBounds(20, 245, 222, 22);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtStock = new JTextField();
			txtStock.setColumns(10);
			txtStock.setBounds(20, 278, 124, 20);
			contentPanel.add(txtStock);
		}
		{
			btnEditarRelacion = new JButton("Editar Relacion");
			btnEditarRelacion.addActionListener(this);
			btnEditarRelacion.setIcon(new ImageIcon(FrmEditarRelacion.class.getResource("/img/imgEditarProducto.png")));
			btnEditarRelacion.setBounds(10, 353, 309, 79);
			contentPanel.add(btnEditarRelacion);
		}
		{
			lblNewLabel = new JLabel("ID Pro Emp");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(20, 58, 129, 22);
			contentPanel.add(lblNewLabel);
		}
		{
			cboPE = new JComboBox();
			cargarCBOPE();
			actionPerformedCboPE();
			cboPE.addActionListener(this);
			cboPE.setBounds(153, 58, 166, 22);
			contentPanel.add(cboPE);
			
			cboPE.setSelectedItem(idpeInicio);
			
			
		}
		
		
		
	}
	private void cargarCBOPE() {
		gPE = new NgcProducto_Empleado();
		listaPE = gPE.Lista();
		
		for (int i = 0; i < listaPE.size(); i++) {
			
			
			cboPE.addItem(listaPE.get(i).getId_pro_emp());
			
		}
		
		
		
		cargarCBOEmp();
		cargarCBOPro();
		
		
	}

	private void cargarCBOPro() {
		gPro = new NgcProducto();

		listaPro = gPro.Lista();

		try {
			
			for (int i = 0; i < listaPro.size(); i++) {
				
				cboIDProducto.addItem(listaPro.get(i).getIdProducto() );
			
			}
			
		} catch (Exception e) {
			System.out.println(""+ e);
		}
		
		
	}

	private void cargarCBOEmp() {
		
		gEmp = new NgcEmpleado();
		listaEmp = gEmp.Lista();
		try {
			for (int i = 0; i < listaEmp.size(); i++) {
				
				
				cboIdEmp.addItem(listaEmp.get(i).getID_Emp() );
				
			}
		} catch (Exception e) {
			System.out.println(""+ e);
		}

		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboPE) {
			actionPerformedCboPE();
		}
		if (e.getSource() == btnEditarRelacion) {
			actionPerformedBtnEditarRelacion(e);
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
		
		int idp = (int) cboIDProducto.getSelectedItem() ;
		
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
			}else {
				
				JOptionPane.showMessageDialog(contentPanel, "El rango de stock debe ser de 0 al 1000");
			}	
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e);
		}
		
		return false;
	}
	
	protected void actionPerformedBtnEditarRelacion(ActionEvent e) {
		
		if ( validarStock()) {
			System.out.println("h");
			try {
				int idp =(int) cboIDProducto.getSelectedItem();
				String idEmp = cboIdEmp.getSelectedItem().toString().trim();
				int stock =Integer.parseInt(txtStock.getText() );
				
				
				
				gPE = new NgcProducto_Empleado() ;
				ObjPE = gPE.Buscar(getIdPE() );
				try {
					
					ObjPE.setId_emp(idEmp);
					ObjPE.setId_pro(idp);	
					ObjPE.setStock(stock);
					
					try {
						
						gPE.Modificar(ObjPE);
						JOptionPane.showMessageDialog(contentPanel, "Modificado Correctamente");

						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	
		}
	}
	protected void actionPerformedCboPE() {
		try {
			int idPE = getIdPE();
			
			gPE = new NgcProducto_Empleado();
			
			ObjPE = gPE.Buscar(idPE);
			
			String idEmp = ObjPE.getId_emp();
			int idPro = ObjPE.getId_pro();
			int st = ObjPE.getStock();
			try {
				
				cboIdEmp.setSelectedItem(idEmp);
				cboIDProducto.setSelectedItem(idPro);
				txtStock.setText(""+st );
				
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(contentPanel, "erro2"+ e2);
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(contentPanel, "erro1"+ e2);
		}
		
		

		
		
		
		
	}
	int getIdPE() {
		
		return (int) cboPE.getSelectedItem();
	}
	
}
