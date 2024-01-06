package com.pethospital.componets;

import com.pethospital.domain.MemberEntity;
import com.pethospital.dto.MemberDto;
import com.pethospital.vo.MemberRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class ObjectConversion {

    public MemberDto memberRequestToDto(MemberRequest memberRequest) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(memberRequest, MemberDto.class);
    }

    public MemberEntity memberDtoToEntity(MemberDto memberDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(memberDto, MemberEntity.class);
    }

}
