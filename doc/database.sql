
DELATE DATABASE visites;
CREATE DATABASE if not exists  visites;
CREATE TABLE if not exists site (id INT(11), name VARCHAR(50), adress VARCHAR(50), description LONGTEXT, price DECIMAL(4,2), image1 VARCHAR(100), image2 VARCHAR(100));
ALTER TABLE site 
ADD PRIMARY KEY(id);

INSERT INTO SITE( name, adress, description, price, image1, image2) VALUES 
("Grande roue Montreal", "362 Rue de la Commune E, Montréal, QC H2Y 0B4" , "28,74", "granderou1.jpg", "granderou1.jpg");


CREATE TABLE if not exists user (id INT(11), email VARCHAR(50), password VARCHAR(100), role INT(1), gender  INT(1));

ALTER TABLE user 
ADD PRIMARY KEY(id)
ADD UNIQUE KEY UNIQUE_EMAIL (email);

INSERT INTO USER( email, password, role, gender) VALUES 
("ruben@gmail.com", "passwordRuben" , 1,1),
("alexine@gmail.com", "passwordAlexine" , 1,0),
("vladimyr@gmail.com", "passwordVladimyr" , 2,0),
("mane@gmail.com", "passwordSadio" , 1,0),
("sandra@gmail.com", "passwordSandra" , 2,1),
("neymar@gmail.com", "passwordNeymar" , 1,0),
("franc@gmail.com", "passwordFranc" , 1,0),
("wilson@gmail.com", "passwordWilson" , 2,0),
("emmanuel@gmail.com", "passwordEmmanuel" , 2,0);


CREATE TABLE if not exists comment (id INT(11), content LONGTEXT, createdAd datetime DEFAULT(CURRENT_TIME),  user_id INT(11), site_id INT(11));
ALTER TABLE comment 
ADD PRIMARY KEY(id),
ADD CONSTRAINT FK_COMMENT_USER FOREIGN KEY(user_id) REFERENCES user(id),
ADD CONSTRAINT FK_COMMENT_SITE FOREIGN KEY(site_id) REFERENCES site(id);

INSER INTO comment(content, user_id, site_id) VALUES 
("merveilleux site", 1, 1),
("Je vais tout voire", 2, 1),
("Mes amis arriveront ici l'an prochain", 1, 1),
("J'aime ce site", 1, 1),
("merveilleux site", 1, 1);

CREATE TABLE if not exists activity (id INT(11), wording VARCHAR(50),  site_id INT(11));
ALTER TABLE activity 
ADD PRIMARY KEY(id),
ADD CONSTRAINT FK_ACTIVITY_SITE FOREIGN KEY(site_id) REFERENCES site(id);
INSERT INTO activity( wording, site) VALUES 
("Nage", 1);

CREATE TABLE if not exists visit (id INT(11), visitorNumber INT(11), createdAd datetime, client_id INT(11), guide_id INT(11), site_id INT(11));
ALTER TABLE visit 
ADD PRIMARY KEY(id),
ADD CONSTRAINT FK_VISIT_USER FOREIGN KEY(client_id) REFERENCES user(id),
ADD CONSTRAINT FK_VISIT_GUIDE FOREIGN KEY(guide_id) REFERENCES user(id),
ADD CONSTRAINT FK_VISIT_SITE FOREIGN KEY(site_id) REFERENCES site(id);