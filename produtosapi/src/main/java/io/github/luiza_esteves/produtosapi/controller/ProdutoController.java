package io.github.luiza_esteves.produtosapi.controller;

import io.github.luiza_esteves.produtosapi.model.Produto;
import io.github.luiza_esteves.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

//anotacao pra receber requisicao rest
@RestController
//qual a url base
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //envio de dados, cria recursos no servidor
    @PostMapping()
    public Produto salvar(@RequestBody Produto produto){
        //recebe entidade que quer salvar

        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }


}
