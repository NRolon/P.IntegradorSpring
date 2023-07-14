package ar.com.codoacodo.service;

import java.util.List;

import ar.com.codoacodo.domain.User;

public interface UserServices {

	public void crearUser(User user);
	public User buscarUser(Long id);
	public List<User> buscarTodos();
	public User buscarUserPorUsername(String username);
	public void eliminarUser(Long id);
	public void actualizar(User user);
}