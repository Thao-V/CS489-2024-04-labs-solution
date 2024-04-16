package cs489.lab.ads.controller;

import cs489.lab.ads.dto.UserRequest;
import cs489.lab.ads.dto.UserResponse;
import cs489.lab.ads.exception.DuplicateUserException;
import cs489.lab.ads.service.UserService;
import cs489.lab.ads.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_VERSION + "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-dentist")
    public ResponseEntity<UserResponse> createDentist(@RequestBody @Valid UserRequest userRequest) throws DuplicateUserException {
        var userResponse = userService.createDentist(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @PostMapping("/create-manager")
    public ResponseEntity<UserResponse> createManager(@RequestBody @Valid UserRequest userRequest) throws DuplicateUserException {
        var userResponse = userService.createManager(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @PostMapping("/create-patient")
    public ResponseEntity<UserResponse> createPatient(@RequestBody @Valid UserRequest userRequest) throws DuplicateUserException {
        var userResponse = userService.createPatient(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
