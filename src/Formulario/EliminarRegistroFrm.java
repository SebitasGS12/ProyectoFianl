package Formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import CapaNegocio.NgcVenta;
import Clases.Venta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class EliminarRegistroFrm extends JFrame {


	private ArrayList<Venta>Lista;
	private JPanel contentPane;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JLabel lblUnidad;
	private JLabel lblPrecioUnitario;
	private JTextField txtPrecioUnit;
	private JLabel lblFecha;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private JTextField txtFecha;
	private JTextField txtUnidad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarRegistroFrm frame = new EliminarRegistroFrm();
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
	public EliminarRegistroFrm() {
		setAutoRequestFocus(false);
		setTitle("ELIMINAR REGISTRO");
		setBounds(100, 100, 398, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(15, 16, 69, 20);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(77, 13, 87, 26);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 55, 69, 20);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(87, 52, 146, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(15, 94, 69, 20);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(87, 91, 94, 26);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblUnidad = new JLabel("Unidad");
		lblUnidad.setBounds(15, 134, 69, 20);
		contentPane.add(lblUnidad);
		
		lblPrecioUnitario = new JLabel("Precio Unitario");
		lblPrecioUnitario.setBounds(15, 170, 104, 20);
		contentPane.add(lblPrecioUnitario);
		
		txtPrecioUnit = new JTextField();
		txtPrecioUnit.setColumns(10);
		txtPrecioUnit.setBounds(123, 167, 94, 26);
		contentPane.add(txtPrecioUnit);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(15, 206, 69, 20);
		contentPane.add(lblFecha);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnEliminar(arg0);
			}
		});
		btnEliminar.setBounds(77, 239, 115, 29);
		contentPane.add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(217, 239, 115, 29);
		contentPane.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnBuscar(arg0);
			}
		});
		btnBuscar.setBounds(217, 12, 115, 29);
		contentPane.add(btnBuscar);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(77, 203, 94, 26);
		contentPane.add(txtFecha);
		
		txtUnidad = new JTextField();
		txtUnidad.setColumns(10);
		txtUnidad.setBounds(87, 131, 94, 26);
		contentPane.add(txtUnidad);
	}
	
	
	
	
	NgcVenta gestor =  new NgcVenta();
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
					txtFecha.setText(Lista.get(cod).getFecha());
					if(Lista.get(cod).getUnidad()=="Arrobas"){
						txtUnidad.setText("Arrobas");
					}
					else{
						txtUnidad.setText("Kilogramos");
					}
						
				}
				else{
				JOptionPane.showMessageDialog(this, "No se realizo esa transacción");}		
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		gestor.Eliminar(Integer.parseInt(txtCodigo.getText()));
		
	}
}
