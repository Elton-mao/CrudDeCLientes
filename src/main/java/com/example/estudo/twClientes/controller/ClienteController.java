package com.example.estudo.twClientes.controller;

import java.util.List;


import com.example.estudo.twClientes.model.Cliente;
import com.example.estudo.twClientes.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
private ClienteRepository clienteRepository ; 

    
@GetMapping()
public ModelAndView listar(){
        //chama a pagina html na view
        ModelAndView mView = new ModelAndView("clientes/listar.html") ;

        //recupera clientes salvos no banco de dados
        List <Cliente> clientes = clienteRepository.findAll();
        mView.addObject("clientes", clientes);
        return mView;
        
    }

@GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id){
        ModelAndView mView = new ModelAndView("clientes/detalhar.html");

        Cliente cliente = clienteRepository.getOne(id);
        mView.addObject("cliente", cliente);
      return mView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id){
        ModelAndView mView = new ModelAndView("redirect:/cliente");
        clienteRepository.deleteById(id);
        return mView; 
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView mView = new ModelAndView("clientes/cadastrar.html ");
        mView.addObject("cliente", new Cliente()); 
        
        return mView; 
    }
        @PostMapping("/cadastrar")
        public ModelAndView cadastrar(Cliente cliente) {

            ModelAndView mView= new ModelAndView("redirect:/cliente");
            clienteRepository.save(cliente);
            return mView; 
        }
        @GetMapping("/{id}/editar")
        public ModelAndView editar(@PathVariable Long id){
            ModelAndView mView = new ModelAndView("clientes/edicao");
    
            Cliente cliente = clienteRepository.getOne(id);
            mView.addObject("cliente", cliente); 
           
            return mView; 

        }
        @PostMapping("/{id}/editar")
            public ModelAndView editar(Cliente cliente){
                ModelAndView mView = new ModelAndView("redirect:/cliente") ;
                cliente = clienteRepository.save(cliente);

                return mView ; 
            }
    }
 
    

