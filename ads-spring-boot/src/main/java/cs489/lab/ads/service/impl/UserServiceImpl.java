package cs489.lab.ads.service.impl;

import cs489.lab.ads.model.User;
import cs489.lab.ads.repository.UserRepository;
import cs489.lab.ads.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
