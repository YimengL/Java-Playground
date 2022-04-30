package com.example;

import com.example.controllers.LoginController;
import com.example.model.LoginProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTests {

    // We define the mock objects and inject them into the instance whose behavior we test.

    @Mock
    private Model model;

    @Mock
    private LoginProcessor loginProcessor;

    @InjectMocks
    private LoginController loginController;

    @Test
    public void loginPostLoginSucceedsTest() {
        // We control the LoginProcessor mock instance, telling it to return true when its method login() is called.
        given(loginProcessor.login()).willReturn(true);

        // We call the tested method with the given assumptions.
        String result = loginController.loginPost("username", "password", model);

        // We verify the tested method returned value
        assertEquals("login.html", result);

        // We verify the message attribute was added with the correct value on the model object.
        verify(model).addAttribute("message", "You are now logged in.");
    }

    @Test
    public void loginPostLoginFailsTest() {
        given(loginProcessor.login()).willReturn(false);

        String result = loginController.loginPost("username", "password", model);

        assertEquals("login.html", result);

        verify(model).addAttribute("message", "Login failed!");
    }
}
