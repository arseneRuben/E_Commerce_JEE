DROP DATABASE visites;
CREATE DATABASE if not exists  visites;
USE visites;
CREATE TABLE if not exists sites (id int(11) NOT NULL AUTO_INCREMENT, name VARCHAR(250), address VARCHAR(250), description LONGTEXT,  primary key(ID));
INSERT INTO sites( name, address, description) VALUES 


("Grande roue Montreal", "362 Rue de la Commune E, Montréal, QC H2Y 0B4" , "Profitez d’une vue imprenable à 60 m de hauteur toute l’année, depuis la plus grande roue du Canada. Améliorez votre expérience en optant pour une télécabine privée ou devancez la foule grâce à l'option coupe-file."),
("Basilique Notre-Dame", "110 Rue Notre Dame O, Montréal, QC H2Y 1T1" , "description"),
("Observatoire de la Tour de Montréal", "3200 Rue Viau, Montréal, QC H1V 3J3" , "description"),
("Strom Nordic Spa", "1001 Bd de la Forêt, Verdun, QC H3E 1X9" , "description"),
("Mont Royal", "Chem. Olmsted, Montréal, QC H3H 1A2" , "description"),
("Parc olympique de Montréal", " 4545 Av. Pierre-De Coubertin, Montréal, QC H1V 3N7" , "description"),
("Oratoire Saint-Joseph du Mont-Royal", "3800 Chem. Queen Mary, Montréal, QC H3V 1H6" , "description"),
("ISI Montreal", "362 Rue de la Commune E, Montréal, QC H2Y 0B4" ,"");
CREATE TABLE if not exists activities (id int(11) NOT NULL AUTO_INCREMENT, wording VARCHAR(50),  site_id INT(11),    price DECIMAL(4,1) , primary key(ID));
ALTER TABLE activities 
ADD CONSTRAINT FK_ACTIVITY_SITE FOREIGN KEY(site_id) REFERENCES sites(id);
INSERT INTO activities( wording, site_id, price) VALUES 
("Nage", 1, 4.0),
("Socker", 1, 2.0),
("Sky", 1, 0.0),
("Course", 1,  4.0),
("Monter à la roue", 1, 30.0 ),
("Visite guidée dans le vieux port", 1, 25.0),
("visite guidée", 2, 35.0),
("Visite nocturne guidée en petit groupe", 2, 40.0),
("visite guidée", 3, 15.0),
("Expérience Thermale Spa Nordique", 4, 25.0),
("Massage relaxant", 4, 40.0),
("Visite guidée en bus", 5, 35.0),
("Visite guidée en vélo", 5, 25.0),
("Visite à l'interieur du Stade Olympique ", 6, 15.0),
("Visite au Biodôme", 6, 25.0),
("Visite guidée en bus", 7, 30.0),
("Visite nocturne guidée en petit groupe", 7, 35.0);

CREATE TABLE if not exists images (id int(11) NOT NULL AUTO_INCREMENT, path VARCHAR(50),  item_id INT(11),type INT(1) , primary key(ID));
;

INSERT INTO images( path, item_id, type) VALUE
("montreal_slide1.jpg", 1, 1),
("montreal_slide2.jpg", 2, 1),
("h4-slide2.png",  3, 1),
("montreal_slide4.jpg", 4, 1),
("h4-slide4.png", 5, 1),
("parc_olympique_interieur.jpg", 6, 1),
("montreal_slide3.jpg", 7, 1),
("h4-slide2.png", 8, 1),

("product-5.jpg", 1, 2),
("product-1.jpg", 2, 2),
("grande_roue.jpg",   2, 2),
("iStock-515441828.jpg",4, 2),
("oratoire_interieur.jpg", 4, 2),
("strom_spa_exterieur.jpg",6, 2),
("product-6.jpg", 7, 1);





CREATE TABLE if not exists users (id INT(11) NOT NULL AUTO_INCREMENT, email VARCHAR(50), password VARCHAR(100),  gender  INT(1), statu INT(1) DEFAULT 0, PRIMARY KEY(id));

ALTER TABLE users

ADD UNIQUE KEY UNIQUE_EMAIL (email);

INSERT INTO users( email, password,  gender) VALUES 
("ruben@gmail.com", "passwordRuben" , 1),
("alexine@gmail.com", "passwordAlexine" , 0),
("vladimyr@gmail.com", "passwordVladimyr" , 0),
("mane@gmail.com", "passwordSadio" , 0),
("sandra@gmail.com", "passwordSandra" , 1),
("neymar@gmail.com", "passwordNeymar" , 0),
("franc@gmail.com", "passwordFranc" , 0),
("wilson@gmail.com", "passwordWilson" ,0),
("emmanuel@gmail.com", "passwordEmmanuel" , 0);


CREATE TABLE if not exists commands (id INT(11)  NOT NULL AUTO_INCREMENT, client_id INT(11),  createdAt datetime DEFAULT(CURRENT_TIME), PRIMARY KEY(id));
ALTER TABLE commands

ADD CONSTRAINT FK_COMMENT_USER FOREIGN KEY(client_id) REFERENCES users(id);


INSERT INTO commands(client_id) VALUES 
( 1),
( 2),
( 1),
(3);


INSERT INTO commands(client_id) VALUES 
( 1),
( 2),
( 1),
(3);


CREATE TABLE if not exists CommandLines(id INT(11) NOT NULL AUTO_INCREMENT, activity_id INT(11),   command_id INT(11),  visitorsNumber INT(11),  PRIMARY KEY(id));
ALTER TABLE CommandLines
ADD CONSTRAINT FK_COMMANDLINE_ACTIVITY FOREIGN KEY(activity_id) REFERENCES activities(id),
ADD CONSTRAINT FK_COMMANDLINE_COMMAND FOREIGN KEY(command_id) REFERENCES commands(id);
INSERT INTO CommandLines(activity_id, command_id, visitorsNumber) VALUES
(1, 1, 3),
(1, 2, 2),
(2, 1, 1),
(2, 2, 10);


CREATE TABLE if not exists comments (id INT(11) NOT NULL AUTO_INCREMENT, content LONGTEXT, createdAt datetime DEFAULT(CURRENT_TIME), commandLine_id INT(11), PRIMARY KEY(id));
ALTER TABLE comments
ADD CONSTRAINT FK_COMMENT_SITE FOREIGN KEY(commandLine_id) REFERENCES CommandLines(id);
INSERT INTO comments(content,  commandLine_id) VALUES 
("merveilleux site",  1),
("Je vais tout voire",  2),
("Mes amis arriveront ici l'an prochain",  1),
("J'aime ce site",  1),
("merveilleux site", 3); 




