DROP DATABASE IF EXISTS ecommercespring;

CREATE DATABASE ecommercespring;

CREATE TABLE ecommercespring.ecommerces (
	id_ecommerce int NOT NULL AUTO_INCREMENT,
    cuit varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    PRIMARY KEY (id_ecommerce)
);

CREATE TABLE ecommercespring.finantial_statements (
	id_finantialstatement int NOT NULL AUTO_INCREMENT,
    total_sales int NOT NULL,
    total_iva int NOT NULL,
    total_iibb int NOT NULL,
    invoices_issued int NOT NULL,
    ecommerce_id int,
    PRIMARY KEY (id_finantialstatement),
    CONSTRAINT FK_ecommerceFinantialStatement FOREIGN KEY (ecommerce_id)
    REFERENCES ecommerces(id_ecommerce)
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

CREATE TABLE ecommercespring.invoices (
    id_invoice int NOT NULL AUTO_INCREMENT,
    tax_iibb int,
    tax_iva int,
    purchase_order_id int,
    PRIMARY KEY (id_invoice),
    CONSTRAINT FK_invoicesPurchaseOrders FOREIGN KEY (purchase_order_id)
    REFERENCES purchase_orders(id_purchase_orders)
);
