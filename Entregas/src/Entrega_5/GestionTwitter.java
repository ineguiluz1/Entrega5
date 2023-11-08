package Entrega_5;

import java.io.File;
import java.util.HashMap;
import java.util.*;

public class GestionTwitter {

	//Atributos de la clase
	
	private static HashMap<String, Usuario_Twitter > mUsuariosPorId;
	private static HashMap<String, Usuario_Twitter> mUsuariosPorNick;
	
	public static void main(String[] args) {
		try {
			// TODO Configurar el path y ruta del fichero a cargar
			String fileName = "data3.csv";
			mUsuariosPorId = new HashMap<>();
			mUsuariosPorNick = new HashMap<>();
			CSV.processCSV( new File( fileName ) );
			System.out.println(GestionTwitter.getmUsuariosPorId());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HashMap<String, Usuario_Twitter> getmUsuariosPorId() {
		return mUsuariosPorId;
	}

	public static void setmUsuariosPorId(HashMap<String, Usuario_Twitter> mUsuariosPorId) {
		GestionTwitter.mUsuariosPorId = mUsuariosPorId;
	}

	public static HashMap<String, Usuario_Twitter> getmUsuariosPorNick() {
		return mUsuariosPorNick;
	}

	public static void setmUsuariosPorNick(HashMap<String, Usuario_Twitter> mUsuariosPorNick) {
		GestionTwitter.mUsuariosPorNick = mUsuariosPorNick;
	}
	
	public void crearMapaUsuariosPorNick( HashMap<String, Usuario_Twitter> mUsuariosPorNick ) {
		
	}
	
}
