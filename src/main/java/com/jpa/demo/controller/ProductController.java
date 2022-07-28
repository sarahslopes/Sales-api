ackage com.jpa.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jpa.demo.model.Product;
import com.jpa.demo.repository.ProductInterface;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired ProductInterface repo;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra produto")
    public @ResponseBody Product saveCustomer(@Valid Product product) {
       repo.save(product);
        return product;
    }

    @GetMapping("/list")
    @ApiOperation("Lista produtos cadastrados")
    public List<Product> listCustomer(){
        return repo.findAll();
    }

    @GetMapping(path ="/list/{id}")
    @ApiOperation("Lista produto por id")
    public Product listById(@PathVariable Integer id){
    Optional<Product> product = repo.findById(id);

        if(product.isPresent()){
            return product.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }

    @PutMapping(path = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Atualiza produto por id")
    public Product updateCustomer(@Valid Product product){
        saveCustomer(product);
        return product;
    }

    @DeleteMapping(path = "/delete/{id}" )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deleta produto por id")
    public void deleteCustomer(@PathVariable Integer id){
        repo.findById(id);

        repo.deleteById(id);
    }
}
