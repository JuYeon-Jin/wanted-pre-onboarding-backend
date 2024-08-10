SHOW DATABASES;
CREATE DATABASE wanted;
USE wanted;
SHOW TABLES;
SELECT * FROM countries;
SELECT * FROM regions;
SELECT * FROM companies;
SELECT * FROM posts;
SELECT * FROM skills;

CREATE TABLE countries (
    country_id INT PRIMARY KEY AUTO_INCREMENT,
    country_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE regions (
    region_id INT PRIMARY KEY AUTO_INCREMENT,
    country_id INT,
    region_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries(country_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO countries (country_name) VALUES ('한국'), ('미국');
INSERT INTO regions (country_id, region_name) VALUES (1, '서울'), (1, '판교'), (2, '캘리포니아');

CREATE TABLE skills (
    skill_id INT PRIMARY KEY AUTO_INCREMENT,
    skill_name VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO skills (skill_name) VALUES ('Java'), ('Python'), ('Javascript'), ('Django');

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



INSERT INTO posts (company_id, skill_id, position, compensation, description) VALUES 
(1, 2, '백엔드 주니어 개발자', 1000000, '원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..'),
(5, 3, '프론트엔드 개발자', 500000, '원티드코리아에서 프론트엔드 개발자를 채용합니다. 자격요건은..'),
(2, 4, 'Django 백엔드 개발자', 1000000, '네이버에서 Django 백엔드 개발자를 채용합니다. 자격요건은..'),
(4, 2, 'Python 백엔드 개발자', 500000, '카카오에서 Python 백엔드 개발자를 채용합니다. 자격요건은..');

SELECT * FROM posts;
UPDATE posts SET skill_id = 2, 
    position = '백엔드 주니어 개발자', 
    compensation = 1200000, 
    description = '원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..'
WHERE post_id = 1;


SELECT p.post_id AS postId,
       c.company_name AS companyName,
       co.country_name AS countryName,
       r.region_name AS regionName,
       p.position AS position,
       p.compensation AS compensation,
       s.skill_name AS skillName
FROM posts p
JOIN companies c ON p.company_id = c.company_id
JOIN countries co ON c.country_id = co.country_id
JOIN regions r ON c.region_id = r.region_id
JOIN skills s ON p.skill_id = s.skill_id;
