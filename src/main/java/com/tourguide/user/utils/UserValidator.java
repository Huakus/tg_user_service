package com.tourguide.user.utils;

import com.tourguide.user.model.User;
import com.tourguide.user.repository.UserRepository;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    private final UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserValidatorSteps forUser(User user) {
        return new UserValidationStep(user);
    }

    public interface UserValidatorSteps {
        UserValidationStep checkUsernameIsUnique();
        UserValidationStep checkEmailIsUnique();
        UserValidationStep checkPasswordIsValid();
        UserValidationStep checkUsernameIsNotEmpty();
        // Add more methods as needed
    }

    public class UserValidationStep implements UserValidatorSteps {
        
        private User user;

        public UserValidationStep(User user) {
            this.user = user;
        }

        public UserValidationStep checkUsernameIsNotEmpty() {
            if (user.getUsername() == null || user.getUsername().isEmpty()) {
                throw new IllegalArgumentException("Username is required");
            }
            return this;
        }

        public UserValidationStep checkUsernameIsUnique() {
            if (userRepository.findByUsername(user.getUsername()) != null) {
                throw new IllegalArgumentException("Username is already in use");
            }
            return this;
        }

        public UserValidationStep checkEmailIsNotEmpty() {
            if (user.getEmail() == null || user.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Email is required");
            }
            return this;
        }

        public UserValidationStep checkEmailIsUnique() {
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new IllegalArgumentException("Email is already in use");
            }
            return this;
        }

        public UserValidationStep checkPasswordIsValid() {
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Password is required");
            }

            if (user.getPassword().length() < 8 || user.getPassword().length() > 20) {
                throw new IllegalArgumentException("Password must be between 8 and 20 characters");
            }

            if (!Pattern.matches(".*[A-Z].*", user.getPassword())) {
                throw new IllegalArgumentException("Password must contain at least one uppercase letter");
            }

            if (!Pattern.matches(".*[a-z].*", user.getPassword())) {
                throw new IllegalArgumentException("Password must contain at least one lowercase letter");
            }

            if (!Pattern.matches(".*[0-9].*", user.getPassword())) {
                throw new IllegalArgumentException("Password must contain at least one digit");
            }

            if (!Pattern.matches(".*[^A-Za-z0-9 ].*", user.getPassword())) {
                throw new IllegalArgumentException("Password must contain at least one special character");
            }
            
            return this;
        }
    }
}
