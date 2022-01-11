import java.io.Serializable;
import java.net.InetSocketAddress;

public class Respuesta implements Serializable{

	private int tipo;
	private InetSocketAddress direccionRespuesta;
	String mensaje;

	public Respuesta(int tipo) {
		this.tipo = tipo;
	}

	public Respuesta(int tipo, String mensaje) {
		this.tipo = tipo;
		this.mensaje = mensaje;
	}

	public Respuesta(int tipo, InetSocketAddress direccionRespuesta) {
		this.tipo = tipo;
		this.direccionRespuesta = direccionRespuesta;
	}

	public int getTipo() {

		return this.tipo;
	}

	public String getMensaje() {

		return this.mensaje;
	}
	
	public InetSocketAddress getDireccionRespuesta() {
		
		return this.direccionRespuesta;
	}

}
