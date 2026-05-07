package com.adrian.taskmanager.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.taskmanager.jpa.UserRepository;

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
			throw new UserNotFoundException("User not found:  " + id);
		}
		
		return user.get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found: " + id);
        }
        userRepository.deleteById(id);
    }
	
}
