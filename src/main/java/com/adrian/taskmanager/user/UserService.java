package com.adrian.taskmanager.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.taskmanager.jpa.UserRepository;
import com.adrian.taskmanager.user.dto.UserCreationRequest;
import com.adrian.taskmanager.user.dto.UserUpdateRequest;

@Service
public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() {
        return userRepository.findAll();
    }
	
	public User findById(int id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("User with ID " + id + " not found.");
		}
		
		return user.get();
    }

    public User save(UserCreationRequest request) {
        User user = new User(request.getUsername(), request.getPassword());
        return userRepository.save(user);
    }

    public void delete(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
        userRepository.deleteById(id);
    }

    public User updateUser(UserUpdateRequest request, int id) {
        Optional<User> existingUser = userRepository.findById(id);
        
        if (existingUser.isEmpty()) {
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
        
        User updatedUser = existingUser.get();
        if (request.getUsername() != null) {
            updatedUser.setUsername(request.getUsername());
        }
        if (request.getPassword() != null) {
            updatedUser.setPassword(request.getPassword());
        }
        
        return userRepository.save(updatedUser);
    }
}
