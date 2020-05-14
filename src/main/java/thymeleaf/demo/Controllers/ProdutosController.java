package thymeleaf.demo.Controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import thymeleaf.demo.Models.Produto;
import thymeleaf.demo.Repositories.ProdutoRepositorio;


@Controller
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutosController {

    private final ProdutoRepositorio repository;

	@GetMapping 
	public ModelAndView listar(@ModelAttribute("produtoEditavel") Produto produto)
	{	
		ModelAndView model = new ModelAndView("produtos");	
		model.addObject("produtos", this.repository.findAll());
		return model;
	}
	
	@PostMapping("/salvar") //insere e altera
	public ModelAndView salvar(Produto produto)
	{	
		this.repository.save(produto); // save faz inserção e alteração
		return new ModelAndView("sucesso");
	}
	
	@GetMapping("/excluir")
	public ModelAndView excluir(@RequestParam("id") Long id)
	{	
		this.repository.deleteById(id);
		return new ModelAndView("sucesso");
	}
	
	@GetMapping("/preAlteracao") // visualização do produto antes de editar
	public ModelAndView preAlteracao(@RequestParam("id") Long id)
	{	
		Optional<Produto> optional = this.repository.findById(id); // valor nulo
		
		if(optional.isPresent())	
		{	ModelAndView model = new ModelAndView("produtos");
			
			model.addObject("produtos", this.repository.findAll());
			//o método get() só funciona caso optional for encotrado
			model.addObject("produtoEditavel", optional.get());
			return model;
		}
		
		return new ModelAndView("falha");
	}
}