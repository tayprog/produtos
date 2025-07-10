package com.apiproduto.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.apiproduto.api.models.Produto;
import com.apiproduto.api.models.ProdutoRepository;

@Controller
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/")
    public String listarProdutos(Model model) {
        model.addAttribute("todosOdProdutos", repository.findAll());
        return "listar";
    }

    @GetMapping("/cadastro")
    public String mostrarProdutos(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }

    @PostMapping("/cadastro")
    public String cadastrarProdutos(Produto produto) {
        repository.save(produto);
        return "cadastrar";
    }
}
