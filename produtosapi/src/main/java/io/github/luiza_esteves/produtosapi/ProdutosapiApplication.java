package io.github.luiza_esteves.produtosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProdutosapiApplication {
	//http://localhost:8080/hello-world -> porta 8080 é a padrao da tomcat
	// mapeando o retorno do metodo para uma chamada get
	@GetMapping("/hello-world")
	public String helloWorld(){
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProdutosapiApplication.class, args);
	}

}
