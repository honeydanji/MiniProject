package com.pethospital.vo;

import jakarta.validation.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PetMemberRequestTest {

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
    @DisplayName("회원가입 요청 데이터에 이름이 null 인 경우")
    void nameValidTest() {
        PetMemberRequest petMemberRequest = new PetMemberRequest();
        // name is null
        petMemberRequest.setNickname("Test1234");
        petMemberRequest.setUserId("Test1234");
        petMemberRequest.setPassword("123456789");
        petMemberRequest.setEmail("Test3680@naver.com");

        Set<ConstraintViolation<PetMemberRequest>> violations = validator.validate(petMemberRequest);

        assertThat(violations).isNotNull();
        violations
                .forEach(error -> {
                    assertThat(error.getMessage()).isEqualTo("Name Cannot be null");
                });
    }

    @Test
    @DisplayName("닉네임이 null 인 경우")
    void nicknameValidTest() {
        PetMemberRequest petMemberRequest = new PetMemberRequest();
        petMemberRequest.setName("Test");
        // nickname is null
        petMemberRequest.setUserId("Test1234");
        petMemberRequest.setPassword("123456789");
        petMemberRequest.setEmail("Test3680@naver.com");

        Set<ConstraintViolation<PetMemberRequest>> violations = validator.validate(petMemberRequest);

        assertThat(violations).isNotNull();
        violations
                .forEach(error -> {
                    assertThat(error.getMessage()).isEqualTo("Nickname cannot be null");
                });
    }
}

// https://velog.io/@ayoung0073/springboot-annotation-valid 참고