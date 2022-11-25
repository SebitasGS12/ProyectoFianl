package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.RGBColor;

import java.awt.Toolkit;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

public class GestorProducto extends JDialog implements MouseListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panelMenu;
	private JLabel lblMenuPrincipal;
	private JButton btnAgregarProducto;
	private JButton btnEditarProducto;
	private JButton btnExportarDatos;
	private static int Dni ; 
	private JButton btneliminarproducto;
	private JButton btnbuscarproducto;
	private JScrollPane scrollPane;
	private JTable table;
	
	
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
	public GestorProducto(int dni) {
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
		lblMenuPrincipal.setBounds(20, 24, 147, 111);
		
		lblMenuPrincipal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				dispose();
				MenuPrincipal mp = new MenuPrincipal(dni);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
			}
		
		});
		
		panel.add(lblMenuPrincipal);
		
		panelMenu = new JPanel();
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
		btnEditarProducto.setBounds(223, 11, 169, 83);
		panelMenu.add(btnEditarProducto);
		
		btnExportarDatos = new JButton("<html>Exportar<br>Datos</html>");
		btnExportarDatos.setIcon(new ImageIcon(GestorProducto.class.getResource("/img/imgExportarDatos.png")));
		btnExportarDatos.setHorizontalAlignment(SwingConstants.LEFT);
		btnExportarDatos.setFocusable(false);
		btnExportarDatos.setBounds(808, 11, 169, 83);
		panelMenu.add(btnExportarDatos);
		
		btneliminarproducto = new JButton("<html>Eliminar<br>Producto</html>");
		btneliminarproducto.setIcon(new ImageIcon(GestorProducto.class.getResource("/img/btnEliminarProducto .png")));
		btneliminarproducto.setHorizontalAlignment(SwingConstants.LEFT);
		btneliminarproducto.setFocusable(false);
		btneliminarproducto.setBounds(417, 11, 169, 83);
		panelMenu.add(btneliminarproducto);
		
		btnbuscarproducto = new JButton("<html>Buscar<br>Producto</html>");
		btnbuscarproducto.setIcon(new ImageIcon(GestorProducto.class.getResource("/img/btnBuscar.png")));
		btnbuscarproducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnbuscarproducto.setFocusable(false);
		btnbuscarproducto.setBounds(612, 11, 186, 83);
		panelMenu.add(btnbuscarproducto);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 117, 987, 533);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblMenuPrincipal) {
			mouseClickedLblMenuPrincipal(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == btnAgregarProducto) {
			mouseReleasedBtnNewButton(e);
		}
	}
	protected void mouseClickedLblMenuPrincipal(MouseEvent e) {
		
		//Primero verifcar si desea guardar los datos 
		//Evitar que queden Dialogos abiertos
		//Cerrar el menu
		
		
		dispose();
	}
	protected void mouseReleasedBtnNewButton(MouseEvent e) {
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEditarProducto) {
			actionPerformedBtnEditarProducto(e);
		}
		if (e.getSource() == btnAgregarProducto) {
			actionPerformedBtnAgregarProducto(e);
		}
	}
	protected void actionPerformedBtnAgregarProducto(ActionEvent e) {
	}
	protected void actionPerformedBtnEditarProducto(ActionEvent e) {
	}
}
