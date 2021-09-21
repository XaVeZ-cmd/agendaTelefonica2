package br.com.servico.agendatelefonica.controller;

import br.com.servico.agendatelefonica.models.Contato;
import br.com.servico.agendatelefonica.service.ContatoService;
import br.com.servico.agendatelefonica.utils.Endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping({Endpoints.REQUEST_CONTATOS})
public class ContatoController {

    @Autowired
    ContatoService contatoService;

//    ContatosController(ContatosRepository contatosRepository){
//        this.repository = contatosRepository;
//    }

    @GetMapping
    public List<Contato> getContatos(){
        return contatoService.findAll();
    }
/*O método findAll é direto ao ponto: utiliza o método findAll da interface JpaRepository que faz um select * from contacts.

Como esta é uma API RESTful, pode-se omitir o código @RequestMapping(value="/contacts", method=RequestMethod.GET) e utilizar somente a anotação @GetMapping

Por padrão, o formato do resultado será um JSON.

* */


    @GetMapping(path = {Endpoints.REQUEST_CONTATOS_FIND_GET_BY_ID})
    public ResponseEntity<Contato> getById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(contatoService.getById(id)
                .orElseThrow(() -> new NoSuchElementException("Contato não encontrado")));
    }
    /*
    * Seguindo os conceitos RESTful, é necessário passar na URL o ID do registro. A anotação @PathVariable vincula o parâmetro passado pelo método com a variável do path. Note que o parâmetro long id tem o mesmo nome do path declarado em @GetMapping(path = {"/{id}"}).

A lógica para obter um contato específico é utilizar o método findById da interface JpaRepository (que irá fazer um select * from contacts where id = ?). Caso o registro seja encontrado, é retornado o status HTTP 200 (ResponseEntity.ok()) e no corpo da resposta é enviado o registro. Caso o registro não seja encontrado é retornado o status HTTP 404 - Não Encontrado (ResponseEntity.notFound()).

Um ponto importante é notar a diferença entre os métodos findAll e findById da interface JpaRepository. O método findAll retorna uma lista de entidades. Caso não exista nenhum registro na tabela, é retornada uma lista vazia ([]). Já o método findById retorna um Optional. O classe Optional existe desde o Java 8 e representa um container que pode ou não conter um valor não nulo (diferente de null). Essa classe é bem interessante para evitar exceções do tipo NullPointerException, e também permite fazer o uso dos métodos da classe Optional que simulam a programação funcional. Com o retorno do método do método findAll da interface JpaRepository podemos fazer o uso do método map caso o valor retornado seja diferente de nulo. O método map transforma (mapeia) o registro retornado em um tipo ResponseEntity.

Existe também a diferença no tipo do retorno dos métodos no controller. Equanto to findAll retorna uma lista diretamente, o método findById retorna um ResponseEntity para indicar sucesso ou não.
    * */

    @PostMapping
    public Contato criaContato(@RequestBody Contato contato){
        return contatoService.saveContato(contato);
    }

    /*O método create também é bem direto ao ponto: apenas chama o método save da interface JpaRepository. Após criar o registro na tabela, retorna o contato com o atributo id populado e o registro é retornado no corpo de resposta.

A anotação @RequestBody indica que o parâmetro contact será vinculado do corpo da requisição. Isso significa que o método espera o seguinte conteúdo do corpo da requisição (em formato JSON):*/


    @PutMapping(value=Endpoints.REQUEST_CONTATOS_FIND_GET_BY_ID)
    public ResponseEntity<Contato> updateContato(@PathVariable("id") long id, @RequestBody Contato contato){
        return contatoService.updateContato(contato);
    }


    /*
    * Para atualizar um registro, é necessário informar seu ID no caminho da URL (similar ao processo de obter um registro específico). Caso deseje usar um nome de variável diferente do que foi utilizado também pode utilizar o seguinte código @PathVariable("recordID") long id, desde que otherID também seja o nome em @PutMapping(value="/{otherID}"). Além do ID, também é necessário passar o objeto com os dados atualizados.

O próximo passo é encontrar o registro a ser atualiza que está na base de dados. Se o registro for encontrado, pode-se fazer as atualizações necessárias e assim chamar o método save e retornar os dados do registro atualizados. Note que o método save também foi utilizado na criação do registro. Caso o objeto tenha sido recuperado da base tenha um ID, será realizado um update e não um insert na tabela.

Caso o registro não seja encontrado, é retornado um erro HTTP 404.

Um ponto importante para esse método (e também para o processo de criação de registros) é que a própria classe de entidade JPA está sendo utilizada como objeto do tipo parâmetro. Não é uma prática recomendada utilizar a entidade JPA como um objeto de transferência (ou DTO: Data Transfer Object). É sempre bom evitar expor o modelo da base diretamente para o cliente da API. Para esse caso, pode-se criar uma classe com todos os atributos da classe Contact, exceto o atributo id (ou uma classe com atributos que facilite a manipulação dos dados por um front-end por exemplo).

Pode-se ainda desenvolver uma série de validações para melhorar esse código. Por exemplo, pode-se adicionar uma validação para garantir que o id do registro passado como parâmetro é o mesmo id passado na URL. Pode-se também utilizar a API Java Beans para aplicar validações de tamanho de campo, obrigatoriedade de atributos, etc. É aqui que entrar toda a lógica de negócio necessária para a aplicação funcionar da forma que se é esperado.*/

    @DeleteMapping(Endpoints.REQUEST_CONTATOS_FIND_GET_BY_ID)
    public ResponseEntity<Contato> deleteById(@PathVariable("id") Long id) throws Exception {
        try {
            contatoService.deleteContato(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Contato>)ResponseEntity.ok();
    }

//    @DeleteMapping(path ={"/{id}"})
//    public ResponseEntity <?> delete(@PathVariable long id) {
//        return repository.findById(id)
//                .map(record -> {
//                    repository.deleteById(id);
//                    return ResponseEntity.ok().build();
//                }).orElse(ResponseEntity.notFound().build());
//    }

    /*
    * Para remover um contato pelo ID, utiliza-se o id que foi passado como parâmetro para procurar se o registro existe na base. Caso exista, utiliza-se o método deleteById da interface JpaRepository e retorna o status HTTP 200 para indicar sucesso. Caso o registro não exista, retorna um erro HTTP 404.*/



    /*E a API RESTful CRUD está pronta! Um ponto importante é a anotação que foi utilizada em cada método que foi desenvolvido:

Listar todos os contatos - @GetMapping(“/contacts")
Obter um contato específico pelo ID - @GetMapping(“/co>@GetMapping(“/contacts/{id}”)
Remover um contato pelo ID - @GetMapping(“>@DeleteMapping(“/contacts/{id}”)
Criar um novo contato - @GetMapping(“/contact>@PostMapping(“/contacts)
Atualizar detalhes de um contato - @GetMapping(“>@PutMapping(“/contacts/{id}”)*/

}
