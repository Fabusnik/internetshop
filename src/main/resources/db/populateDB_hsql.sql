insert into users (name, password) values
('Admin', 'admin'),
('User', 'user');

insert into user_roles (user_id, role) values
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER');

insert into goods(name,description, price, stock) values
  ('Toy', 'China toy', 100, 5),
  ('Flower', 'Red rouse', 50, 150),
  ('Cat', 'catty', 1500, 1),
  ('Water', 'artesian water 5 liters', 60, 15);

insert into purchase(user_id, good_id, data, cost, amount) values
  (2, 2, '2018-01-20 10:00:00', 150, 3),
  (1, 4, '2018-01-20 12:00:00', 240, 4);