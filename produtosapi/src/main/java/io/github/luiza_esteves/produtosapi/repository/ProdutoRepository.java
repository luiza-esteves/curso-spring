package io.github.luiza_esteves.produtosapi.repository;

import io.github.luiza_esteves.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//operacoes no banco
// parametro a classe e o tipo da chave primaria
public interface ProdutoRepository extends JpaRepository<Produto,String> {

    List<Produto> findByNome(String nome);

}
