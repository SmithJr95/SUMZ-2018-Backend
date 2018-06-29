INSERT INTO appRole (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO appRole (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: sumzisumz
INSERT INTO appUser (id, password, email, isActive) VALUES (1, '$2a$12$iZ3mMr0Ti/FLoYEdbunuvuoCn32maysJBv2AwmQuHL9gHcFiwz8hi', 'user@host.com', true);
INSERT INTO appUser (id, password, email, isActive) VALUES (2, '$2a$12$iZ3mMr0Ti/FLoYEdbunuvuoCn32maysJBv2AwmQuHL9gHcFiwz8hi', 'admin@host.com', true);

INSERT INTO userRole(user_id, role_id) VALUES(1,1);
INSERT INTO userRole(user_id, role_id) VALUES(2,2);

