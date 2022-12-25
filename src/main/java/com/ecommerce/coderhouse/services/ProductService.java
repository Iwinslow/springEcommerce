package com.ecommerce.coderhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.coderhouse.IdsListWrapper;
import com.ecommerce.coderhouse.model.Product;
import com.ecommerce.coderhouse.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long idProduct){
        return productRepository.findById(idProduct);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product newProduct){
        return productRepository.findById(productId).map(product->{
            //PRODUCT ATTRIBUTE "codigo" AND "unit" ARE updatable = false
            // product.setCodigo(newProduct.getCodigo());
            if (newProduct.getDescription() != null) {
                product.setDescription(newProduct.getDescription());
            }
            if (newProduct.getName() != null) {
                product.setName(newProduct.getName());
            }
            if (newProduct.getPrice() != 0.00) {
                product.setPrice(newProduct.getPrice());
            }
            if (newProduct.getStock() !=0) {
                product.setStock(newProduct.getStock());
            }
            
            return productRepository.save(product);
        }).orElseGet(()->{
            newProduct.setId(productId);
            return productRepository.save(newProduct);
        });
    }

    public void deleteProduct(IdsListWrapper idsListWrapper){
        productRepository.deleteAllById(idsListWrapper.getIdsList());
    }
}
