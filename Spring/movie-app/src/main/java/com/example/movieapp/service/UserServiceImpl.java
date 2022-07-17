package com.example.movieapp.service;

import com.example.movieapp.mapper.User.UserDto;
import com.example.movieapp.mapper.User.UserMapper;
import com.example.movieapp.model.UserEntity;
import com.example.movieapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = new UserMapper();

    @Override
    public List<UserDto> findAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.getReferenceById(id));
    }

    @Override
    public UserDto create(UserDto dto) {
        if(dto.getUsername().isEmpty()) {
            throw new ServiceException("username can't be blank");
        }

        UserEntity entity = userMapper.toEntity(dto);
        UserEntity newUser = userRepository.save(entity);

        return userMapper.toDto(newUser);
    }

    @Override
    public UserDto update(UserDto dto) {
        if(dto.getUsername().isEmpty()) {
            throw new ServiceException("username can't be blank");
        }

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getId());
        if(userEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("User with the provided id wasn't found");
        }

        UserEntity updatedEntity = userMapper.toEntity(dto);
        UserEntity newUser = userRepository.save(updatedEntity);

        return userMapper.toDto(newUser);
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            throw new ServiceException("id can't be null");
        }

        Optional<UserEntity> userEntityOptional = userRepository.findById(id);

        if(userEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("User with the provided id wasn't found");
        }

        UserEntity userEntity = userEntityOptional.get();

        userRepository.delete(userEntity);
    }
}
