package cs489.lab.ads.service;

import cs489.lab.ads.dto.UserRequest;
import cs489.lab.ads.dto.UserResponse;
import cs489.lab.ads.exception.DuplicateUserException;
import cs489.lab.ads.exception.NotFoundException;

public interface UserService{
    UserResponse createDentist(UserRequest userRequest) throws DuplicateUserException;
    UserResponse createPatient(UserRequest userRequest) throws DuplicateUserException;
    UserResponse createManager(UserRequest userRequest) throws DuplicateUserException;
}
