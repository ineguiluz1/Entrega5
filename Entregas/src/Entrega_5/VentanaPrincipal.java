package Entrega_5;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class VentanaPrincipal extends JFrame {

	
	private JFileChooser fCh;
	
	public VentanaPrincipal() {
		
		//Ajustes de la ventana
		
		setSize(new Dimension(750,650));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlElegirFichero = new JPanel();
		getContentPane().add(pnlElegirFichero, BorderLayout.WEST);
		pnlElegirFichero.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEligeFichero = new JLabel("Elige el fichero que quieres cargar:");
		pnlElegirFichero.add(lblEligeFichero, BorderLayout.NORTH);
		
		fCh = new JFileChooser(System.getProperty("C:/Users/Diego") + "/Desktop");
		fCh.setFileFilter(new FileNameExtensionFilter("Archivos y directorios del escritorio", "desktop", "csv"));
		pnlElegirFichero.add(fCh);
		int returnValue = fCh.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Obtenemos el objeto File seleccionado
            File selectedFile = fCh.getSelectedFile();
            try {
				CSV.processCSV(selectedFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // Obtenemos el nombre del fichero seleccionado
            String fileName = selectedFile.getName();

            System.out.println("Nombre del fichero seleccionado: " + fileName);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
		
		
	}
	
	public static void main(String[] args) {
		VentanaPrincipal vent = new VentanaPrincipal();
		vent.setVisible(true);
	}
	
}
