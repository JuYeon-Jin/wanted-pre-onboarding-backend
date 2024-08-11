SHOW DATABASES;
CREATE DATABASE wanted;
USE wanted;

SHOW TABLES;
SELECT * FROM countries;
SELECT * FROM regions;
SELECT * FROM companies;
SELECT * FROM skills;
SELECT * FROM posts;
SELECT * FROM users;
SELECT * FROM apply;


-- 국가 테이블 생성 및 기본 데이터 생성
CREATE TABLE countries (
    country_id INT PRIMARY KEY AUTO_INCREMENT,
    country_name VARCHAR(100) NOT NULL UNIQUE
);
INSERT INTO countries (country_name) VALUES ('한국'), ('미국');

-- 도시 테이블 생성 및 기본 데이터 생성
CREATE TABLE regions (
    region_id INT PRIMARY KEY AUTO_INCREMENT,
    country_id INT,
    region_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries(country_id) ON DELETE RESTRICT ON UPDATE CASCADE
);
INSERT INTO regions (country_id, region_name) VALUES (1, '서울'), (1, '판교'), (2, '캘리포니아');

-- 회사 테이블 생성 및 기본 데이터 생성
CREATE TABLE companies (
    company_id INT PRIMARY KEY AUTO_INCREMENT,
    country_id INT NOT NULL,
    region_id INT NOT NULL,
    company_name VARCHAR(100) NOT NULL UNIQUE,
    FOREIGN KEY (country_id) REFERENCES countries(country_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (region_id) REFERENCES regions(region_id) ON DELETE RESTRICT ON UPDATE CASCADE
);
INSERT INTO companies (country_id, region_id, company_name) VALUES 
(1, 1, '원티드랩'), (1, 2, '네이버'), (2, 3, '구글'), (1, 2, '카카오'), (1, 1, '원티드코리아');

-- 사용기술 테이블 생성 및 기본 데이터 생성
CREATE TABLE skills (
    skill_id INT PRIMARY KEY AUTO_INCREMENT,
    skill_name VARCHAR(100) NOT NULL UNIQUE
);
INSERT INTO skills (skill_name) VALUES ('Java'), ('Python'), ('Javascript'), ('Django');

-- 채용 공고 테이블 생성
CREATE TABLE posts (
    post_id INT PRIMARY KEY AUTO_INCREMENT,
    company_id INT NOT NULL,
    skill_id INT NOT NULL,
    position VARCHAR(100) NOT NULL,
    compensation INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES companies(company_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skills(skill_id) ON DELETE RESTRICT ON UPDATE CASCADE
);
-- 채용 목록 조회를 위한 임의 데이터 삽입
-- INSERT INTO posts (company_id, skill_id, position, compensation, description) VALUES 
-- (1, 2, '백엔드 주니어 개발자', 1000000, '원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..'),
-- (5, 3, '프론트엔드 개발자', 500000, '원티드코리아에서 프론트엔드 개발자를 채용합니다. 자격요건은..'),
-- (2, 4, 'Django 백엔드 개발자', 1000000, '네이버에서 Django 백엔드 개발자를 채용합니다. 자격요건은..'),
-- (4, 2, 'Python 백엔드 개발자', 500000, '카카오에서 Python 백엔드 개발자를 채용합니다. 자격요건은..');

-- 사용자 테이블 생성 및 기본 데이터 생성
CREATE TABLE users (
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name varchar(63) NOT NULL
);
INSERT INTO users (user_name) VALUES ('김철수'), ('김민수'), ('김민지'), ('김영수'), ('홍길동');

-- 지원 테이블 생성
CREATE TABLE apply (
	apply_id INT PRIMARY KEY AUTO_INCREMENT,
    post_id INT NOT NULL,
    user_id INT NOT NULL UNIQUE,
    FOREIGN KEY (post_id) REFERENCES posts(post_id) ON DELETE CASCADE ON UPDATE RESTRICT,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- INSERT INTO apply (post_id, user_id) VALUES (1, 1);

