package cs489.lab.ads.service.impl;

import cs489.lab.ads.dto.UserRequest;
import cs489.lab.ads.dto.UserResponse;
import cs489.lab.ads.exception.DuplicateUserException;
import cs489.lab.ads.model.Dentist;
import cs489.lab.ads.model.Manager;
import cs489.lab.ads.model.Patient;
import cs489.lab.ads.repository.UserRepository;
import cs489.lab.ads.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createDentist(UserRequest userRequest) throws DuplicateUserException {
        var existingUser = userRepository.findUserByEmail(userRequest.email());
        if(existingUser != null){
            return null;
        }

        Dentist user = new Dentist();

        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setSpecialization(userRequest.specialization());
        var savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }

    @Override
    public UserResponse createPatient(UserRequest userRequest) throws DuplicateUserException {
        var existingUser = userRepository.findUserByEmail(userRequest.email());
        if(existingUser != null){
            return null;
        }

        Patient user = new Patient();

        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setDob(userRequest.dob());
        var savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }

    @Override
    public UserResponse createManager(UserRequest userRequest) throws DuplicateUserException {
        var existingUser = userRepository.findUserByEmail(userRequest.email());
        if(existingUser != null){
            return null;
        }
        Manager user = new Manager();
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setOfficePhoneNumber(userRequest.officePhoneNumber());
        var savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }
}
