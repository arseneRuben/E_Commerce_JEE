CREATE TABLE if not exists site (id INT(11), name VARCHAR(50), adress VARCHAR(50), description LONGTEXT);
ALTER TABLE site 
ADD PRIMARY KEY(id);

CREATE TABLE if not exists user (id INT(11), email VARCHAR(50), password VARCHAR(100), role INT(1));
ALTER TABLE user 
ADD PRIMARY KEY(id);

CREATE TABLE if not exists comment (id INT(11), content LONGTEXT, createdAd datetime, role INT(1), user_id INT(11), site_id INT(11));
ALTER TABLE comment 
ADD PRIMARY KEY(id),
ADD CONSTRAINT FK_COMMENT_USER FOREIGN KEY(user_id) REFERENCES user(id),
ADD CONSTRAINT FK_COMMENT_SITE FOREIGN KEY(site_id) REFERENCES site(id);

CREATE TABLE if not exists activity (id INT(11), wording VARCHAR(50),  site_id INT(11));
ALTER TABLE activity 
ADD PRIMARY KEY(id),
ADD CONSTRAINT FK_ACTIVITY_SITE FOREIGN KEY(site_id) REFERENCES site(id);


CREATE TABLE if not exists visit (id INT(11), visitorNumber INT(11), createdAd datetime, client_id INT(11), guide_id INT(11), site_id INT(11));
ALTER TABLE visit 
ADD PRIMARY KEY(id),
ADD CONSTRAINT FK_VISIT_USER FOREIGN KEY(client_id) REFERENCES user(id),
ADD CONSTRAINT FK_VISIT_GUIDE FOREIGN KEY(guide_id) REFERENCES user(id),
ADD CONSTRAINT FK_VISIT_SITE FOREIGN KEY(site_id) REFERENCES site(id);