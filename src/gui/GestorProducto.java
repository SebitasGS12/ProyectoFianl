package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.css.RGBColor;

import CapaNegocio.NgcProducto;
import Clases.Producto;
import Jasper.Reporte;

import java.awt.Toolkit;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GestorProducto extends JDialog implements MouseListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panelMenu;
	private JLabel lblMenuPrincipal;
	private NgcProducto gPro;
	private Producto ObjPro;
	private ArrayList<Producto> listaPro;
	private DefaultTableModel MiModelo;
	private JButton btnAgregarProducto;
	private JButton btnEditarProducto;
	private JButton btnExportarDatos;
	private static int Dni ; 
	private JButton btnEliminarProducto;
	private JScrollPane scrollPane;
	private JTable tabla;
	private JPanel panelDatos;
	private JTextField txtNombre;
	private JLabel lblNewLabel_2;
	private JTextField txtPrecio;
	private JLabel lblNewLabel_3;
	private JComboBox cboDetalle;
	private JTextField txtID;
	private JButton btnValidar;
	private JButton btnCancelar;
	private JButton btnFiltroID;
	private JButton btnFiltroNombre;
	private JButton btnFiltroPrecio;
	private JButton btnFiltroDetalle;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestorProducto dialog = new GestorProducto(Dni);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestorProducto(int code) {
		Dni = code;
		setModal(true);
		setForeground(SystemColor.inactiveCaption);
		setBackground(SystemColor.desktop);
		setTitle("Gestor de Inventario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestorProducto.class.getResource("/img/ico.png")));
		setBounds(100, 100, 1200,700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(104, 115, 87));
		panel.setBounds(0, 0, 177, 661);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblMenuPrincipal = new JLabel("");
		lblMenuPrincipal.setToolTipText("Menu Principal");
		lblMenuPrincipal.addMouseListener(this);
		lblMenuPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setIcon(new ImageIcon(GestorProducto.class.getResource("/img/imgMenuPrincipal.png")));
		lblMenuPrincipal.setBounds(10, 11, 157, 117);
		
		lblMenuPrincipal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				dispose();
				MenuPrincipal mp = new MenuPrincipal(code);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
			}
		
		});
		
		panel.add(lblMenuPrincipal);
		
		btnFiltroID = new JButton("Filtrar Por ID");
		btnFiltroID.addActionListener(this);
		btnFiltroID.setBounds(10, 216, 157, 30);
		panel.add(btnFiltroID);
		
		btnFiltroNombre = new JButton("Filtrar por Nombre");
		btnFiltroNombre.addActionListener(this);
		btnFiltroNombre.setBounds(10, 271, 157, 30);
		panel.add(btnFiltroNombre);
		
		btnFiltroPrecio = new JButton("Filtrar Por Precio");
		btnFiltroPrecio.addActionListener(this);
		btnFiltroPrecio.setBounds(10, 328, 157, 30);
		panel.add(btnFiltroPrecio);
		
		btnFiltroDetalle = new JButton("Filtrar por Detalle");
		btnFiltroDetalle.addActionListener(this);
		btnFiltroDetalle.setBounds(10, 382, 157, 30);
		panel.add(btnFiltroDetalle);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(248, 248, 255));
		panelMenu.setBounds(187, 0, 987, 106);
		contentPanel.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnAgregarProducto = new JButton("<html>Agregar<br>Producto</html>");
		btnAgregarProducto.addActionListener(this);
		btnAgregarProducto.addMouseListener(this);
		btnAgregarProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarProducto.setFocusable(false);
		btnAgregarProducto.setIcon(new ImageIcon(GestorProducto.class.getResource("/img/imgNuevoProducto.png")));
		btnAgregarProducto.setBounds(10, 11, 169, 83);
		panelMenu.add(btnAgregarProducto);
		
		btnEditarProducto = new JButton("<html>Editar<br>Producto</html>");
		
		btnEditarProducto.addActionListener(this);
		btnEditarProducto.setIcon(new ImageIcon(GestorProducto.class.getResource("/img/imgEditarProducto.png")));
		btnEditarProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarProducto.setFocusable(false);
		btnEditarProducto.setBounds(210, 11, 169, 83);
		panelMenu.add(btnEditarProducto);
		
		btnExportarDatos = new JButton("<html>Exportar<br>Datos</html>");
		btnExportarDatos.addActionListener(this);
		btnExportarDatos.setIcon(new ImageIcon(GestorProducto.class.getResource("/img/imgExportarDatos.png")));
		btnExportarDatos.setHorizontalAlignment(SwingConstants.LEFT);
		btnExportarDatos.setFocusable(false);
		btnExportarDatos.setBounds(808, 11, 169, 83);
		panelMenu.add(btnExportarDatos);
		
		
		btnEliminarProducto = new JButton("<html>Eliminar<br>Producto</html>");
		btnEliminarProducto.addActionListener(this);
		btnEliminarProducto.setIcon(new ImageIcon(GestorProducto.class.getResource("/img/btnEliminarProducto .png")));
		btnEliminarProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminarProducto.setFocusable(false);
		btnEliminarProducto.setBounds(410, 11, 169, 83);
		panelMenu.add(btnEliminarProducto);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 231, 987, 419);
		contentPanel.add(scrollPane);
		
		tabla = new JTable();
		tabla.addMouseListener(this);
		tabla.setFont(new Font("Meiryo", Font.PLAIN, 16));
		tabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabla);
		
		panelDatos = new JPanel();
		panelDatos.setBackground(new Color(224, 255, 255));
		panelDatos.setBounds(187, 117, 987, 103);
		contentPanel.add(panelDatos);
		panelDatos.setEnabled(false);
		panelDatos.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 92, 18);
		panelDatos.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 58, 92, 18);
		panelDatos.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(112, 58, 187, 20);
		panelDatos.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(324, 12, 92, 18);
		panelDatos.add(lblNewLabel_2);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(426, 12, 187, 20);
		panelDatos.add(txtPrecio);
		
		lblNewLabel_3 = new JLabel("Detalle");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(324, 56, 92, 18);
		panelDatos.add(lblNewLabel_3);
		
		cboDetalle = new JComboBox();
		cboDetalle.setModel(new DefaultComboBoxModel(new String[] {"Kilogramo", "Unidad", "Abarrote"}));
		cboDetalle.setBounds(426, 57, 187, 22);
		panelDatos.add(cboDetalle);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(112, 11, 187, 20);
		panelDatos.add(txtID);
		txtID.setColumns(10);
		
		btnValidar = new JButton("Validar");
		btnValidar.addActionListener(this);
		btnValidar.setBounds(806, 10, 171, 28);
		panelDatos.add(btnValidar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(806, 57, 171, 28);
		panelDatos.add(btnCancelar);
		
		
		habilitarBotones(false);
		
		CargarTabla();
		
	}
	
	public void CargarTabla() {
		
		String Columnas[] = {"ID_PrO", "Nombre", "Precio", "Detalle"};
		
		gPro = new NgcProducto();
		
		listaPro = gPro.Lista();
	
		String Filas[][] = new String[listaPro.size()][4];
		for (int i = 0; i < listaPro.size(); i++) {
			ObjPro = listaPro.get(i);
			Filas[i][0] =  String.valueOf(ObjPro.getIdProducto());
			Filas[i][1] = ObjPro.getNom_pro();
			Filas[i][2] = String.valueOf(ObjPro.getPrecio());
			Filas[i][3] = String.valueOf(ObjPro.getDetalle());

		}
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
		
		txtID.setText(gPro.CodigoAutogenerado()+"");
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tabla) {
			mouseClickedTabla(e);
		}
		if (e.getSource() == lblMenuPrincipal) {
			mouseClickedLblMenuPrincipal(e);
		}

	}
	
	protected void mouseClickedLblMenuPrincipal(MouseEvent e) {		
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExportarDatos) {
			actionPerformedBtnExportarDatos(e);
		}
		if (e.getSource() == btnFiltroDetalle) {
			actionPerformedBtnFiltroDetalle(e);
		}
		if (e.getSource() == btnFiltroPrecio) {
			actionPerformedBtnFiltroPrecio(e);
		}
		if (e.getSource() == btnFiltroNombre) {
			actionPerformedBtnFiltroNombre(e);
		}
		if (e.getSource() == btnFiltroID) {
			actionPerformedBtnFiltroID(e);
		}
		if (e.getSource() == btnCancelar) {
			Cancelar();
		}
		if (e.getSource() == btnEliminarProducto) {
			actionPerformedbtnEliminarProducto(e);
		}
		if (e.getSource() == btnValidar) {
			validarDatos();
		}
		if (e.getSource() == btnEditarProducto) {
			actionPerformedBtnEditarProducto(e);
		}
		if (e.getSource() == btnAgregarProducto) {
			actionPerformedBtnAgregarProducto(e);
		}

	}
	private void actionPerformedbtnEliminarProducto(ActionEvent e) {
		try {
			int i = tabla.getSelectedRow();
			if ( i == -1) {
				throw new Exception();
			}
			try {
				
				gPro = new NgcProducto();
				
				ObjPro = gPro.Lista().get(i);
				
				int flag = JOptionPane.showConfirmDialog( null, "¿Desea Eliminar "+  ObjPro.getNom_pro() +" ?", "Alerta", 0);
				
				if (flag == 0) {

					int idPro  =ObjPro.getIdProducto() ;
					gPro.Eliminar(idPro);
					JOptionPane.showMessageDialog(null, "Producto Eliminado");
					CargarTabla();
					Cancelar();
				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}
		
	}

	private boolean validarDatos() {
		
		String errores  = " ";
		try {

			if (getNombre().matches("[A-Za-z\\s]*")){
				
				txtNombre.setForeground(Color.GREEN);
				
			}else {
			
				txtNombre.setForeground(Color.red);
				errores += "\n * El Nombre";
			}
			
			if ( getPrecio() < 400.0 && getPrecio() > 0.0) {
				txtPrecio.setForeground(Color.GREEN);
				
			}else {
			
				txtPrecio.setForeground(Color.red);
				errores += "\n * El Precio debe ser mayor a S/.0 \n y menor que S/.400";
			}
			
			if(errores.equals(" ")) {
				return true;
				
			}else {
				JOptionPane.showMessageDialog(getContentPane(),"Verifique los siguientes datos :" + errores,"Validacion", 2);
				return false;
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(getContentPane(),"Inserte Datos Correspondientes","Validacion", 2);
		}
		return false;
		
		
		
		
	}

	protected void actionPerformedBtnAgregarProducto(ActionEvent e) {	

		gPro = new NgcProducto();
		
		if (validarDatos()) {
			
			try {
				
				ObjPro = new Producto( );
				ObjPro.setIdProducto(getID());
				ObjPro.setNom_pro(getNombre());
				ObjPro.setPrecio(getPrecio());
				ObjPro.setDetalle(getDetalle());

				gPro.Insertar( ObjPro );
				
				CargarTabla();
				
				JOptionPane.showMessageDialog(getContentPane(),"Agregado Correctamente");
				
				Cancelar();
							
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getContentPane(),e2 + "error en agregar");
			}
		}

	}
	protected void actionPerformedBtnEditarProducto(ActionEvent e) {
		
		try {
			
			gPro = new NgcProducto();
			
			if ( validarDatos() ) {
				
				try {
					
					ObjPro = gPro.Buscar(getID());

					ObjPro.setNom_pro(getNombre());
					ObjPro.setPrecio(getPrecio());
					ObjPro.setDetalle(getDetalle());
	
					gPro.Modificar( ObjPro );
					CargarTabla();
					Cancelar();
								
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(),e2);
				}
			}

			JOptionPane.showMessageDialog(getContentPane(),"Editado Correctamente");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(getContentPane(),e2);
		}
		
		
	}
	protected void mouseClickedTabla(MouseEvent e) {
		
		try {
			
			int fila = tabla.getSelectedRow();

			try {

				
				txtID.setText(tabla.getValueAt(fila, 0).toString() );
				txtID.setForeground(Color.black);
				
				txtNombre.setText(tabla.getValueAt(fila, 1).toString() );	
				txtNombre.setForeground(Color.black);
				txtPrecio.setText(tabla.getValueAt(fila, 2).toString() );
				txtPrecio.setForeground(Color.black);
				insertarCbo(tabla.getValueAt(fila, 3).toString() );
				habilitarBotones(true);			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getContentPane(), e2+ "en producto ");
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(getContentPane(), e2+ "en producto ");
		
		}
		
		
		
		
	}

	private void insertarCbo(String valor) {
		if ( valor.equals("kilogramo")) {
			cboDetalle.setSelectedIndex(0);
		}else if(valor.equals("unidad")){
			cboDetalle.setSelectedIndex(1);
			
		}else if(valor.equals("Abarrote")){
			cboDetalle.setSelectedIndex(2);
		}
		
		
	}
	
	
	private void habilitarBotones(boolean sino) {
		btnEditarProducto.setEnabled(sino);
		btnEliminarProducto.setEnabled(sino);
		
		btnAgregarProducto.setEnabled(!sino);
		btnExportarDatos.setEnabled(!sino);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	int getID() {
		return Integer.parseInt(txtID.getText());
		
	}
	
	String getNombre() {
		return txtNombre.getText().trim();
				
	}
	
	double getPrecio() {
		
		return Double.parseDouble(txtPrecio.getText());
	}
	
	
	String getDetalle() {
		
		return cboDetalle.getSelectedItem().toString().trim();
		
	}

	private void Cancelar() {
		
		
		limpiarDatos();
		CargarTabla();
	
	}
	
	private void limpiarDatos() {
		txtID.setText("");
		txtPrecio.setText("");
		txtNombre.setText("");
		cboDetalle.setSelectedIndex(0);
		
		
		habilitarBotones(false);
		
	}
	protected void actionPerformedBtnFiltroID(ActionEvent e) {
		String Columnas[] = {"ID_PrO", "Nombre", "Precio", "Detalle"};
		
		gPro = new NgcProducto();
		
		listaPro = gPro.FiltroID();
	
		String Filas[][] = new String[listaPro.size()][4];
		for (int i = 0; i < listaPro.size(); i++) {
			ObjPro = listaPro.get(i);
			Filas[i][0] =  String.valueOf(ObjPro.getIdProducto());
			Filas[i][1] = ObjPro.getNom_pro();
			Filas[i][2] = String.valueOf(ObjPro.getPrecio());
			Filas[i][3] = String.valueOf(ObjPro.getDetalle());

		}
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
		
		txtID.setText(gPro.CodigoAutogenerado()+"");
		
		
	}
	protected void actionPerformedBtnFiltroNombre(ActionEvent e) {
		
String Columnas[] = {"ID_PrO", "Nombre", "Precio", "Detalle"};
		
		gPro = new NgcProducto();
		
		listaPro = gPro.FiltroNombre();
	
		String Filas[][] = new String[listaPro.size()][4];
		for (int i = 0; i < listaPro.size(); i++) {
			ObjPro = listaPro.get(i);
			Filas[i][0] =  String.valueOf(ObjPro.getIdProducto());
			Filas[i][1] = ObjPro.getNom_pro();
			Filas[i][2] = String.valueOf(ObjPro.getPrecio());
			Filas[i][3] = String.valueOf(ObjPro.getDetalle());

		}
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
		
		txtID.setText(gPro.CodigoAutogenerado()+"");
	}
	protected void actionPerformedBtnFiltroPrecio(ActionEvent e) {
		String Columnas[] = {"ID_PrO", "Nombre", "Precio", "Detalle"};
		
		gPro = new NgcProducto();
		
		listaPro = gPro.FiltroPrecio();
	
		String Filas[][] = new String[listaPro.size()][4];
		for (int i = 0; i < listaPro.size(); i++) {
			ObjPro = listaPro.get(i);
			Filas[i][0] =  String.valueOf(ObjPro.getIdProducto());
			Filas[i][1] = ObjPro.getNom_pro();
			Filas[i][2] = String.valueOf(ObjPro.getPrecio());
			Filas[i][3] = String.valueOf(ObjPro.getDetalle());

		}
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
		
		txtID.setText(gPro.CodigoAutogenerado()+"");
	}
	protected void actionPerformedBtnFiltroDetalle(ActionEvent e) {
		String Columnas[] = {"ID_PrO", "Nombre", "Precio", "Detalle"};
		
		gPro = new NgcProducto();
		
		listaPro = gPro.filtroDetalle();
	
		String Filas[][] = new String[listaPro.size()][4];
		for (int i = 0; i < listaPro.size(); i++) {
			ObjPro = listaPro.get(i);
			Filas[i][0] =  String.valueOf(ObjPro.getIdProducto());
			Filas[i][1] = ObjPro.getNom_pro();
			Filas[i][2] = String.valueOf(ObjPro.getPrecio());
			Filas[i][3] = String.valueOf(ObjPro.getDetalle());

		}
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
		
		txtID.setText(gPro.CodigoAutogenerado()+"");
	}
	protected void actionPerformedBtnExportarDatos(ActionEvent e) {
		
		Reporte ri = new Reporte("src/Jasper/ReporteProducto.jasper");
		ri.setLocationRelativeTo(getContentPane());
		ri.setVisible(true);
		
	}
}
