package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import CapaNegocio.NgcAdmin;
import CapaNegocio.NgcEmpleado;
import CapaNegocio.NgcPersona;
import Clases.Empleado;
import Clases.Persona;
import Formulario.FrmConvertirEmpleado;
import Formulario.FrmCrearNuevaCuenta;
import Formulario.FrmEditarVendedor;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JCheckBox;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import java.awt.event.MouseListener;

public class GestorVendedores extends JDialog implements ActionListener, MouseListener {
	
	private NgcEmpleado ObjNEmp;
	private NgcPersona ObjNPer;
	private NgcAdmin objNAdm;
	private Empleado ObjEmp;
	private Persona ObjPer;
	private int cont = 0 ;
	private ArrayList<Empleado> ListaEmp;
	private ArrayList<Persona> ListaPer;
	private JButton btnEditar;
	private JButton btnVisualizar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JLabel i3;
	private JLabel i2;
	private JLabel lblGestorDeVendedores;
	private JScrollPane scrollPane;
	private JTable tabla;
	private JLabel lblSalir;
	private static int Dni; 
	private JButton btnVerPersonas;
	private JPopupMenu popupMenu;
	private JMenuItem mnConvEmp;
	private DefaultTableModel MiModelo;
	private String Estado = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorVendedores dialog = new GestorVendedores(Dni);
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
	
	
	public GestorVendedores(int code) {
		Dni = code;
		getContentPane().setBackground(new Color(65,105,225));
		setTitle("Gestor de Vendedores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestorVendedores.class.getResource("/img/cajero.png")));
		setModal(true);
		setBounds(100, 100,920, 600);
		
		getContentPane().setLayout(null);
		
		lblSalir = new JLabel("");
		lblSalir.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/regresar_Menu.png")));
		lblSalir.setBounds(10, 11, 64, 64);
		lblSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				MenuPrincipal mp = new MenuPrincipal(code);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
			}
		});
		getContentPane().add(lblSalir);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/computadora.png")));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnEditar.setBounds(187, 471, 167, 79);
		getContentPane().add(btnEditar);
		
		btnVisualizar = new JButton("VISUALIZAR");
		btnVisualizar.addActionListener(this);
		btnVisualizar.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/visionario.png")));
		btnVisualizar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnVisualizar.setBounds(364, 471, 182, 79);
		getContentPane().add(btnVisualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/basura.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnEliminar.setBounds(550, 471, 167, 79);
		getContentPane().add(btnEliminar);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/agente.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnAgregar.setBounds(10, 471, 167, 79);
		getContentPane().add(btnAgregar);
		
		i3 = new JLabel("");
		i3.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/bienes.png")));
		i3.setBounds(753, 359, 147, 163);
		getContentPane().add(i3);
		
		i2 = new JLabel("");
		i2.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/punto-de-venta.png")));
		i2.setBounds(751, 204, 147, 163);
		getContentPane().add(i2);
		
		lblGestorDeVendedores = new JLabel("GESTOR DE VENDEDORES");
		lblGestorDeVendedores.setForeground(Color.WHITE);
		lblGestorDeVendedores.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.ITALIC, 23));
		lblGestorDeVendedores.setBounds(243, 22, 290, 41);
		getContentPane().add(lblGestorDeVendedores);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(this);
		scrollPane.setBounds(10, 90, 707, 370);
		getContentPane().add(scrollPane);
		
		tabla = new JTable();
		tabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabla);
		
		popupMenu = new JPopupMenu();
		addPopup(tabla, popupMenu);
		
		mnConvEmp = new JMenuItem("Convertir A Empleado");
		mnConvEmp.addActionListener(this);
		popupMenu.add(mnConvEmp);
		
		btnVerPersonas = new JButton("");
		btnVerPersonas.addActionListener(this);
		btnVerPersonas.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/comercio.png")));
		btnVerPersonas.setBounds(747, 36, 147, 145);
		getContentPane().add(btnVerPersonas);

		CargarTabla();
		
		
	}
	public void CargarTabla() {
		Estado = "Empleado";
		lblGestorDeVendedores.setText("Gestor de Vendedores");
		String Columnas[] = {"DNI_Emp", "ID_Emp", "Puesto", "Nombre", "Apellido"};
		
		ObjNEmp = new NgcEmpleado();
		ListaEmp = ObjNEmp.Lista();
		
		
		
		
		String Filas[][] = new String[ListaEmp.size()][5];
		for (int i = 0; i < ListaEmp.size(); i++) {
			ObjEmp = ListaEmp.get(i);
			
			ObjNPer = new NgcPersona();
			ObjPer = ObjNPer.BuscarDNI(ObjEmp.getDni_Persona());
			
			
			Filas[i][0] =  String.valueOf(ObjEmp.getDni_Persona());
			Filas[i][1] = ObjEmp.getID_Emp();
			Filas[i][2] = String.valueOf(ObjEmp.getPuesto());
			Filas[i][3] = String.valueOf(ObjPer.getNombrePersona());
			Filas[i][4] = String.valueOf(ObjPer.getApellidosPersona());
		}
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == mnConvEmp) {
			actionPerformedmnConvEmp(e);
		}
		if (e.getSource() == btnVerPersonas) {
			
			if( cont == 0 ) {
				CargarTablaPersonas();
				cont = 1;
			}else if(cont == 1) {
				CargarTabla();
				cont = 0;
			}
			
		}
		if (e.getSource() == btnVisualizar) {
			actionPerformedBtnVisualizar(e);
		}
	}
	protected void actionPerformedBtnVisualizar(ActionEvent e) {
		
		String code = "";
		String textoguia = "Ingrese DNI o ID del Empleado";
		NgcEmpleado nEmp = new NgcEmpleado();
		try {
			code = JOptionPane.showInputDialog(this, textoguia,"Vizualisar",-1);
			if (code != null) {
				try {
					if (code.matches("[0][0][0]")) {//Codigo especial para regresar a la tabla principal
						CargarTabla();
						
					}else if(code.matches("\\d{8}")){	
						ObjEmp = nEmp.BuscarDNI(Integer.parseInt(code));
						CargarTabla2(ObjEmp);
					}else if(code.matches("\\d{3}")){
						
						ObjEmp = nEmp.BuscarID(code);
						CargarTabla2(ObjEmp);
						
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Codigo o ID no valido");
				}
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ID o DNI no existe");
		}

	}
	
	
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int i = tabla.getSelectedRow();
			if ( i == -1) {
				throw new Exception();
			}
			try {
				if (Estado.equals("Empleado")) {
					NgcEmpleado nEmp = new NgcEmpleado();
					
					ObjEmp =  nEmp.Lista().get(i);
					int flag1 = JOptionPane.showConfirmDialog( null, "¿Desea Eliminar", "Alerta", 0);
					if (flag1 == 0) {
						nEmp.Eliminar( ObjEmp.getID_Emp());
						JOptionPane.showMessageDialog(null, "Vendedor Eliminado");
						CargarTabla();
					
					}
					
				}else if(Estado.equals("Persona")){
					
					NgcPersona nPer = new NgcPersona();
					
					ObjPer = nPer.Lista().get(i);
					int flag2 = JOptionPane.showConfirmDialog( null, "¿Desea Eliminar", "Alerta", 0);
					
					if (flag2 == 0) {

						int dniPer  =ObjPer.getDni_Persona() ;
						nPer.Eliminar(dniPer);
						JOptionPane.showMessageDialog(null, "Persona Eliminado");
						CargarTablaPersonas();
					}
					
					

					
				}
				
				
				
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}

		
		
		
	}
	
	
	public void CargarTabla2(Empleado Emp) {
		Estado = "Empleado";
		String Columnas[] = {"DNI_Emp", "ID_Emp", "Puesto", "Nombre", "Apellido"};
		ObjNEmp = new NgcEmpleado();
		ObjNPer = new NgcPersona();
		ListaEmp = ObjNEmp.Lista();
		ObjPer = ObjNPer.BuscarDNI(Emp.getDni_Persona());
		String Filas[][] = new String[1][5];
		
		Filas[0][0] =  String.valueOf(Emp.getDni_Persona());
		Filas[0][1] = Emp.getID_Emp();
		Filas[0][2] = String.valueOf(Emp.getPuesto());
		Filas[0][3] = String.valueOf(ObjPer.getNombrePersona());
		Filas[0][4] = String.valueOf(ObjPer.getApellidosPersona());
		
		MiModelo = new DefaultTableModel(Filas, Columnas);
		tabla.setModel(MiModelo);
	}
	
	public void CargarTablaPersonas() {
		Estado = "Persona";
		lblGestorDeVendedores.setText("Gestor de Personas");
		
		String Columnas[] = {"Dni_Persona", "Nombre", "Apellido","Correo","Edad"};
		ObjNPer = new NgcPersona();
		ObjNEmp = new NgcEmpleado();
		objNAdm = new NgcAdmin();
		
		ListaPer = ObjNPer.Lista();
		String Filas[][] = new String[ListaPer.size()][5];
		int aux = 0;
		
		for (int i = 0; i < ListaPer.size(); i++) {
			
			int DNI =  ListaPer.get(i).getDni_Persona();
			
			if ( (ObjNEmp.BuscarDNI(DNI) == null) &&  (objNAdm.BuscarDNI( DNI) == null )) {
				Filas[aux][0] = String.valueOf(ListaPer.get(i).getDni_Persona());
				Filas[aux][1] = String.valueOf(ListaPer.get(i).getNombrePersona());
				Filas[aux][2] = String.valueOf(ListaPer.get(i).getApellidosPersona());
				Filas[aux][3] = String.valueOf(ListaPer.get(i).getCorreo());
				Filas[aux][4] = String.valueOf(ListaPer.get(i).getEdad());


				aux++;
			}
			
		}
		DefaultTableModel MiModelo = new DefaultTableModel(Filas, Columnas);
		
		tabla.setModel(MiModelo);

		

	}

	protected void actionPerformedmnConvEmp(ActionEvent e) {
		try {
			int fila = tabla.getSelectedRow();
			try {
				int dniPersona = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
				
				if (ObjNEmp.BuscarDNI(dniPersona) == null) {

					FrmConvertirEmpleado ce = new FrmConvertirEmpleado(dniPersona);
					ce.setLocationRelativeTo(getContentPane());
					ce.setVisible(true);
					
					CargarTablaPersonas();
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Ya es un Empleado");
				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No existen valores en ese campo");
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Seleccione una fila ");
		}
		
		
		
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					System.out.println("hola");
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
			

		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	
	

	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		FrmCrearNuevaCuenta cnc = new FrmCrearNuevaCuenta();
		cnc.setLocationRelativeTo(getContentPane());
		cnc.setVisible(true);
		
		
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
	
															
		FrmEditarVendedor ev = new FrmEditarVendedor();
		ev.setLocationRelativeTo(getContentPane());
		ev.setVisible(true);
		
		CargarTabla();
		
	
	}
}
