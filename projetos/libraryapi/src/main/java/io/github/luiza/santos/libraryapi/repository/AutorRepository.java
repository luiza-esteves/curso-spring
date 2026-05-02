package io.github.luiza.santos.libraryapi.repository;

import io.github.luiza.santos.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
