package Formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CapaNegocio.NgcEmpleado;
import Clases.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmConvertirEmpleado extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitulo;
	private NgcEmpleado nEmp;
	private JLabel lblNewLabel_2;
	private JTextField txtID;
	private JLabel lblNewLabel_3;
	private JButton btnConvertir;
	private JButton btnAyuda;
	private ArrayList<Empleado> ListaEmp;
	private static int dni;
	private JComboBox cboLetra;
	private JComboBox cboNumero;
	private String[] cboNumeroModel = new String[90];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmConvertirEmpleado dialog = new FrmConvertirEmpleado(dni);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param dniPersona 
	 */
	public FrmConvertirEmpleado(int dniPersona) {
		dni =dniPersona;
		nEmp = new NgcEmpleado();
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConvertirEmpleado.class.getResource("/img/ico.png")));
		setTitle("Convertir a Empleado");
		setModal(true);
		setBounds(100, 100, 304, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboNumero = new JComboBox();
		cboNumero.setBounds(202, 79, 76, 22);
		
		for (int i = 10; i < 100 ; i++) {
			cboNumeroModel[i-10] = (""+ i);
		}
		
		cboNumero.setModel(new DefaultComboBoxModel(cboNumeroModel));
		
		contentPanel.add(cboNumero);
		
		cboLetra = new JComboBox();
		cboLetra.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z"}));
		cboLetra.setBounds(128, 79, 61, 22);
		contentPanel.add(cboLetra);
		
		btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(10, 182, 78, 23);
		contentPanel.add(btnAyuda);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(this);
		btnConvertir.setBounds(94, 126, 95, 31);
		contentPanel.add(btnConvertir);
		
		lblNewLabel_3 = new JLabel("#Puesto");
		lblNewLabel_3.setBounds(10, 83, 108, 14);
		contentPanel.add(lblNewLabel_3);
		
		txtID = new JTextField(nEmp.CodigoAutogenerado());
		txtID.setEnabled(false);
		txtID.setBounds(128, 44, 150, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		lblNewLabel_2 = new JLabel("ID Empleado");
		lblNewLabel_2.setBounds(10, 47, 108, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblTitulo = new JLabel("\"Formulario de Empelado\"");
		lblTitulo.setForeground(new Color(255, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("HP Simplified", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 268, 17);
		contentPanel.add(lblTitulo);
		{
			JLabel lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(FrmConvertirEmpleado.class.getResource("/img/FondoBlanco.png")));
			lblFondo.setBounds(0, 0, 435, 426);
			contentPanel.add(lblFondo);
		}
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConvertir) {
			actionPerformedBtnConvertir(e);
		}
	}
	public boolean IdRepetido(String id) {
		
		nEmp = new NgcEmpleado();
		
		ListaEmp = nEmp.Lista();
		
		
		for (int i = 0; i < ListaEmp.size() ; i++) {
			if(  id.equals(ListaEmp.get(i).getID_Emp())  ) {
				return true; //porque existe
			}
		}
		return false;
	
	}
	
	protected void actionPerformedBtnConvertir(ActionEvent e) {
		
		
		
		
		try {
			String id = txtID.getText().trim();
			String puesto = cboLetra.getSelectedItem().toString().trim() + cboNumero.getSelectedItem().toString();
			puesto.trim();
			if (id.matches("\\d{3}") && puesto.matches("[A-Z][0-9]{2}")) {
				//Verificar Que el ID no se repita
				
				if( !IdRepetido(id)) {
					
					Empleado emp = new Empleado(id, puesto, dni);
					nEmp.Insertar(emp);
					JOptionPane.showMessageDialog(contentPanel,"Usuario Convertido en Empleado");
					dispose();
					
				}else{
					JOptionPane.showMessageDialog(contentPanel,"ID ya Existe");
				}

			}else {
				
				JOptionPane.showMessageDialog(contentPanel,"Verifica tus datos");
				
			}
			
			
		} catch (Exception e2) {

			JOptionPane.showMessageDialog(contentPanel,e2);
		}
		

		
		
		
	}
}
