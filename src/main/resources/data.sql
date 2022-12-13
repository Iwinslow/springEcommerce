DROP DATABASE IF EXISTS ecommercespring;

CREATE DATABASE ecommercespring;

CREATE TABLE ecommercespring.ecommerces (
	id_ecommerce int NOT NULL AUTO_INCREMENT,
    cuit varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    PRIMARY KEY (id_ecommerce)
);

CREATE TABLE ecommercespring.clients (
	id_client int NOT NULL AUTO_INCREMENT,
    documentType varchar(255) NOT NULL,
    documentNumber int NOT NULL,
    ivaSituation varchar(255) NOT NULL,
    fullname varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    ecommerce_id int,
    PRIMARY KEY (id_client),
    CONSTRAINT FK_ecommerceClient FOREIGN KEY (ecommerce_id)
    REFERENCES ecommerces(id_ecommerce)
);

CREATE TABLE ecommercespring.products (
    id_product int NOT NULL AUTO_INCREMENT,
    codigo int NOT NULL,
    name varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    price FLOAT(30, 2),
    stock int,
    unit varchar(255) NOT NULL,
    ecommerce_id int,
    PRIMARY KEY (id_product),
    CONSTRAINT FK_ecommerceProduct FOREIGN KEY (ecommerce_id)
    REFERENCES ecommerces(id_ecommerce)
);

CREATE TABLE ecommercespring.carts (
    id_cart int NOT NULL AUTO_INCREMENT,
    state varchar(255) NOT NULL,
    total FLOAT(30, 2),
    client_id int,
    PRIMARY KEY (id_cart),
    CONSTRAINT FK_cliente FOREIGN KEY (client_id)
    REFERENCES clients(id_client)
);

CREATE TABLE ecommercespring.cart_items (
    id_cartitem int NOT NULL AUTO_INCREMENT,
    quantity int,
    cart_id int NOT NULL,
    product_id int NOT NULL,
    PRIMARY KEY (id_cartitem),
    CONSTRAINT FK_cartCartItem FOREIGN KEY (cart_id)
    REFERENCES carts(id_cart),
    CONSTRAINT FK_products FOREIGN KEY (product_id)
    REFERENCES products(id_product)
);

CREATE TABLE ecommercespring.purchase_orders (
    id_purchase_orders int NOT NULL AUTO_INCREMENT,
    delivery_address varchar(255) NOT NULL,
    payment_method varchar(255) NOT NULL,
    cart_id int,
    PRIMARY KEY (id_purchase_orders),
    CONSTRAINT FK_cartPurchaseOrders FOREIGN KEY (cart_id)
    REFERENCES carts(id_cart)
);


insert into ecommercespring.ecommerces (cuit, name, address) values ("30-78945612-9", "Empresa S.A.", "Calle False 123");
insert into ecommercespring.clients (documentType, documentNumber, ivaSituation, fullname, email, address, ecommerce_id) values ("DNI", "99999999", "Responsable Inscripto", "Bill Gates", "el_bill_gates@gmail.com", "Otra calle 123", 1);
insert into ecommercespring.products (codigo, name, description, price, stock, unit, ecommerce_id) values (321456988, "Teclado luminoso Corsair", "Un teclado con luces muy copadas", 60000.00, 20, "UNIDADES", 1);
insert into ecommercespring.products (codigo, name, description, price, stock, unit, ecommerce_id) values (321456987, "Mouse luminoso Corsair", "Un Mouse con luces muy copadas", 30000.00, 10, "UNIDADES", 1);
insert into ecommercespring.products (codigo, name, description, price, stock, unit, ecommerce_id) values (321456986, "Monitor luminoso Corsair", "Un Monitor con luces muy copadas", 120000.00, 5, "UNIDADES", 1);
insert into ecommercespring.carts (state, total, client_id) values ("confirm", 90000.00, 1);
insert into ecommercespring.carts (state, total, client_id) values ("pending", 120000.00, 1);
insert into ecommercespring.cart_items (quantity, cart_id, product_id) values (1, 1, 1);
insert into ecommercespring.cart_items (quantity, cart_id, product_id) values (1, 1, 2);
insert into ecommercespring.purchase_orders (delivery_address, payment_method, cart_id) values ("Otro domicilio 123", "CREDIT VISA", 1);
