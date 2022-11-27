package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GestorInventario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSalir;
	private static int Dni; 

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
		setBounds(100, 100, 1200,700);
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
		
		lblSalir = new JLabel("");
		lblSalir.setIcon(new ImageIcon(GestorVendedores.class.getResource("/img/regresar_Menu.png")));
		lblSalir.setBounds(0, 0, 1184, 661);
		lblSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				MenuPrincipal mp = new MenuPrincipal(code);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
			}
		});
		getContentPane().add(lblSalir);
	}
}
