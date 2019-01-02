/**
 * 
 */
package net.tecgurus.sistemabancario.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.tecgurus.sistemabancario.entities.Login;

/**
 * @author TecGurus
 *
 */
@Repository
public class UsuarioDAO {
	
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	public Login consultar(String user, String password) throws Exception {
		//Se obtiene la sesion activa de la conexion.
		Session session = sessionFactory.getCurrentSession();

		//Forma 3: Obteniendo namedquery
		Query query = session.getNamedQuery("consultarUsuario");
		
		query.setParameter("user", user);
		query.setParameter("pass", password);
		
		Login login = (Login) query.uniqueResult();
		
		return login;
	}
	
	@Transactional(readOnly=true)
	public List<Login> consultar() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Login");
		
		List<Login> listaUsuarios = query.list();
		
		return listaUsuarios;
	}
	
	@Transactional
	public void guardarUsuario(Login login) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(login);

	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
