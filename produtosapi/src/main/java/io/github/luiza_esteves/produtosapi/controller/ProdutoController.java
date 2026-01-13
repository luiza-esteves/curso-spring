package io.github.luiza_esteves.produtosapi.controller;

import io.github.luiza_esteves.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//anotacao pra receber requisicao rest
@RestController
//qual a url base
@RequestMapping("produtos")
public class ProdutoController {

    //envio de dados, cria recursos no servidor
    @PostMapping()
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido"+produto);
        return produto;
    }


}
