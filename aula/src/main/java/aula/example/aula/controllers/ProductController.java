package aula.example.aula.controllers;

import aula.example.aula.dtos.ProductRecordDto;
import aula.example.aula.model.productmodel;
import aula.example.aula.repositories.ProducRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProducRepository producRepository;

    @PostMapping("/products")
    public ResponseEntity<productmodel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productmodel = new productmodel();
        BeanUtils.copyProperties(productRecordDto, productmodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(producRepository.save(productmodel));
    }

    @GetMapping("/products")
    public ResponseEntity<List<productmodel>> getAllProducts() {
        List<productmodel> productlist = producRepository.findAll();
        if (!productlist.isEmpty()) {
            for (productmodel product : productlist) {
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productlist);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
        Optional<productmodel> productO = producRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<productmodel> productO = producRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productmodel = productO.get();
        BeanUtils.copyProperties(productRecordDto, productmodel);
        return ResponseEntity.status(HttpStatus.OK).body(producRepository.save(productmodel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object>
    deleteProduct(@PathVariable(value = "id") UUID id) {
        Optional<productmodel> productO = producRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        producRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted.");
    }

}

