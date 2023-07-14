package ar.com.codoacodo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.codoacodo.domain.User;
import ar.com.codoacodo.repository.UserRepository;
import ar.com.codoacodo.service.UserServices;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServices {

	
	private final UserRepository repository;
	
	
	
	
	
	@Override
	public void crearUser(User user) {
			//aca va la logica del insert!!
			
		this.repository.save(user);
		//insert into tabla (c1,c2,cn) values (v1,v2,vn)
	}
	
	@Override
	public User buscarUser(Long id) {
		//select * from tablawhere id = id
		return this.repository.findById(id).get();
	
	}
	
	@Override
	public List<User> buscarTodos(){
		return this.repository.findAll();
	}

	@Override
	public User buscarUserPorUsername(String username) {
		// el findby es = select * from table where username = "username"
		return this.repository.findByUsername(username);
	}

	@Override
	public void eliminarUser(Long id) {
		
		this.repository.deleteById(id);
	}

	@Override
	public void actualizar(User user) {
		// TODO Auto-generated method stub
		
	}
}
