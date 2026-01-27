package io.github.luiza_esteves.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidation {
    private TodoRepository repository;

    public TodoValidation(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo){
        if(existeTodoComDesc(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe todo com essa descricao");
        }
    }

    private boolean existeTodoComDesc(String desc){
        return repository.existsByDescricao(desc);
    }
}
