package io.github.luiza_esteves.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;

//nao é obrigado a colocar anotacao
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String descricao);

}
