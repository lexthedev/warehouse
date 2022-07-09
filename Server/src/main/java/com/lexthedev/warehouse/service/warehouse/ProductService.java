package com.lexthedev.warehouse.service.warehouse;

import com.lexthedev.warehouse.entity.warehouse.ProductEntity;
import com.lexthedev.warehouse.exceptions.AlreadyExistsException;
import com.lexthedev.warehouse.exceptions.NotFoundException;
import com.lexthedev.warehouse.model.warehouse.Product;
import com.lexthedev.warehouse.repository.warehouse.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Product getOne(Long id) throws NotFoundException {
        ProductEntity product = productRepo.findById(id).get();
        if (product == null) {
            throw new NotFoundException("product not found");
        } else {
            return Product.toModel(product);
        }
    }

    public List<Product> getAll() {
        Iterable<ProductEntity> products = productRepo.findAll();
        List<Product> result = new ArrayList<Product>();
        products.forEach(product -> result.add(Product.toModel(product)));

        return result;
    }

    public ProductEntity create(ProductEntity product) throws AlreadyExistsException {
        String title = product.getTitle();
        if (productRepo.findByTitle(title) != null) {
            throw new AlreadyExistsException("Product with title '" + title + "' has already created!");
        }
        return productRepo.save(product);
    }

    public ProductEntity edit(ProductEntity product) throws NotFoundException {
        Long id = product.getId();
        if (productRepo.findById(id).isEmpty()) {
            throw new NotFoundException("product not found");
        }
        return productRepo.save(product);
    }

    public String delete(Long id) throws NotFoundException {
        if (productRepo.findById(id).isEmpty()) {
            throw new NotFoundException("product not found");
        }
        productRepo.delete(productRepo.findById(id).get());
        return "element with id " + id + "successfully deleted";
    }

}
