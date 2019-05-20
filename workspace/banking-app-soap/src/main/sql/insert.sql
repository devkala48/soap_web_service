INSERT INTO Users (u_username, u_password, u_auth, u_firstname, u_lastname, u_ssn, u_address, u_phone)
VALUES ('admin', 'password', 'ADMIN', 'ADMIN', 'USER', '', '', ''),
('devkala', 'password', 'CLIENT', 'devkala', 'gaha', '123', '', ''),
('test', 'password', 'CLIENT', 'Test', 'test', '234', '', ''),
('meen', 'password', 'CLIENT', 'Meen', 'meen', '333', '', ''),
ON CONFLICT (u_username) DO NOTHING;

INSERT INTO accounts (acct_balance, acct_status)
VALUES (1000, 'CLEAR'),
(2000, 'CLEAR'),
(3000, 'CLEAR');

INSERT INTO permissions (p_u_id, p_acct_id, p_withdraw, p_deposit) VALUES
(1, 1, true, true),
(1, 2, true, true),
(1, 3, true, true),
(2, 1, true, true),
(3, 2, true, true);

