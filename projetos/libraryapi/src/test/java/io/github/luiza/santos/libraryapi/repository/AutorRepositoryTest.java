package io.github.luiza.santos.libraryapi.repository;

import io.github.luiza.santos.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {
    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("Marcos");
        autor.setNacionalidade("brasileira");
        autor.setData_nascimento(LocalDate.of(1950,2,12));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo: "+autorSalvo);
    }

    @Test
    public void atualizarTest() {
        var id = UUID.fromString("56b617b2-b9a3-449f-9aa3-e08c63a802ba");
        Optional<Autor> possivelAutor = repository.findById(id);
        if(possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor:");
            System.out.println(autorEncontrado);
            autorEncontrado.setData_nascimento(LocalDate.of(2002,3,14));
            repository.save(autorEncontrado);
        }
    }
}
