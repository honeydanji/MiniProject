# 전국 동물병원 검색 웹서비스

## 1. 프로젝트 구성도
<p align="center">
  <img src="https://github.com/honeydanji/MiniProject/assets/129818881/1cc552c7-7984-4b02-b1aa-48ee94171c39">
</p>

- IDE = VSCode
- JAVA = jdk 17.0.3
- StringBoot = 3.0.2
- Front : https://github.com/suho0815/bigdata_web_project01.git

## 2. 주요 기능
- 게시판 CRUD
- 게시글 "좋아요" 기능 구현
- 이미지 업로드 및 삭제
- JWT 로그인
- 동물병원 Modal 동적 검색
<img src="https://github.com/honeydanji/MiniProject/assets/129818881/bc5bfac3-ceb1-4b95-820e-0db5e56e7e0e"> 

## 3. 화면 구성
<p align="center">
  <img src="https://github.com/honeydanji/MiniProject/assets/129818881/29eb992b-a11b-4500-b1b9-9091a334b1b2">
</p>

## 4. 개발 과정
## MiniProject (All Notion)
>> https://www.notion.so/d22b745abe3a4f8daecef6357da12d8b

### RestFul API는 무엇 인가?? (2023/07/27)
>> https://www.notion.so/RestFul-API-cedc566c059745d8b33aa915efb2ebda?pvs=4

### 클라이언트 및 서버 연동 오류 (2023/07/27)
>> https://www.notion.so/8bfae60e8e7d4fa3aa698b9eb171a262?pvs=4

### Configuration 및 CORS 원리 (2023/07/28)
>> https://www.notion.so/Configuration-Origincloss-41d9fca058a64310b90fa506a00a5ebc?pvs=4

### 명령어 : “git stash”  (2023/07/28)
>> https://www.notion.so/git-stash-9219d9c663904a64a73cd93d13cfbcf7?pvs=4

### jdk와 jre 차이 (2023/07/30)
>> https://www.notion.so/jdk-jre-292ce24fe2de43c385fe64b81661e1bb?pvs=4

### JavaBean 명명규칙 (2023/07/30)
>> https://www.notion.so/JavaBean-07648d4d96704c19afe86660fa3bf0e5?pvs=4

### FOREING KEY 사용법 및 원리 (2023/07/31)
>> https://www.notion.so/FOREING-KEY-00c6dc8130d74cb0941289fe4a6d666c?pvs=4

### JWT + @Jsonignore (2023/08/01)
>> https://www.notion.so/JWT-Jsonignore-57d614e403ce434eb52f88ac951b1a98?pvs=4

### JPA 다대다 및 다대원 방식 (2023/08/04)
>> https://www.notion.so/JPA-5edb4cf29e634c83a8d0460535b5012f?pvs=4

### RequestParam과 ReqeustBody 차이는? (2023/08/05)
>> https://www.notion.so/RequestParam-ReqeustBody-c24647b2fa8a4679950f85894e49a4e2?pvs=4

### @Transactional은 무엇인가? (2023/08/06)
>> https://www.notion.so/Transactional-3d65808dd7a94aff842ecfc1575ce09a?pvs=4

## 5. 후기
- 원본데이터에 있는 위도, 경도가 정상값인지 확인하지 않아서 카카오지도 API를 사용하지 못했다...
- 동물병원에 관한 이미지데이터는 웹크롤링을 통해서 가져 오기로 했지만 그러지 못했다...
- 프로젝트를 기획할 때 가벼운 생각으로 했던 것이 원인이었고.. 데이터에 대한 의심을 하지 않은 것도 문제였다.
- 프로젝트를 진행중에 가장 중요한 3가지.
  1. 프로젝트 기획
  2. 데이터 분석
  3. 클라이언트와 서버간의 소통
