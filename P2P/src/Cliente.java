import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Cliente implements Runnable {
	
	private Socket socket;
	private Thread hilo;
	private ObjectInputStream dis;
	private ObjectOutputStream dos;
	private Peticion peticion;
	private Respuesta respuesta;
	private static HashMap<String, InetSocketAddress> tablaClientes =new HashMap<>();
	
	public Cliente(Socket socket) {
		this.socket=socket;
	}
	
	public void run() {
		
		try {
			peticion= (Peticion) dis.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(peticion!=null) {
			
			int tipoPeticion=peticion.getTipo();
			 //Según el tipo de petición la aplicación hará lo que determine
			
			String nombreChat=peticion.getNombre();
			InetSocketAddress direccion=tablaClientes.get(nombreChat);
			respuesta=new Respuesta(0, direccion);
		}
		
		if(respuesta!=null) {
			//manda respuesta
			try {
				dos.writeObject(respuesta);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	public synchronized void empezar() {
		
		try(Socket s=new Socket("localhost",6666);
				ObjectInputStream dis=new ObjectInputStream(s.getInputStream());
				 ObjectOutputStream dos=new ObjectOutputStream(s.getOutputStream());){
			
			hilo=new Thread(new Cliente(s));
			hilo.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void parar() {
		
		if(hilo!=null) {
			try {
				hilo.interrupt();
				hilo=null;
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
				
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
