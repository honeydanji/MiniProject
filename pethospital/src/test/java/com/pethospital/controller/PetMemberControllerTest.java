package com.pethospital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pethospital.componets.ObjectConversion;
import com.pethospital.service.PetMemberService;
import com.pethospital.vo.MemberRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest(PetMemberController.class)
public class PetMemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetMemberService memberService;
    @MockBean
    private ObjectConversion objectConversion;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("[정상]회원등록 테스트")
    @WithMockUser
    public void registerHttpTest() throws Exception {

        MemberRequest petMemberRequest = new MemberRequest();
        petMemberRequest.setName("Test");
        petMemberRequest.setNickname("Test1234");
        petMemberRequest.setUserId("Test1234");
        petMemberRequest.setPassword("123456789");
        petMemberRequest.setEmail("Test3680@naver.com");

        mockMvc.perform(MockMvcRequestBuilders.post("/user-service/register")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(petMemberRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("회원가입을 축하드립니다."));
    }
}
