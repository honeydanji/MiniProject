package com.pethospital.service;

import com.pethospital.dto.PetMemberDto;
import com.pethospital.vo.PetMemberRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class ObjectConversion {
    public PetMemberDto requestToDto(PetMemberRequest memberRequest) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(memberRequest, PetMemberDto.class);
    }
}
