package io.github.luiza.santos.libraryapi.repository;

import io.github.luiza.santos.libraryapi.model.Autor;
import io.github.luiza.santos.libraryapi.model.GeneroLivro;
import io.github.luiza.santos.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest(){
        Livro livro = new Livro();
        livro.setIsbn("2344r");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setTitulo("Titulo");
        livro.setData_publicacao(LocalDate.of(2007,3,4));

        Autor autor = autorRepository.findById(UUID.fromString("9ddb64b7-bf70-49f4-b963-54107978a797")).orElse(null);
        livro.setAutor(autor);
        repository.save(livro);
    }

}