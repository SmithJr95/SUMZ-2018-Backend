INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: sumzisumz
INSERT INTO app_user (id, password, email) VALUES (1, '$2a$12$iZ3mMr0Ti/FLoYEdbunuvuoCn32maysJBv2AwmQuHL9gHcFiwz8hi', 'user@host.com');
INSERT INTO app_user (id, password, email) VALUES (2, '$2a$12$iZ3mMr0Ti/FLoYEdbunuvuoCn32maysJBv2AwmQuHL9gHcFiwz8hi', 'admin@host.com');

INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

