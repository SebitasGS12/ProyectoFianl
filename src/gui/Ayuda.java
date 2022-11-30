package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Ayuda extends JDialog implements ActionListener {
	private JLabel lblCabecera;
	private JPanel panel;
	private JButton btnInfo;
	private JButton btnManual;
	private JLabel lblAcerca;
	private String informe = "https://docs.google.com/document/d/1IsFkbdC36UUa60VAIfYTm4hPXycoxhy4/edit?usp=sharing&ouid=109918201001160918039&rtpof=true&sd=true" ;
	private String  videoManual = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda dialog = new Ayuda();
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
	public Ayuda() {
		setTitle("Ayuda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/img/ico.png")));
		setModal(true);
		setBounds(100, 100, 509, 600);
		getContentPane().setLayout(null);
		
		lblCabecera = new JLabel("");
		lblCabecera.setIcon(new ImageIcon(Ayuda.class.getResource("/img/Cabecera.png")));
		lblCabecera.setToolTipText("");
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setForeground(Color.BLACK);
		lblCabecera.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCabecera.setBackground(new Color(102, 153, 51));
		lblCabecera.setBounds(0, 0, 493, 83);
		getContentPane().add(lblCabecera);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(217, 217, 217));
		panel.setBounds(0, 82, 160, 479);
		getContentPane().add(panel);
		
		btnInfo = new JButton("<html><p>Informacion General <br>del Programa</p></html>");
		btnInfo.addActionListener(this);
		btnInfo.setForeground(Color.LIGHT_GRAY);
		btnInfo.setBackground(new Color(255, 102, 102));
		btnInfo.setBounds(10, 29, 142, 77);
		panel.add(btnInfo);
		
		btnManual = new JButton("<html><p>Manual de<br> Programa</p></html>");
		btnManual.addActionListener(this);
		btnManual.setForeground(Color.LIGHT_GRAY);
		btnManual.setBackground(new Color(255, 102, 102));
		btnManual.setBounds(10, 134, 142, 70);
		panel.add(btnManual);
		
		lblAcerca = new JLabel("");
		lblAcerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcerca.setIcon(new ImageIcon(Ayuda.class.getResource("/img/ayuda_contacto.png")));
		lblAcerca.setBounds(170, 94, 311, 456);
		getContentPane().add(lblAcerca);
		
		

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnManual) {
			actionPerformedBtnManual(e);
		}
		if (e.getSource() == btnInfo) {
			actionPerformedBtnInfo(e);
		}
	}
	protected void actionPerformedBtnInfo(ActionEvent e) {
		try {
			
			URL url = new URL(informe);
			
			Desktop.getDesktop().browse(url.toURI());
			
		}catch (IOException | URISyntaxException e2) {
            e2.getMessage();
        }
			
		
		
	}
	protected void actionPerformedBtnManual(ActionEvent e) {
		
		try {
			
			URL url = new URL(videoManual);
			
			Desktop.getDesktop().browse(url.toURI());
			
		}catch (IOException | URISyntaxException e1) {
            e1.getMessage();
        }
		
		
		
	}
}
