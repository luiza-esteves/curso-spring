package io.github.luiza_esteves.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidation validator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidation validator, MailSender mailSender){
        this.repository = todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }
    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return  repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        boolean concluido = todo.isConcluido();
        String status = concluido ? "enviado" : "erro";
        mailSender.enviar("todo "+todo.getDescricao() +" "+status);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }
}
