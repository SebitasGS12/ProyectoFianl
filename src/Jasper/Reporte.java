package Jasper;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class Reporte extends JDialog {
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/bd_gci";
	private String Usuario = "root";
	private String Clave = "mysql";
	private static Connection cn; // Conexión Java - MySQL
	private Statement cmd; // Comando SQL
	private ResultSet rs; // Contenedor de filas
	private CallableStatement pa; // Uso de Store Procedure
	protected static String rutap;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte dialog = new Reporte(rutap);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog."src/Jasper/ReporteInventario.jasper"
	 */
	public Reporte(String ruta) {
		setModal(true);
		setTitle("Reportes");
		setBounds(50, 50,900,600);
		try {
			Class.forName(Driver);
			cn = DriverManager.getConnection(URL, Usuario, Clave);
			JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(ruta);
			JasperPrint jp = JasperFillManager.fillReport(jr, null,cn);
			
			getContentPane().add(new JRViewer(jp));
			cn.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
