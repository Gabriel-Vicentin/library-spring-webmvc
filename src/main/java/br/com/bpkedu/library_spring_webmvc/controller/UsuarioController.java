package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.domain.Usuario;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public String listarUsuarios(Model model){
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/listar";
    }

    @GetMapping("/{id:\\d+}")
    public String detalharUsuario(@PathVariable Long id, Model model){
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "usuarios/detalhar";
    }

    @GetMapping("/novo")
    public String formularioNovoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/novo";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/livros/listar";
    }

    @GetMapping("/editar/{id:\\d+}")
    public String formularioEditarUsuario(@PathVariable Long id, Model model){
        model.addAttribute("livro", usuarioService.buscarPorId(id));
        return "livros/editar";
    }


    @PostMapping("/editar/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        usuario.setId(id);
        usuarioService.salvar(usuario);
        return "redirect:/livros/listar";
    }

    @GetMapping("/deletar/{id:\\d+}")
    public String deletarUsuario(@PathVariable Long id){
        usuarioService.deletar(id);
        return "redirect:/usuarios/listar";
    }

}
