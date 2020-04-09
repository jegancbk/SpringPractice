package com.jegan.springweb.healthchecks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.jegan.springweb.repos.ProductRepository;

@Component
public class CustomInfoContributor implements InfoContributor {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void contribute(Builder builder) {

        builder.withDetail("ProductsCount", productRepository.count());
	}

}
