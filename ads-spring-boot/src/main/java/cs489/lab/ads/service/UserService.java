package cs489.lab.ads.service;

import cs489.lab.ads.dto.UserRequest;
import cs489.lab.ads.dto.UserResponse;
import cs489.lab.ads.exception.DuplicateUserException;
import cs489.lab.ads.exception.NotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserResponse createDentist(UserRequest userRequest) throws DuplicateUserException;
    UserResponse createPatient(UserRequest userRequest) throws DuplicateUserException;
    UserResponse createManager(UserRequest userRequest) throws DuplicateUserException;
}
