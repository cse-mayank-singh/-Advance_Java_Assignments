package com.example.demo.service;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.valueOf(request.getRole()));
        user.setAge(request.getAge());

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }
    @Override
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id)
                );

        return mapToResponse(user);
    }
    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id)
                );
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setRole(Role.valueOf(request.getRole()));
        user.setAge(request.getAge());

        User updatedUser = userRepository.save(user);

        return mapToResponse(updatedUser);
    }
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id)
                );

        userRepository.delete(user);
    }
    private UserResponseDTO mapToResponse(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setAge(user.getAge());
        return response;
    }
}