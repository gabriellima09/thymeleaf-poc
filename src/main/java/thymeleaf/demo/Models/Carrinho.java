package thymeleaf.demo.Models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@SessionScope
@Component
public class Carrinho {
    
    private List<Produto> produtos = new ArrayList<>();

    public void AddProduto(Produto produto){
        produtos.add(produto);
    }

    public void LimparCarrinho(){
        produtos.clear();
    }
}