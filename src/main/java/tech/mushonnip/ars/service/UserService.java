package tech.mushonnip.ars.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.mushonnip.ars.model.User;
import tech.mushonnip.ars.repos.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> mapToDTO(user, new User()))
                .collect(Collectors.toList());
    }

    public User get(final Long id) {
        return userRepository.findById(id)
                .map(user -> mapToDTO(user, new User()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public Long create(final User userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final User userDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private User mapToDTO(final User user, final User userDTO) {
        userDTO.setId(user.getId());
        return userDTO;
    }

    private User mapToEntity(final User userDTO, final User user) {
        return user;
    }

}
