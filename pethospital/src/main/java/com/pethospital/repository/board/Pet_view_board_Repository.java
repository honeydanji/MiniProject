package com.pethospital.repository.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pethospital.domain.board.Pet_view_board;

public interface Pet_view_board_Repository extends JpaRepository<Pet_view_board, Integer> {
	
	// // 좋아요순 게시글 반환
	// @Query("SELECT * FROM Combined_Boards ORDER BY likes DESC LIMIT 6")
    // List<Pet_view_board> findTopLikedPosts();
    
   @Query(value = "SELECT * FROM Combined_Boards ORDER BY likes DESC LIMIT 6", nativeQuery = true)
   List<Pet_view_board> findTopLikedPosts();
    
    // // 최신 게시글 5개
    // @Query("SELECT * FROM Combined_Boards ORDER BY regdate DESC LIMIT 5")
    // List<Pet_view_board> findRecentBoards();
    
   @Query(value = "SELECT * FROM Combined_Boards ORDER BY regdate DESC LIMIT 5", nativeQuery = true)
   List<Pet_view_board> findRecentBoards();
}
