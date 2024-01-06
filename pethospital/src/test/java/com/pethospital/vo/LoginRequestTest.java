package com.pethospital.vo;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginRequestTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    public static void close() {
        factory.close();
    }

    @Test
    @DisplayName("로그인 요청 데이터 아이디가 비어있는 경우")
    void userIdValidTest() {
        LoginRequest login = new LoginRequest();
        login.setPassword("testtest");

        Set<ConstraintViolation<LoginRequest>> violations = validator.validate(login);

        assertThat(violations).isNotEmpty();
        violations
                .forEach(error -> {
                    assertThat(error.getMessage()).isEqualTo("userId cannot be empty");
                });
    }

    @Test
    @DisplayName("로그인 요청 데이터 비밀번호가 비어있는 경우")
    void passwordValidTest() {
        LoginRequest login = new LoginRequest();
        login.setUserId("test");

        Set<ConstraintViolation<LoginRequest>> violations = validator.validate(login);

        assertThat(violations).isNotEmpty();
        violations
                .forEach(error -> {
                    assertThat(error.getMessage()).isEqualTo("Password cannot be empty");
                });
    }
}
