package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBoxMenuItem;
import com.toedter.calendar.JDateChooser;

import CapaNegocio.NgcVenta;
import Clases.Venta;
import Formulario.EliminarRegistroFrm;
import Formulario.ModificaRegistroFrm;
import Formulario.RegistroFrm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GestorVentas extends JFrame implements ActionListener {
	
	private NgcVenta NgcVenta;
	private ArrayList<Venta> ListaVenta;
	private Venta ObjV;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblAadirVenta;
	private JLabel lblModificarVenta;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblListaVentarVentas;
	private JLabel lblBorrarVenta;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblCdigoDeVenta;
	private JLabel lblDesde;
	private JLabel lblHasta;
	private JDateChooser dcFecDes;
	private JDateChooser dcFecHas;
	private JButton btnBuscar;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mnExportar;

	/**
	 * Launch the application.
	 */
	public void CargarTabla(){
		String Columnas []={"Id-Ventas","Nombre","Unidad","Cantidad","Precio Unitario","Sub-Total","IGV","Importe a Pagar","Fecha"};
		NgcVenta =new NgcVenta();
		ListaVenta = NgcVenta.Lista();
		String filas[][]=new String[ListaVenta.size()][9];
		for(int i=0;i<ListaVenta.size();i++){
			filas[i][0]=String.valueOf(ListaVenta.get(i).getCodigo());
			filas[i][1]=ListaVenta.get(i).getNombre();
			filas[i][2]=ListaVenta.get(i).getUnidad();
			filas[i][3]=String.valueOf(ListaVenta.get(i).getCantidad());
			filas[i][4]=String.valueOf(ListaVenta.get(i).getPrecioUnitario());
			filas[i][5]=String.valueOf(ListaVenta.get(i).SubTotal());
			filas[i][6]=String.valueOf(ListaVenta.get(i).IGV());
			filas[i][7]=String.valueOf(ListaVenta.get(i).ImportePagar());
			filas[i][8]=ListaVenta.get(i).getFecha();
		}
		DefaultTableModel modelo=new DefaultTableModel(filas,Columnas);
		table.setModel(modelo);
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorVentas frame = new GestorVentas();
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
	public GestorVentas() {
		setTitle("Gestor de Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Mas");
		menuBar.add(mnNewMenu);
		
		mnExportar = new JMenuItem("Exportar PDF");
		mnExportar.addActionListener(this);
		mnNewMenu.add(mnExportar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/img_01.png")));
		lblNewLabel.setBounds(439, 50, 320, 334);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedLblNewLabel_1(arg0);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/insertar.png")));
		lblNewLabel_1.setBounds(58, 169, 128, 128);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedLblNewLabel_2(arg0);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/editar.png")));
		lblNewLabel_2.setBounds(258, 169, 128, 128);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Bienvenido");
		lblNewLabel_3.setFont(new Font("Bodoni MT Black", Font.BOLD, 25));
		lblNewLabel_3.setBounds(467, 389, 153, 30);
		contentPane.add(lblNewLabel_3);
		
		lblAadirVenta = new JLabel("A\u00F1adir Venta");
		lblAadirVenta.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblAadirVenta.setBounds(47, 302, 153, 30);
		contentPane.add(lblAadirVenta);
		
		lblModificarVenta = new JLabel("Modificar Venta");
		lblModificarVenta.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblModificarVenta.setBounds(235, 305, 179, 24);
		contentPane.add(lblModificarVenta);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedLblNewLabel_4(arg0);
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/lista.png")));
		lblNewLabel_4.setBounds(805, 169, 128, 128);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedLblNewLabel_5(arg0);
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/Eliminar.png")));
		lblNewLabel_5.setBounds(1014, 169, 128, 128);
		contentPane.add(lblNewLabel_5);
		
		lblListaVentarVentas = new JLabel("ListaVentar");
		lblListaVentarVentas.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblListaVentarVentas.setBounds(789, 305, 179, 24);
		contentPane.add(lblListaVentarVentas);
		
		lblBorrarVenta = new JLabel("Borrar Venta");
		lblBorrarVenta.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblBorrarVenta.setBounds(999, 305, 153, 24);
		contentPane.add(lblBorrarVenta);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(GestorVentas.class.getResource("/img/regresar_Menu.png")));
		lblNewLabel_6.setBounds(10, 20, 64, 64);
		contentPane.add(lblNewLabel_6);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 461, 1190, 267);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		
		
		
		lblCdigoDeVenta = new JLabel("Fecha de Venta");
		lblCdigoDeVenta.setFont(new Font("Bodoni MT Black", Font.BOLD, 18));
		lblCdigoDeVenta.setBounds(10, 362, 164, 22);
		contentPane.add(lblCdigoDeVenta);
		
		lblDesde = new JLabel("Desde");
		lblDesde.setFont(new Font("Bodoni MT Black", Font.BOLD, 18));
		lblDesde.setBounds(10, 395, 164, 22);
		contentPane.add(lblDesde);
		
		lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Bodoni MT Black", Font.BOLD, 18));
		lblHasta.setBounds(10, 421, 161, 22);
		contentPane.add(lblHasta);
		
		dcFecDes = new JDateChooser();
		dcFecDes.setDateFormatString("yyyy-M-dd");
		dcFecDes.setBounds(82, 393, 125, 26);
		contentPane.add(dcFecDes);
		
		dcFecHas = new JDateChooser();
		dcFecHas.setDateFormatString("yyyy-M-dd");
		dcFecHas.setBounds(82, 419, 125, 26);
		contentPane.add(dcFecHas);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setBounds(225, 392, 115, 29);
		contentPane.add(btnBuscar);
		
		
		CargarTabla();
		
		
		
	}
	protected void mouseClickedLblNewLabel_1(MouseEvent arg0) {
		RegistroFrm R=new RegistroFrm();
		R.setVisible(true);
		
	}
	protected void mouseClickedLblNewLabel_4(MouseEvent arg0) {
		CargarTabla();
	}
	protected void mouseClickedLblNewLabel_2(MouseEvent arg0) {
		ModificaRegistroFrm M=new ModificaRegistroFrm();
		M.setVisible(true);
	}
	public String fechaD(){
		Date fecha=dcFecDes.getDate();
		SimpleDateFormat FormatoFecha=new SimpleDateFormat("YYYY/M/dd");
		return FormatoFecha.format(fecha);
	}
	public String fechaH(){
		Date fecha=dcFecHas.getDate();
		SimpleDateFormat FormatoFecha=new SimpleDateFormat("YYYY/M/dd");
		return FormatoFecha.format(fecha);
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		String Columnas []={"Id-Ventas","Nombre","Unidad","Cantidad","Precio Unitario","Sub-Total","IGV","Importe a Pagar","Fecha"};
		NgcVenta=new NgcVenta();
		ListaVenta =NgcVenta.Buscar(fechaD(), fechaH());
		String filas[][]=new String[ListaVenta.size()][9];
		for(int i=0;i<ListaVenta.size();i++){
			filas[i][0]=String.valueOf(ListaVenta.get(i).getCodigo());
			filas[i][1]=ListaVenta.get(i).getNombre();
			filas[i][2]=ListaVenta.get(i).getUnidad();
			filas[i][3]=String.valueOf(ListaVenta.get(i).getCantidad());
			filas[i][4]=String.valueOf(ListaVenta.get(i).getPrecioUnitario());
			filas[i][5]=String.valueOf(ListaVenta.get(i).SubTotal());
			filas[i][6]=String.valueOf(ListaVenta.get(i).IGV());
			filas[i][7]=String.valueOf(ListaVenta.get(i).ImportePagar());
			filas[i][8]=ListaVenta.get(i).getFecha();
		}
		DefaultTableModel modelo=new DefaultTableModel(filas,Columnas);
		table.setModel(modelo);
	}
	protected void mouseClickedLblNewLabel_5(MouseEvent arg0) {
		EliminarRegistroFrm E=new EliminarRegistroFrm();
		E.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mnExportar) {
			actionPerformedmnExportar(e);
		}
	}
	protected void actionPerformedmnExportar(ActionEvent e) {
		
		
		
		
	}
}
