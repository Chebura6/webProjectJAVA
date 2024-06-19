INSERT INTO pancakes.role (rolename) VALUES ('ROLE_ADMIN'), ('ROLE_USER'), ('ROLE_BAKERYSELLER'), ('ROLE_COOKIESELLER'), ('ROLE_PANCAKESELLER') ;

INSERT INTO pancakes.user (username, password, sellerid, roleid) VALUES ('artem', '100', 1, 3);
INSERT INTO pancakes.user (username, password, sellerid, roleid) VALUES ('cookiest', '100', 1 , 4);
INSERT INTO pancakes.user (username, password, sellerid, roleid) VALUES ('pancaker', '100', 1, 5);
INSERT INTO pancakes.user (username, password, sellerid, roleid) VALUES ('admin', '100', 1, 1);