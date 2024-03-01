package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Livro;

@Service
public class LivroService {
		List<Livro> lista = new ArrayList<>();
		
		public String Save(Livro obj) {
			lista.add(obj);
			return obj.getTitulo()+ "Livro salvo com sucesso.";
		}
		public List<Livro> listAll(){
			return lista;
		}
		public String update(long id, Livro obj) {
					
					lista = this.listAll();
					
					if(lista != null) {
						for(int i = 0; i<lista.size();i++) {
							if(lista.get(i).getId() == id) {
								lista.set(i, obj);
								return obj.getTitulo()+ "Livro atualizado com sucesso";
							}
						} 
					}
					return "registro não encontrado";
				}
		public Livro findById(long idLivro) {
			
			lista = this.listAll();
			
			if(lista != null) {
				for(int i = 0; i<lista.size(); i++) {
					if(lista.get(i).getId() == idLivro) {
						return lista.get(i);
					}
				}
			}
			return null;
		}
		public String delete(long idLivro) {
			
			lista = this.listAll();
			String msg = "Não foi possivel excluir a lista";
			
			if(lista != null) {
				for(int i = 0; i<lista.size();i++) {
					lista.remove(lista.get(i));
					msg =  "lista excluida com sucesso";
				}
			}
			return msg;
		}	
	}
