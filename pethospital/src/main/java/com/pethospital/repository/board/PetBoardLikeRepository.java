package com.pethospital.repository.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethospital.domain.MemberEntity;
import com.pethospital.domain.board.PetBoardLike;
import com.pethospital.domain.board.PetFreeBoard;
import com.pethospital.domain.board.PetHoneyBoard;

public interface PetBoardLikeRepository extends JpaRepository<PetBoardLike, Integer>{

    // 해당 유저가 해당 게시글에 좋아요를 누른 레이블이 존재하는 가??? 를 판단하기 위함.
    PetBoardLike findByPetMemberAndPetFreeBoard(MemberEntity petMember, PetFreeBoard petFreeBoard);
    PetBoardLike findByPetMemberAndPetHoneyBoard(MemberEntity petMember, PetHoneyBoard petHoneyBoard);

    // 좋아요가 이미 있을 때
    void deleteByPetMemberAndPetFreeBoard(MemberEntity petMember, PetFreeBoard petFreeBoard);
    void deleteByPetMemberAndPetHoneyBoard(MemberEntity petMember, PetHoneyBoard petHoneyBoard);

    // 좋아요가 없을 때
    // ~~~.save()

    // 해당 계정이 "좋아요"누른 게시글 반환
    List<PetBoardLike> findByPetMemberAndPetFreeBoardIsNotNull(MemberEntity petMember);
    List<PetBoardLike> findByPetMemberAndPetHoneyBoardIsNotNull(MemberEntity petMember);

}
