package br.edu.iftm.crud.SpringBootJDBC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.crud.SpringBootJDBC.Dao.ContatoDao;
import br.edu.iftm.crud.SpringBootJDBC.domain.Contato;


@Controller
public class ContatoController {

    @Autowired
    private ContatoDao dao;
   
    @RequestMapping("contatos")
    public String getContatos(Model model) {
        model.addAttribute("contato", new Contato());
        model.addAttribute("contatos", dao.getContatos());
        model.addAttribute("edit", false);
        
        return "create";
    }

    @PostMapping("contatos")
    public String inserirContatos(Contato contato, Model model) {
        Contato contatoEmail = dao.getContato(contato.getEmail());
        if (contatoEmail == null) {
            dao.inserirContato(contato); // Inserir um novo contato
        } else {
            dao.updateContato(contato); // Atualizar um contato existente
        }
        
        return getContatos(model);
    }

    @RequestMapping("delete")
    public String deleteContato(@RequestParam(value = "email", required = true) String email, Model model) {
        dao.deleteContato(email);
        return getContatos(model);
    }

    @RequestMapping("edit")
    public String editarContato(@RequestParam(value = "email", required = true) String email, Model model) {
        Contato contato = dao.getContato(email);
        model.addAttribute("contato", contato);
        model.addAttribute("contatos", dao.getContatos());
        model.addAttribute("edit", true);
        
        return "create";
    }
}