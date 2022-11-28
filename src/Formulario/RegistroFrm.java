package Formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CapaNegocio.NgcVenta;
import Clases.Venta;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegistroFrm extends JFrame {

	private NgcVenta ObjN;
	private Venta ObjSelected;
	private JPanel contentPane;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JLabel lblNewLabel;
	private JComboBox cboUnidad;
	private JLabel lblPrecioUnitario;
	private JTextField txtPrecioUnit;
	private JButton btnAgregar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroFrm frame = new RegistroFrm();
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
	public RegistroFrm() {
		setTitle("REGISTRO DE VENTA");
		setBounds(100, 100, 423, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 16, 69, 20);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(89, 13, 231, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(15, 54, 69, 20);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(89, 52, 85, 26);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblNewLabel = new JLabel("Unidad");
		lblNewLabel.setBounds(15, 90, 69, 20);
		contentPane.add(lblNewLabel);
		
		cboUnidad = new JComboBox();
		cboUnidad.setModel(new DefaultComboBoxModel(new String[] {"", "Arrobas", "Kilogramos"}));
		cboUnidad.setBounds(89, 87, 85, 26);
		contentPane.add(cboUnidad);
		
		lblPrecioUnitario = new JLabel("Precio Unitario");
		lblPrecioUnitario.setBounds(15, 126, 104, 20);
		contentPane.add(lblPrecioUnitario);
		
		txtPrecioUnit = new JTextField();
		txtPrecioUnit.setBounds(122, 123, 97, 26);
		contentPane.add(txtPrecioUnit);
		txtPrecioUnit.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnAgregar(arg0);
			}
		});
		btnAgregar.setBounds(59, 179, 115, 29);
		contentPane.add(btnAgregar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(222, 179, 115, 29);
		contentPane.add(btnCancelar);
	}
	public static String fechaActual(){
		Date fecha=new Date();
		SimpleDateFormat FormatoFecha=new SimpleDateFormat("YYYY/M/dd");
		return FormatoFecha.format(fecha);
	}
	NgcVenta gestor=new NgcVenta();
	
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		Venta ObjV=new Venta();
		ObjV.setNombre(txtNombre.getText());
		ObjV.setCantidad(Double.parseDouble(txtCantidad.getText()));
		ObjV.setUnidad(String.valueOf(cboUnidad.getSelectedItem()));
		ObjV.setPrecioUnitario(Double.parseDouble(txtPrecioUnit.getText()));
		ObjV.setFecha(fechaActual());
		gestor.Insertar(ObjV);
	}
}
