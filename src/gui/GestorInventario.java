package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.table.DefaultTableModel;


import java.util.ArrayList;

import CapaNegocio.NgcEmpleado;
import CapaNegocio.NgcPersona;
import CapaNegocio.NgcProducto;
import CapaNegocio.NgcProducto_Empleado;
import Clases.Empleado;
import Clases.Producto;
import Clases.Persona;
import Clases.Producto_Empleado;
import Formulario.FrmCrearNuevaCuenta;
import Formulario.FrmEditarRelacion;
import Formulario.frmAgregarProducto;
import Jasper.Reporte;


import java.awt.Color;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseListener;

public class GestorInventario extends JDialog implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSalir;
	private static int Dni; 
	private JPanel panelPrinciapl;
	private Producto_Empleado ObjPE;
	private Empleado ObjEmp;
	private Persona ObjPer;
	private Producto ObjPro;

	private NgcProducto_Empleado gPE;
	private NgcEmpleado gEmp;
	private NgcPersona gPer;
	private NgcProducto gPro;
	
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTable tabla;
	private JLabel lblNewLabel;
	private JComboBox cboDueño;
	private ArrayList<Producto_Empleado> listaPE;
	private ArrayList<Empleado> listaEmp;
	private ArrayList<Persona> listaPer;

	private JButton btnAgregarProducto;
	private JButton btnEditarProducto;
	private JButton btnEliminarProducto;
	private JButton btnExportarDatos;
	private JTextField txtNombreEmp;
	private JCheckBox cbVer;
	
	private DefaultTableModel MiModelo;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestorInventario dialog = new GestorInventario(Dni);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestorInventario(int code) {
		Dni = code;
		setTitle("Inventario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestorInventario.class.getResource("/img/ico.png")));
		
		
		setBounds(100, 100, 1073,700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setDoubleBuffered(false);
		panel.setFocusable(false);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 1184, 117);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panelPrinciapl = new JPanel();
		panelPrinciapl.setBackground(new Color(143, 188, 143));
		panelPrinciapl.setBounds(0, 0, 247, 661);
		getContentPane().add(panelPrinciapl);
		panelPrinciapl.setLayout(null);
		
		lblSalir = new JLabel("");
		lblSalir.setBounds(10, 11, 227, 119);
		panelPrinciapl.add(lblSalir);
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setIcon(new ImageIcon(GestorInventario.class.getResource("/img/imgMenuPrincipal.png")));
		
		cboDueño = new JComboBox();
		cboDueño.addActionListener(this);
		cboDueño.setBounds(23, 241, 203, 34);
		panelPrinciapl.add(cboDueño);
		
		lblNewLabel = new JLabel("ID Empleado");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(23, 201, 167, 29);
		panelPrinciapl.add(lblNewLabel);
		
		txtNombreEmp = new JTextField();
		txtNombreEmp.setEditable(false);
		txtNombreEmp.setBounds(23, 161, 203, 29);
		panelPrinciapl.add(txtNombreEmp);
		txtNombreEmp.setColumns(10);
		
		cbVer = new JCheckBox("Ver ID / Ver Nombre");
		cbVer.addMouseListener(this);
		cbVer.setBounds(23, 300, 144, 23);
		panelPrinciapl.add(cbVer);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(23, 358, 203, 34);
		panelPrinciapl.add(btnCancelar);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(257, 0, 790, 110);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnAgregarProducto = new JButton("<html>Agregar<br>Producto</html>");
		btnAgregarProducto.addActionListener(this);
		btnAgregarProducto.setIcon(new ImageIcon(GestorInventario.class.getResource("/img/imgNuevoProducto.png")));
		btnAgregarProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarProducto.setFocusable(false);
		btnAgregarProducto.setEnabled(true);
		btnAgregarProducto.setBounds(10, 11, 169, 83);
		panel_2.add(btnAgregarProducto);
		
		btnEditarProducto = new JButton("<html>Editar<br>Producto</html>");
		btnEditarProducto.addActionListener(this);
		btnEditarProducto.setIcon(new ImageIcon(GestorInventario.class.getResource("/img/imgEditarProducto.png")));
		btnEditarProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarProducto.setFocusable(false);
		btnEditarProducto.setEnabled(false);
		btnEditarProducto.setBounds(210, 11, 169, 83);
		panel_2.add(btnEditarProducto);
		
		btnEliminarProducto = new JButton("<html>Eliminar<br>Producto</html>");
		btnEliminarProducto.addActionListener(this);
		btnEliminarProducto.setIcon(new ImageIcon(GestorInventario.class.getResource("/img/btnEliminarProducto .png")));
		btnEliminarProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminarProducto.setFocusable(false);
		btnEliminarProducto.setEnabled(false);
		btnEliminarProducto.setBounds(410, 11, 169, 83);
		panel_2.add(btnEliminarProducto);
		
		btnExportarDatos = new JButton("<html>Exportar<br>Datos</html>");
		btnExportarDatos.addActionListener(this);
		btnExportarDatos.setIcon(new ImageIcon(GestorInventario.class.getResource("/img/imgExportarDatos.png")));
		btnExportarDatos.setHorizontalAlignment(SwingConstants.LEFT);
		btnExportarDatos.setFocusable(false);
		btnExportarDatos.setEnabled(true);
		btnExportarDatos.setBounds(600, 11, 169, 83);
		panel_2.add(btnExportarDatos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(257, 121, 790, 529);
		getContentPane().add(scrollPane);

		
		tabla = new JTable();
		tabla.addMouseListener(this);
		tabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabla);
		lblSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				MenuPrincipal mp = new MenuPrincipal(code);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
			}
		});
		
		cargarCbo();
		cargarTablaID();
		
	}
	private void cargarCbo() {
		
		gEmp = new NgcEmpleado();
		listaEmp = gEmp.Lista();
		
		for (int i = 0; i < listaEmp.size(); i++) {
			
			
			cboDueño.addItem(listaEmp.get(i).getID_Emp() );
			
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnExportarDatos) {
			actionPerformedBtnExportarDatos(e);
		}
		if (e.getSource() == btnEliminarProducto) {
			actionPerformedBtnEliminarProducto(e);
		}
		if (e.getSource() == btnEditarProducto) {
			actionPerformedBtnEditarProducto(e);
		}
		if (e.getSource() == btnAgregarProducto) {
			actionPerformedBtnAgregarProducto(e);
		}
		if (e.getSource() == cboDueño) {
			actionPerformedcboDueño(e);
		}
	}
	
	
	protected void actionPerformedcboDueño(ActionEvent e) {
		
		cargartxt();

		if (cbVer.isSelected()){
			
			cargarTablaID();
			
		}else if(!cbVer.isSelected()) {
			CargarTablaNombre();
		}
		
		
		
	}
	protected void mouseClickedCbVer(MouseEvent e) {
		
		
		if (cbVer.isSelected()){
			
			cargarTablaID();
			
		}else if(!cbVer.isSelected()) {
			CargarTablaNombre();
		}
		
		
		
	}
	
	private void CargarTablaNombre() {
		String Columnas[] = {"ID_Pro_Emp", "ID_Emp", "ID_Pro", "Stock"};
		
		gPE = new NgcProducto_Empleado();
		gEmp = new NgcEmpleado();
		gPro = new NgcProducto();
		gPer = new NgcPersona();
		
		listaPE = gPE.BuscarIdEmp( getCBO() );
	
		String Filas[][] = new String[listaPE.size()][4];

		for (int i = 0; i < listaPE.size(); i++) {

			ObjPE = listaPE.get(i);
			String idEmp = ObjPE.getId_emp();
			int idPro = ObjPE.getId_pro();
			
			ObjEmp = gEmp.BuscarID(idEmp);
			ObjPro = gPro.Buscar(idPro);
			ObjPer = gPer.BuscarDNI(ObjEmp.getDni_Persona());
			
			
			Filas[i][0] = String.valueOf(ObjPE.getId_pro_emp());
			Filas[i][1] = String.valueOf(ObjPer.getNombrePersona() + " " + ObjPer.getApellidosPersona());
			Filas[i][2] = String.valueOf(ObjPro.getNom_pro());
			Filas[i][3] = String.valueOf(ObjPE.getStock());

		}
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
		
	}

	public void cargarTablaID() {
		
		String Columnas[] = {"ID_Pro_Emp", "ID_Emp", "ID_Pro", "Stock"};
		
		gPE = new NgcProducto_Empleado();
		
		listaPE = gPE.BuscarIdEmp( getCBO() );
	
		String Filas[][] = new String[listaPE.size()][4];
		
		
		for (int i = 0; i < listaPE.size(); i++) {
			
			
			ObjPE = listaPE.get(i);
			Filas[i][0] = String.valueOf(ObjPE.getId_pro_emp());
			Filas[i][1] = String.valueOf(ObjPE.getId_emp());
			Filas[i][2] = String.valueOf(ObjPE.getId_pro());
			Filas[i][3] = String.valueOf(ObjPE.getStock());

		}
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
		
		
	}
	

	private void cargartxt() {
		try {
			gPer = new NgcPersona();
			gEmp = new NgcEmpleado();
			
			ObjEmp = gEmp.BuscarID(getCBO());
			ObjPer = gPer.BuscarDNI(ObjEmp.getDni_Persona());
			txtNombreEmp.setText(ObjPer.getNombrePersona() +" "+ ObjPer.getApellidosPersona() );
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	protected void actionPerformedBtnAgregarProducto(ActionEvent e) {
		
		frmAgregarProducto ap = new frmAgregarProducto(getCBO());
		ap.setLocationRelativeTo(getContentPane());
		ap.setVisible(true);
		
		cargarTablaID();
		habilitarBotones(false);		
		
		
	}
	protected void actionPerformedBtnEditarProducto(ActionEvent e) {
		
		try {
			int fila = tabla.getSelectedRow();
			int idPE =Integer.parseInt(tabla.getValueAt(fila, 0).toString());
					
					
			FrmEditarRelacion ep = new FrmEditarRelacion(idPE);
			ep.setLocationRelativeTo(getContentPane());
			ep.setVisible(true);
			
			cargarTablaID();
			habilitarBotones(false);	
		} catch (Exception e2) {
		
			JOptionPane.showMessageDialog(contentPanel, "Seleccione una fila ");
		}
		
	}
	protected void actionPerformedBtnEliminarProducto(ActionEvent e) {
		
		try {
			int i = tabla.getSelectedRow();
			if ( i == -1) {
				throw new Exception();
			}
			try {
				
				gPE = new NgcProducto_Empleado();
				int idPE =Integer.parseInt(tabla.getValueAt(i, 0).toString());

				
				ObjPE = gPE.Buscar(idPE);
				
				int flag = JOptionPane.showConfirmDialog( null, "¿Desea Eliminar "+  ObjPE.getId_pro_emp() +" ?", "Alerta", 0);
				
				if (flag == 0) {

					gPE.Eliminar(ObjPE.getId_pro_emp());
					JOptionPane.showMessageDialog(null, "Relacion Eliminado");
					cargarTablaID();

				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}
		
		
		
	}


	protected void actionPerformedBtnExportarDatos(ActionEvent e) {
		try {
			
			Reporte ri = new Reporte("src/Jasper/ReporteInventario.jasper");
			ri.setLocationRelativeTo(getContentPane());
			ri.setVisible(true);	
			
		} catch (Exception e2) {
			
			System.out.println(e2);
		}
		
		
	}
	
	private String getCBO() {
		return cboDueño.getSelectedItem().toString().trim();
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tabla) {
			mouseClickedTabla(e);
		}
		if (e.getSource() == cbVer) {
			mouseClickedCbVer(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	protected void mouseClickedTabla(MouseEvent e) {

		habilitarBotones(true);
		
		
	}

	private void habilitarBotones(boolean sino) {
		
		btnEditarProducto.setEnabled(sino);
		btnEliminarProducto.setEnabled(sino);
		
		btnAgregarProducto.setEnabled(!sino);
		btnExportarDatos.setEnabled(!sino);
		
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		
		habilitarBotones(false );
		
	}
}
