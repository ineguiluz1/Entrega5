package Entrega_5;

import java.io.File;
import java.util.HashMap;
import java.util.*;

public class GestionTwitter  {

	//Atributos de la clase
	
	private static HashMap<String, Usuario_Twitter > mUsuariosPorId;
	private static HashMap<String, Usuario_Twitter> mUsuariosPorNick;
	private static TreeSet<Usuario_Twitter> treeSet;
	
	public static void main(String[] args) {
		try {
			// TODO Configurar el path y ruta del fichero a cargar
			String fileName = "data3.csv";
			mUsuariosPorId = new HashMap<>();
			mUsuariosPorNick = new HashMap<>();
			CSV.processCSV( new File( fileName ) );
			crearMapaUsuariosPorNick();
			
			//System.out.println(GestionTwitter.getmUsuariosPorId());
			//System.out.println(GestionTwitter.getmUsuariosPorNick());
			mostrarConAmigosEnSistema();
			crearTreeSet();
			
			
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
	
	public static void crearMapaUsuariosPorNick() {
		
		HashMap<String, Usuario_Twitter> mapUsN = new HashMap<>();
		for (String s : mUsuariosPorId.keySet()) {
			mapUsN.put(mUsuariosPorId.get(s).getScreenName(), mUsuariosPorId.get(s));
		}
		mUsuariosPorNick = mapUsN;
		
	}
	
	public static void mostrarConAmigosEnSistema() {
		int contador = 0;
		ArrayList<String> nicks = new ArrayList<>(mUsuariosPorNick.keySet());
		Collections.sort(nicks);
		for (String s : nicks) {
			Usuario_Twitter uT = mUsuariosPorNick.get(s);
			contador = contarAmigos(uT);
			if(contador > 0) {
				System.out.println( s + " tiene " + (uT.getFriendsCount()-contador) + "amigos fuera del sistema y " + contador + " amigos en el sistema");
			}
		}
		
	}
	
	public static int contarAmigos(Usuario_Twitter uT) {
		int amigos = 0;
		for (String usuario: uT.getFriends()) {
			if(mUsuariosPorId.get(usuario) != null) {
				amigos++;
			}
		}
		return amigos;
	}

	public static void crearTreeSet() {
		TreeSet<Usuario_Twitter> tOrdenado =  new TreeSet<Usuario_Twitter>();
		for (String s: mUsuariosPorId.keySet()) {
			Usuario_Twitter uT = mUsuariosPorId.get(s);
			if(contarAmigos(uT) > 0) {
				tOrdenado.add(uT);
			}
		}
		System.out.println(tOrdenado);
	}
	public static void usuOrd() {
		for(Usuario_Twitter uT : treeSet) {
			System.out.println(uT);
		}
	}
	
}
