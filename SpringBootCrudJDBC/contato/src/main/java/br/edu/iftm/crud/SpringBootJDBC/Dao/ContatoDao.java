package br.edu.iftm.crud.SpringBootJDBC.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.crud.SpringBootJDBC.domain.Contato;





@Component
public class ContatoDao {

	@Autowired
	JdbcTemplate db;
	

	public List<Contato> getContatos() {
		String sql = "select  nome,email,telefone,cpf from tb_contatos";

		return db.query(sql, (res, rowNum) -> {
			return new Contato(
					res.getString("nome"),
					res.getString("email"),
					res.getString("telefone"),
					res.getString("cpf"));
		});
	}

	public List<Contato> getContatos(String nome) {
		String sql = "select  email,nome,telefone,cpf from tb_contatos where lower(nome) like ?";

		return db.query(sql,
				new BeanPropertyRowMapper<>(Contato.class),
				new Object[] { "%" + nome + "%" });
	}

	public Contato getContato(String email) {
		String sql = "select  email,nome,telefone,cpf from tb_contatos where email = ?";

		List<Contato> contatos = db.query(sql,
				new BeanPropertyRowMapper<>(Contato.class),
				new Object[] { email });
		if (contatos != null && contatos.size() > 0) {
			return contatos.get(0);
		} else {
			return null;
		}
	}

	public void inserirContato(Contato contato) {
		String sql = "insert into tb_contatos(email,nome,telefone,cpf) values(?,?,?,?)";
		db.update(sql, new Object[] { contato.getEmail(), contato.getNome(), contato.getTelefone(),contato.getCpf()});
	}
	
	

	public void updateContato(Contato contato) {
		
	
		String sql = "update tb_contatos set nome = ?, telefone = ?, cpf = ? where email = ?";
		db.update(sql, new Object[] { contato.getNome(), contato.getTelefone(),contato.getCpf(), contato.getEmail() });
		
	}
	



	public void deleteContato(String email) {
		String sql = "delete from tb_contatos where email = ?";

		db.update(sql, new Object[] { email });
	}
	

}