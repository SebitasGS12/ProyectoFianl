package Formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CapaNegocio.NgcVenta;
import Clases.Venta;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class ModificaRegistroFrm extends JFrame {

	private ArrayList<Venta>Lista;
	private JPanel contentPane;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblUnidad;
	private JComboBox cboUnidad;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JLabel lblPrecioUnitario;
	private JTextField txtPrecioUnit;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JLabel lblFecha;
	private JDateChooser dcFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaRegistroFrm frame = new ModificaRegistroFrm();
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
	public ModificaRegistroFrm() {
		setResizable(false);
		setTitle("MODIFICAR REGISTRO");
		setBounds(100, 100, 411, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(15, 16, 69, 20);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(74, 13, 87, 26);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 52, 69, 20);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(84, 49, 146, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblUnidad = new JLabel("Unidad");
		lblUnidad.setBounds(15, 123, 69, 20);
		contentPane.add(lblUnidad);
		
		cboUnidad = new JComboBox();
		cboUnidad.setModel(new DefaultComboBoxModel(new String[] {"", "Arrobas", "Kilogramos"}));
		cboUnidad.setBounds(84, 120, 92, 26);
		contentPane.add(cboUnidad);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(15, 87, 69, 20);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(84, 84, 98, 26);
		contentPane.add(txtCantidad);
		
		lblPrecioUnitario = new JLabel("Precio Unitario");
		lblPrecioUnitario.setBounds(15, 159, 104, 20);
		contentPane.add(lblPrecioUnitario);
		
		txtPrecioUnit = new JTextField();
		txtPrecioUnit.setColumns(10);
		txtPrecioUnit.setBounds(132, 156, 98, 26);
		contentPane.add(txtPrecioUnit);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnModificar(arg0);
			}
		});
		btnModificar.setBounds(46, 231, 115, 29);
		contentPane.add(btnModificar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(178, 231, 115, 29);
		contentPane.add(btnCancelar);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(15, 195, 69, 20);
		contentPane.add(lblFecha);
		
		dcFecha = new JDateChooser();
		dcFecha.setDateFormatString("yyyy-M-dd");
		dcFecha.setBounds(74, 189, 125, 26);
		contentPane.add(dcFecha);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnBuscar(arg0);
			}
		});
		btnBuscar.setBounds(263, 12, 115, 29);
		contentPane.add(btnBuscar);
	}
	private JButton btnBuscar;
	
	NgcVenta gestor=new NgcVenta();

	
	public String fecha(){
		Date fecha=dcFecha.getDate();
		SimpleDateFormat FormatoFecha=new SimpleDateFormat("YYYY/M/dd");
		return FormatoFecha.format(fecha);
	}
	
	
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		Venta ObjV=new Venta();
		ObjV.setCodigo(Integer.parseInt(txtCodigo.getText()));
		ObjV.setNombre(txtNombre.getText());
		ObjV.setCantidad(Double.parseDouble(txtCantidad.getText()));
		ObjV.setUnidad(String.valueOf(cboUnidad.getSelectedItem()));
		ObjV.setPrecioUnitario(Double.parseDouble(txtPrecioUnit.getText()));
		ObjV.setFecha(fecha());
		gestor.Modificar(ObjV);
		
	}
	public int buscar(){
			Lista=gestor.Lista();
			int codigo=Integer.parseInt(txtCodigo.getText());
			for(int i=0;i<Lista.size();i++){
				if(codigo==Lista.get(i).getCodigo())
					return i;	
			
			}
			return -1;
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		try{
			Lista=gestor.Lista();
			int cod=buscar();
				if(cod!=-1){
					txtNombre.setText(Lista.get(cod).getNombre());
					txtCantidad.setText(String.valueOf(Lista.get(cod).getCantidad()));
					txtPrecioUnit.setText(String.valueOf(Lista.get(cod).getPrecioUnitario()));
					Date fecha=new Date();
					dcFecha.setDate(fecha);
					if(Lista.get(cod).getUnidad()=="Arrobas"){
						cboUnidad.setSelectedIndex(1);
					}
					else{
						cboUnidad.setSelectedIndex(2);
					}
						
				}
				else{
				JOptionPane.showMessageDialog(this, "No se realizo esa transacción");}
			//
			
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
}
