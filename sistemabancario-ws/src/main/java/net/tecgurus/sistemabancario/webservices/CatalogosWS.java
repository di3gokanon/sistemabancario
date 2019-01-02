/**
 * 
 */
package net.tecgurus.sistemabancario.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.tecgurus.sistemabancario.data.UsuarioDAO;
import net.tecgurus.sistemabancario.entities.Login;
import net.tecgurus.sistemabancario.entities.Usuario;

/**
 * @author TecGurus
 *
 */
@WebService
@Component("catalogosWS")
public class CatalogosWS {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@WebMethod
	public String mostrarMensaje(@WebParam(name="mensaje") String mensaje) {
		return mensaje;
	}
	
	@WebMethod
	public Login consultarUsuario(
			@WebParam(name="username") String usuario, 
			@WebParam(name="password") String password) throws Exception {
		
		return this.usuarioDAO.consultar(usuario, password);
	}
}
