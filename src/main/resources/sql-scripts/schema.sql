CREATE TABLE appRole (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE appUser (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  password varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  isActive boolean not null, 
  PRIMARY KEY (id)
);

CREATE TABLE userRole (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES appUser (id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES appRole (id)
);

CREATE TABLE userActivationToken (
  id bigint(20) NOT NULL AUTO_INCREMENT, 
  userId bigint(20) NOT NULL,
  expirationDate datetime NOT NULL, 
  key varchar(255) not null,
  PRIMARY KEY (id), 
  CONSTRAINT FK_UserActivationTokenUser FOREIGN KEY (userId) REFERENCES appUser(id)
);

CREATE TABLE userPasswordResetToken (
  id bigint(20) NOT NULL AUTO_INCREMENT, 
  userId bigint(20) NOT NULL,
  expirationDate datetime NOT NULL, 
  key varchar(255) not null,
  PRIMARY KEY (id), 
  CONSTRAINT FK_UserPasswordResetTokenUser FOREIGN KEY (userId) REFERENCES appUser(id)
);