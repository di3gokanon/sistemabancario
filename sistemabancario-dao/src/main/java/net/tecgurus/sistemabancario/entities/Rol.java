package net.tecgurus.sistemabancario.entities;
// Generated 23-dic-2017 11:01:38 by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Rol generated by hbm2java
 */
@Entity
@Table(name = "rol", catalog = "sistemabancario")
public class Rol implements java.io.Serializable {

	private Integer idrole;
	private String nombre;
	private String role;
	private Set<Usuariorol> usuariorols = new HashSet<Usuariorol>(0);

	public Rol() {
	}

	public Rol(String nombre, String role) {
		this.nombre = nombre;
		this.role = role;
	}

	public Rol(String nombre, String role, Set<Usuariorol> usuariorols) {
		this.nombre = nombre;
		this.role = role;
		this.usuariorols = usuariorols;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idrole", unique = true, nullable = false)
	public Integer getIdrole() {
		return this.idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	public Set<Usuariorol> getUsuariorols() {
		return this.usuariorols;
	}

	public void setUsuariorols(Set<Usuariorol> usuariorols) {
		this.usuariorols = usuariorols;
	}

}
