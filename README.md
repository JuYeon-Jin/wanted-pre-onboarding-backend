

### 📌 프로젝트 정보
<br>

> 기업의 채용을 위한 웹 서비스입니다. 이 서비스는 회사가 채용 공고를 생성하고, 사용자가 해당 공고에 지원하는 기능을 제공합니다. <br> Java & Spring 을 기반으로 개발하였으며 MyBatis 를 이용하여 DB 인 MySQL 과 연동됩니다.

<br><br>

### 📌 프로젝트 디렉토리 구조
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

<br>

#### 📁 config
> ###### MyBatis 설정 파일로, 데이터베이스와 MyBatis 간의 연동을 설정합니다.

#### 📁 controller
> ###### 사용자의 요청을 받아 서비스 레이어에 전달하고, 결과를 반환합니다.

#### 📁 dao
> ###### 데이터베이스와 직접적으로 소통하는 DAO 클래스입니다. SQL 쿼리를 사용하여 데이터를 조회, 삽입, 수정, 삭제합니다.

#### 📁 dto
> ###### ApplyDto.java: 지원자의 데이터를 전달하기 위한 DTO 클래스입니다. <br>
> ###### CompanyPostsDto.java: 회사의 공고 데이터를 전달하기 위한 DTO 클래스입니다. <br>
> ###### InsertPostDto.java: 새 공고를 삽입할 때 사용되는 DTO 클래스입니다. <br>
> ###### ReadPostDto.java: 특정 공고를 조회할 때 사용되는 DTO 클래스입니다. <br>
> ###### ReadPostsDto.java: 여러 공고를 조회할 때 사용되는 DTO 클래스입니다. <br>
> ###### UpdatePostDto.java: 기존 공고를 수정할 때 사용되는 DTO 클래스입니다.

#### 📁 service
> ###### 비즈니스 로직을 담당하는 서비스 클래스입니다. <br>
> ###### 컨트롤러에서 받은 요청을 처리하여 DAO와 상호작용하며, 필요한 비즈니스 로직을 수행합니다.


<br><br>

***

<br>

### 주요 기능

#### ⚙️ 채용공고 등록
> ##### 새로운 채용 공고를 등록합니다.
##### • API Endpoint URL : POST http://localhost/posts <br>
##### • 요청 데이터 : InsertPostDto <br>

```
{
  "companyId": 1,
  "skillId": 4,
  "position": "Django 백엔드 개발자",
  "compensation": 1000000,
  "description": "원티드랩에서 Django 백엔드 개발자를 채용합니다. 자격요건은.."
}
```

##### • 응답 : ResponseEntity&lt;boolean&gt; <br>

<br>

#### ⚙️ 채용공고 수정
> ##### 기존의 채용 공고를 수정합니다.
##### • API Endpoint URL : PUT http://localhost/posts <br>
##### • 요청 데이터 : UpdatePostDto <br>

```
{
  "postId": 2,
  "skillId": 4,
  "position": "Django 백엔드 개발자",
  "compensation": 1500000,
  "description": "원티드랩에서 Django 백엔드 개발자를 채용합니다. 자격요건은.."
}
```

##### • 응답 : ResponseEntity&lt;boolean&gt; <br>

<br>

#### ⚙️ 채용공고 삭제
> ##### 지정된 ID 의 채용공고를 삭제합니다.
##### • API Endpoint URL : DELETE http://localhost/posts/{postId} <br>
##### • 요청 데이터 : postId

```
http://localhost/posts/1
```
##### • 응답 : ResponseEntity&lt;boolean&gt; <br>

<br>

#### ⚙️ 채용공고 목록 가져오기 (검색 포함)
> ##### 전체 채용 공고 목록을 조회하거나, 검색어를 사용하여 특정 공고를 검색합니다.
##### • API Endpoint URL :  GET http://localhost/posts/search={value} <br>
##### • 요청 데이터 : search(선택사항)

```
http://localhost/posts
http://localhost/posts/search=Django
http://localhost/posts/search=원티드
```

##### • 응답 : ResponseEntity&lt;ReadPostsDto&gt; <br>

<br>

#### ⚙️ 채용 상세 페이지 가져오기
> ##### 지정된 게시물 ID 의 상세 정보를 조회합니다.
##### • API Endpoint URL :  GET http://localhost/post/{postId} <br>
##### • 요청 데이터 : postId

```
http://localhost/post/1
```

##### • 응답 : ResponseEntity&lt;ReadPostDto&gt; <br>

<br>

#### ⚙️ 채용 공고에 지원
> ##### 사용자가 특정 채용 공고에 지원합니다.
##### • API Endpoint URL : POST http://localhost/apply <br>
##### • 요청 데이터 : ApplyDto <br>

```
{
  "postId": 2,
  "userId": 1
}
```

##### • 응답 : ResponseEntity&lt;boolean&gt; <br>

<br>


***
<br>

### 📌 ERD 테이블 설계

<br>

![1o](https://github.com/user-attachments/assets/90ccedd7-7e72-464a-83f4-d08d86a4b567)

<br>

***

<br>
