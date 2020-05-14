package thymeleaf.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thymeleaf.demo.Models.Produto;

/**
 * ProdutoRepositorio
 */
@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long>
{

}