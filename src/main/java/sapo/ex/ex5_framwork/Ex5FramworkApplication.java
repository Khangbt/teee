package sapo.ex.ex5_framwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sapo.ex.ex5_framwork.annotation.CheckType;
import sapo.ex.ex5_framwork.dto.ProductDto;
import sapo.ex.ex5_framwork.model.ProductEntity;
import sapo.ex.ex5_framwork.service.ProductService;

import java.util.List;

@SpringBootApplication


public class Ex5FramworkApplication implements CommandLineRunner  {
@Autowired
private ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(Ex5FramworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("asssssssssssss");
		CheckType<ProductDto> checkType =new CheckType();
		ProductDto productDto=new ProductDto();
		productDto.setProductprice(1);
		checkType.tea(productDto);

	}
}
