package com.pethospital.componets;

import com.pethospital.domain.PetMember;
import com.pethospital.dto.PetMemberDto;
import com.pethospital.vo.MemberRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class ObjectConversion {

    public PetMemberDto memberRequestToDto(MemberRequest memberRequest) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(memberRequest, PetMemberDto.class);
    }

    public PetMember memberDtoToEntity(PetMemberDto memberDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(memberDto, PetMember.class);
    }

}
