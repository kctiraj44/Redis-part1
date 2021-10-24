package com.Redis1.SpringRedis;

import com.Redis1.SpringRedis.entity.Product;
import com.Redis1.SpringRedis.repository.ProducTDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringRedisPart1Application {

	@Autowired
	private ProducTDao dao;

	@PostMapping
	public Product save(@RequestBody Product product){
		return dao.save(product);
	}

	@GetMapping
	public List<Product> getAll(){
		return  dao.findAll();
	}

	@GetMapping("/{id}")
	public Product findByID(@PathVariable("id") int id){
		return dao.findProdductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable("id") int id){
		return dao.deleteProduct(id);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringRedisPart1Application.class, args);
	}

}
