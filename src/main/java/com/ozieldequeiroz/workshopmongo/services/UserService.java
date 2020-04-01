package com.ozieldequeiroz.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.ozieldequeiroz.workshopmongo.domain.User;
import com.ozieldequeiroz.workshopmongo.repository.UserRepository;
import com.ozieldequeiroz.workshopmongo.services.exception.ObjectNotFoundException;
import com.ozieldequeiroz.workshopmongo.userdto.UserDTO;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO (UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}	
	
}
