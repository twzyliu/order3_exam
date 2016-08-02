CREATE TABLE users (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price DOUBLE NOT NULL
);

CREATE TABLE orders (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  ordertime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  userid INT NOT NULL
);

CREATE TABLE orderItems (
  orderid INT NOT NULL PRIMARY KEY,
  productid INT NOT NULL,
  quantity INT NOT NULL,
  amount DOUBLE NOT NULL ,
  FOREIGN KEY (orderid) REFERENCES orders(id),
  FOREIGN KEY (productid) REFERENCES products(id)
);

CREATE TABLE payments (
  orderid INT NOT NULL PRIMARY KEY,
  pay_type VARCHAR(255) NOT NULL,
  pay_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  amount DOUBLE NOT NULL,
  FOREIGN KEY (orderid) REFERENCES orders(id)
);

