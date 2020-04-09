package com.jegan.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jegan.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
