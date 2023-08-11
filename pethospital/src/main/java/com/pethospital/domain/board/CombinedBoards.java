//package com.pethospital.domain.board;
//
//import java.util.Date;
//
//import javax.annotation.concurrent.Immutable;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Immutable // 이 엔티티는 읽기 전용입니다 (뷰)
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Builder
//public class CombinedBoards {
//
//	private String source;
//	
//	@Id
//	private int id; // ID 열로 사용될 변수
//	private String userId;
//	private String nickname;
//	private String title;
//	private String content;
//	private Date regdate;
//	private Date updatedate;
//	private Date deletedate;
//	private String imagefile;
//	private int views;
//	private int good;
//
//}