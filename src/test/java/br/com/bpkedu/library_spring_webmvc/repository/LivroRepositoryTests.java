package br.com.bpkedu.library_spring_webmvc.repository;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class LivroRepositoryTests {

    @Autowired
    private LivroRepository livroRepository;


    @Test
    public void getLivrosTest(){
        List<Livro> livros = livroRepository.findByTitulo("Java para Leigos");

        System.out.println(livros);
    }

    @Test
    public void salvarTest(){
        Optional<Livro> livro = livroRepository.findById(Long.valueOf(1));

        System.out.println(livro.get());

        Livro updatelivro = livro.get();
        updatelivro.setAutor("Russel Norvig");

        updatelivro = livroRepository.save(updatelivro);

        List<Livro> livros = livroRepository.findByTitulo("Inteligencia artificial uma abordagem moderna");
    }
}
