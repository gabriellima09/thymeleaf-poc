package thymeleaf.demo.Models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter							//notação do lombok que permite criar todos os métodos GETTERs e SETTERs
@AllArgsConstructor						//cria um construtor que recebe todos os parâmetros
@NoArgsConstructor						//cria um construtor sem parametros
@Entity(name = "tbl_produtos")
public class Produto
{	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)					//a segunda serve para indicar que é um chave primária e que será gerado um valor automaticamente				
	private Long id;					
	
	private String nome;

	private String descricao;

	@NumberFormat(style=Style.CURRENCY ,pattern="#,##0.00")
	private BigDecimal preco;
}