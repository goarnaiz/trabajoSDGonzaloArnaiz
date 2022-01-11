import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<File> listaFicheros=new ArrayList<File>();
		
		try (ServerSocket server = new ServerSocket(6666);) {
			System.out.println("Servidor iniciado");
			
			while (true) {
				try (Socket s = server.accept();
						DataInputStream dis = new DataInputStream(s.getInputStream());
						DataOutputStream dos = new DataOutputStream(s.getOutputStream());) {
					
					System.out.println("Ha entrado " + s.getInetAddress());
					Cliente c=new Cliente(s);
					c.empezar();

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
