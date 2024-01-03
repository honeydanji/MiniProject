//package com.pethospital.pethospital;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.pethospital.domain.Pet_member;
//import com.pethospital.domain.board.CombinedBoards;
//import com.pethospital.repository.Pet_member_Repository;
//import com.pethospital.repository.board.Pet_Combined_Board_Repository;
//
//@SpringBootTest
//class PethospitalApplicationTests {
//
//	@Autowired
//	Pet_member_Repository a;
//	
//	@Autowired
//	BCryptPasswordEncoder e;
//	
//	@Autowired
//	Pet_Combined_Board_Repository p;
//	
//	//@Test
//	void contextLoads() {
//		
//		a.save(Pet_member.builder()
//				.name("홍길동")
//				.userId("user")
//				.password(e.encode("abcd"))
//				.nickname("nick")
//				.email("a@b.com")
//				.address("부산")
//				.role("ROLE_MEMBER")
//				.build());
//		return ;
//	}
//
//	
//	@Test
//	void Pet_Combined_Board_Repository_test() {
//		List<CombinedBoards> list = p.test();
//		
//		System.out.println("size : " + list.size());
//		
//		for (CombinedBoards c : list) {
//			System.out.println(c);
//		}
//		
//	}
//}
