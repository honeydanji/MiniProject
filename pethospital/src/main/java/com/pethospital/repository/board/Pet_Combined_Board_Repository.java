//package com.pethospital.repository.board;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.pethospital.domain.board.CombinedBoards;
//import com.pethospital.domain.board.Pet_view_board;
//
//public interface Pet_Combined_Board_Repository extends JpaRepository<CombinedBoards, Integer> {
//	
////	// 좋아요순 게시글 반환
////	@Query(value = "SELECT * FROM Combined_Boards ORDER BY likes DESC LIMIT 6", nativeQuery = true)
////    List<Pet_view_board> findTopLikedPosts();
////    
////    // 최신 게시글 5개
////    @Query(value = "SELECT * FROM Combined_Boards ORDER BY regdate DESC LIMIT 5", nativeQuery = true)
////    List<Pet_view_board> findRecentBoards();
//	
//	//List<CombinedBoards> findAllOrderByGoodDesc();
//	
//	//List<CombinedBoards> findAll(); // 쿼리메소드
//
//	@Query("SELECT c FROM CombinedBoards c ORDER BY good DESC LIMIT 6")//JPQL
//	List<CombinedBoards> test();
//	
//	
//
//}
