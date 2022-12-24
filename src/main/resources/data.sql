insert into ecommercespring.ecommerces (cuit, name, address) values ("30-78945612-9", "Empresa S.A.", "Calle False 123");

insert into ecommercespring.finantial_statements (total_sales, total_iva, total_iibb, invoices_issued, ecommerce_id) values (0, 0, 0, 0, 1);

insert into ecommercespring.clients (documentType, documentNumber, ivaSituation, fullname, email, address, ecommerce_id) values ("DNI", "99999999", "Responsable Inscripto", "Bill Gates", "el_bill_gates@gmail.com", "Otra calle 123", 1);

insert into ecommercespring.products (codigo, name, description, price, stock, unit, ecommerce_id) values (321456988, "Teclado luminoso Corsair", "Un teclado con luces muy copadas", 60000.00, 20, "UNIDADES", 1);

insert into ecommercespring.products (codigo, name, description, price, stock, unit, ecommerce_id) values (321456987, "Mouse luminoso Corsair", "Un Mouse con luces muy copadas", 30000.00, 10, "UNIDADES", 1);

insert into ecommercespring.products (codigo, name, description, price, stock, unit, ecommerce_id) values (321456986, "Monitor luminoso Corsair", "Un Monitor con luces muy copadas", 120000.00, 5, "UNIDADES", 1);