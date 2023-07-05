package com.tourguide.user.service;

import com.tourguide.user.controller.AuthenticationRequest;
import com.tourguide.user.controller.AuthenticationResponse;
import com.tourguide.user.controller.RegistrationRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegistrationRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
