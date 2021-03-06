-- CREATE SCHEMA `playtox`;

DROP TABLE purchase IF EXISTS ;
DROP TABLE goods IF EXISTS;
DROP TABLE user_roles IF EXISTS;
DROP TABLE users IF EXISTS;


CREATE TABLE users
(
  id         INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
  name       VARCHAR(45)                  NOT NULL,
  password   VARCHAR(45)                  NOT NULL
);

CREATE UNIQUE INDEX name_UNIQUE ON users (name);

CREATE TABLE user_roles
(
  user_id INT NOT NULL,
  ROLE VARCHAR (45) NOT NULL,

  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);



CREATE TABLE goods
(
  id  INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
  NAME VARCHAR (45) NOT NULL,
  description VARCHAR (255) NOT NULL,
  price INT NOT NULL,
  stock INT NOT NULL
);



CREATE TABLE purchase
(
  id  INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
  user_id INT NOT NULL,
  good_id INT NOT NULL,
  DATA  TIMESTAMP (0) NOT NULL,
  cost INT NOT NULL,
  amount INT NOT NULL,

  CONSTRAINT user_fk
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE,

  CONSTRAINT goods_fk
  FOREIGN KEY (good_id) REFERENCES goods (id) ON DELETE CASCADE
);









