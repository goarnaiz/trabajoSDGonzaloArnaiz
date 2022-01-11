import java.io.Serializable;
import java.net.InetSocketAddress;

public class Peticion implements Serializable{
	
	private int tipo;
	private String nombreEnChat;
	private InetSocketAddress direccionRespuesta;
	
	public Peticion(int tipo, String nombreEnChat) {
		this.tipo=tipo;
		this.nombreEnChat=nombreEnChat;
	}
	
	public int getTipo() {
		
		return this.tipo;
	}
	
	public String getNombre() {
		
		return this.nombreEnChat;
	}
	
	

}
