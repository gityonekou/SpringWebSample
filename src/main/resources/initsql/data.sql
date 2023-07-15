-- book table
INSERT INTO BOOK(TITLE) VALUES ('Don Quijote de la Mancha');
INSERT INTO BOOK(TITLE) VALUES ('A Tale of Two Cities');
INSERT INTO BOOK(TITLE) VALUES ('The Fellowship of the Ring');
-- login user
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES
('admin', '{bcrypt}$2a$10$vC.r53zKYPwEXplBYH3mxuZP52r2u3udRcEg9yTUmwYE5yjmoUXyG', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('admin', 'ROLE_USER');
-- USER_COMMENT init data add
-- INSERT INTO USER_COMMENT (NAME, MAILADDRESS, TEXT) VALUES ('Test User', 'test001@test.com', 'テスト投稿内容');
