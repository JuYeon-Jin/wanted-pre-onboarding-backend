

### 프로젝트 정보
<br>

> 기업의 채용을 위한 웹 서비스입니다. 이 서비스는 회사가 채용 공고를 생성하고, 사용자가 해당 공고에 지원하는 기능을 제공합니다.
> Java & Spring 을 기반으로 개발하였으며 MyBatis 를 이용하여 DB 인 MySQL 과 연동됩니다.

<br><br>

### 프로젝트 디렉토리 구
<br>

```
┌── config/
│   └── MyBatisConfig.java
├── controller/
│   └── ApplyController.java
├── dao/
│   └── ApplyDao.java
├── dto/
│   ├── ApplyDto.java
│   ├── CompanyPostsDto.java
│   ├── InsertPostDto.java
│   ├── ReadPostDto.java
│   ├── ReadPostsDto.java
│   └── UpdatePostDto.java
└── service/
    └── ApplyService.java
```

<br><br>

config/MyBatisConfig.java:
MyBatis 설정 파일로, 데이터베이스와 MyBatis 간의 연동을 설정합니다.

controller/ApplyController.java:
사용자의 요청을 받아 서비스 레이어에 전달하고, 결과를 반환하는 컨트롤러 클래스입니다.

dao/ApplyDao.java:
데이터베이스와 직접적으로 소통하는 DAO 클래스입니다. SQL 쿼리를 사용하여 데이터를 조회, 삽입, 수정, 삭제하는 기능을 담당합니다.

dto/:
ApplyDto.java: 지원자의 데이터를 전달하기 위한 DTO 클래스입니다.
CompanyPostsDto.java: 회사의 공고 데이터를 전달하기 위한 DTO 클래스입니다.
InsertPostDto.java: 새 공고를 삽입할 때 사용되는 DTO 클래스입니다.
ReadPostDto.java: 특정 공고를 조회할 때 사용되는 DTO 클래스입니다.
ReadPostsDto.java: 여러 공고를 조회할 때 사용되는 DTO 클래스입니다.
UpdatePostDto.java: 기존 공고를 수정할 때 사용되는 DTO 클래스입니다.

service/ApplyService.java:
비즈니스 로직을 담당하는 서비스 클래스입니다. 컨트롤러에서 받은 요청을 처리하여 DAO와 상호작용하며, 필요한 비즈니스 로직을 수행합니다.

***

<br>

### 02 기능

#### 🔗Assignment 1
#### 🔗Assignment 2
#### 🔗Assignment 3


주요 기능
채용 공고 등록

설명: 새로운 채용 공고를 등록합니다.
HTTP 메소드: POST
엔드포인트: /posts
요청 데이터: InsertPostDto (등록할 채용 공고의 정보를 담고 있음)
응답: 등록된 채용 공고 정보를 담은 ResponseEntity<?>
오류 처리: 예외 발생 시, HttpStatus.BAD_REQUEST로 상태 코드와 함께 "실패" 메시지를 반환합니다.
채용 공고 수정

설명: 기존의 채용 공고를 수정합니다.
HTTP 메소드: PUT
엔드포인트: /posts
요청 데이터: UpdatePostDto (수정할 채용 공고의 정보를 담고 있음)
응답: 수정된 채용 공고 정보를 담은 ResponseEntity<?>
오류 처리: 예외 발생 시, HttpStatus.BAD_REQUEST로 상태 코드와 함께 "실패" 메시지를 반환합니다.
채용 공고 삭제

설명: 특정 채용 공고를 삭제합니다.
HTTP 메소드: DELETE
엔드포인트: /posts/{postId}
요청 데이터: postId (삭제할 채용 공고의 ID)
응답: 삭제 결과를 담은 ResponseEntity<?>
오류 처리: 예외 발생 시, HttpStatus.BAD_REQUEST로 상태 코드와 함께 "실패" 메시지를 반환합니다.
채용 공고 목록 조회

설명: 전체 채용 공고 목록을 조회하거나, 검색어를 사용하여 특정 공고를 검색합니다.
HTTP 메소드: GET
엔드포인트: /posts
요청 데이터: search (선택 사항, 검색어가 주어지면 해당 검색어가 포함된 공고를 조회)
응답: 조회된 채용 공고 목록을 담은 ResponseEntity<?>
채용 공고 상세 정보 조회

설명: 특정 채용 공고의 상세 정보를 조회합니다.
HTTP 메소드: GET
엔드포인트: /post/{postId}
요청 데이터: postId (조회할 채용 공고의 ID)
응답: 조회된 채용 공고의 상세 정보를 담은 ResponseEntity<?>
채용 공고 지원

설명: 사용자가 특정 채용 공고에 지원합니다. 사용자는 한 번만 지원 가능합니다.
HTTP 메소드: POST
엔드포인트: /apply
요청 데이터: ApplyDto (사용자의 지원 정보를 담고 있음)
응답: 지원 결과를 담은 ResponseEntity<?>
오류 처리: 예외 발생 시, HttpStatus.BAD_REQUEST로 상태 코드와 함께 "실패" 메시지를 반환합니다.
<br><br>
