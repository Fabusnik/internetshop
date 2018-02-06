use playtox;

insert into users (name, password) values
('Admin', 'admin'),
('User', 'user');

insert into user_roles (user_id, role) values
  (1, 'ROLE_ADMIN'),
  (1, 'ROLE_USER'),
  (2, 'ROLE_USER');

insert into goods(name,description, price, stock) values
  ('Игрушка', 'Китайская игрушечная машинка', 100, 5),
  ('Цветок', 'Живая роза', 50, 150),
  ('Кот', 'Котенок сфинкса', 1500, 1),
  ('Вода 5 л.', 'Артезианская вода', 60, 15);

insert into purchase(user_id, good_id, data, cost, amount) values
  (2, 2, '2018-01-20 10:00:00', 150, 3),
  (1, 4, '2018-01-20 12:00:00', 240, 4);

