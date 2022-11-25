package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestorVentas extends JDialog  {

	DefaultTableModel modelo=new DefaultTableModel();
	private JPanel contentPane;
	private JLabel lblInicio;
	private JLabel lblAñadir;
	private JLabel lblModificar;
	private JLabel lblNewLabel_3;
	private JLabel lblAñadirVenta;
	private JLabel lblModificarVenta;
	private JLabel lblListar;
	private JLabel lblBorrar;
	private JLabel lblListarVentas;
	private JLabel lblBorrarVenta;
	private JLabel lblSalir;
	private JScrollPane scrollPane;
	private JTable table;
	private static int Dni; 

	
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestorVentas dialog = new GestorVentas(Dni);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestorVentas(int code) {
		Dni = code;
		setModal(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Gestor de Ventas");

		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(156,219,220));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInicio = new JLabel("New label");
		lblInicio.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/img_01.png")));
		lblInicio.setBounds(439, 50, 320, 334);
		contentPane.add(lblInicio);
		
		lblAñadir = new JLabel("");
		lblAñadir.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/insertar.png")));
		lblAñadir.setBounds(58, 169, 128, 128);
		contentPane.add(lblAñadir);
		
		lblModificar = new JLabel("New label");
		lblModificar.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/editar.png")));
		lblModificar.setBounds(258, 169, 128, 128);
		contentPane.add(lblModificar);
		
		lblNewLabel_3 = new JLabel("Bienvenido");
		lblNewLabel_3.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblNewLabel_3.setBounds(467, 389, 153, 30);
		contentPane.add(lblNewLabel_3);
		
		lblAñadirVenta = new JLabel("A\u00F1adir Venta");
		lblAñadirVenta.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblAñadirVenta.setBounds(47, 302, 153, 30);
		contentPane.add(lblAñadirVenta);
		
		lblModificarVenta = new JLabel("Modificar Venta");
		lblModificarVenta.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblModificarVenta.setBounds(235, 305, 179, 24);
		contentPane.add(lblModificarVenta);
		
		lblListar = new JLabel("New label");
		lblListar.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/lista.png")));
		lblListar.setBounds(805, 169, 128, 128);
		contentPane.add(lblListar);
		
		lblBorrar = new JLabel("New label");
		lblBorrar.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/Eliminar.png")));
		lblBorrar.setBounds(1014, 169, 128, 128);
		contentPane.add(lblBorrar);
		
		lblListarVentas = new JLabel("Listar Ventas");
		lblListarVentas.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblListarVentas.setBounds(789, 305, 179, 24);
		contentPane.add(lblListarVentas);
		
		lblBorrarVenta = new JLabel("Borrar Venta");
		lblBorrarVenta.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		
		lblBorrarVenta.setBounds(999, 305, 153, 24);
		contentPane.add(lblBorrarVenta);
		
		lblSalir = new JLabel("");
		lblSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				MenuPrincipal mp = new MenuPrincipal(code);
				mp.setLocationRelativeTo(contentPane);
				mp.setVisible(true);
			}
		
		});
		lblSalir.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/regresar_Menu.png")));
		lblSalir.setBounds(10, 20, 64, 64);
		contentPane.add(lblSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 461, 1164, 267);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		modelo.addColumn("Campo 1");
		modelo.addColumn("Campo 2");
		modelo.addColumn("Campo 3");
		modelo.addColumn("Campo 4");
		modelo.addColumn("Campo 5");
		
	}



}
