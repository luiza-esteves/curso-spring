package io.github.luiza_esteves.produtosapi.repository;

import io.github.luiza_esteves.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

//operacoes no banco
// parametro a classe e o tipo da chave primaria
public interface ProdutoRepository extends JpaRepository<Produto,String> {


}
