package thymeleaf.demo.Controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import thymeleaf.demo.Models.Carrinho;
import thymeleaf.demo.Models.Produto;
import thymeleaf.demo.Repositories.ProdutoRepositorio;

@RequiredArgsConstructor

@Controller
@RequestMapping("/carrinho")
public class CarrinhoCompras {
    
    private final Carrinho carrinho;
    private final ProdutoRepositorio produtoRepositorio;

    @GetMapping
    public ModelAndView ExibirCarrinho(){
        
        ModelAndView retorno = new ModelAndView("carrinho");
       
        retorno.addObject("carrinho", carrinho);

        return retorno;
    }

    @GetMapping("/add")
    public ModelAndView AdicionarProduto(Long id){

        ModelAndView retorno = new ModelAndView("carrinho");

        Optional<Produto> produto = produtoRepositorio.findById(id);

        if (produto.isPresent()){
            carrinho.AddProduto(produto.get());
        }else{
            retorno.addObject("erro", true);
        }
        
        retorno.addObject("carrinho", carrinho);

        return retorno;
    }
}