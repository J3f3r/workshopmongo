package com.jeferson.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jeferson.workshopmongo.models.dto.PostDTO;
import com.jeferson.workshopmongo.models.dto.UserDTO;
import com.jeferson.workshopmongo.models.entities.User;
import com.jeferson.workshopmongo.repositories.UserRepository;
import com.jeferson.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	private final UserRepository userRepository;

	UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<UserDTO> findAll(){
		List<User> list = userRepository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	public UserDTO findById(String id) {
		User entity = getEntityById(id);
		return new UserDTO(entity);
	}
	
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity = userRepository.insert(entity);
		return new UserDTO(entity);
	}
	
	public UserDTO update(String id, UserDTO dto) {
		User entity = getEntityById(id);
		copyDtoToEntity(dto, entity);
		entity = userRepository.save(entity);
		return new UserDTO(entity);
	}
	
	public void delete(String id) {
		getEntityById(id);
		userRepository.deleteById(id);
	}
	
	public List<PostDTO> getUserPosts(String id){
		User user = getEntityById(id);
		return user.getPosts().stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}

	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
	}
	
	private User getEntityById(String id) {// é chamado no findById e no update
		Optional<User> result = userRepository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
	}
}
