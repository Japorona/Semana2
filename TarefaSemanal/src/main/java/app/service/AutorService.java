package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Autor;

@Service
public class AutorService {
		List<Autor> lista = new ArrayList<>();
		
		public String Save(Autor obj) {
			lista.add(obj);
			return obj.getNome()+ "Autor salvo com sucesso.";
		}
		public List<Autor> listAll(){
			return lista;
		}
		public String update(long id, Autor obj) {
					
					lista = this.listAll();
					
					if(lista != null) {
						for(int i = 0; i<lista.size();i++) {
							if(lista.get(i).getId() == id) {
								lista.set(i, obj);
								return obj.getNome()+ "Autor atualizado com sucesso";
							}
						} 
					}
					return "registro não encontrado";
				}
		public Autor findById(long idAutor) {
			
			lista = this.listAll();
			
			if(lista != null) {
				for(int i = 0; i<lista.size(); i++) {
					if(lista.get(i).getId() == idAutor) {
						return lista.get(i);
					}
				}
			}
			return null;
		}
		public String delete(long idAutor) {
			
			lista = this.listAll();
			String msg = "Não foi possivel excluir a lista";
			
			if(lista != null) {
				for(int i = 0; i<lista.size();i++) {
					lista.remove(lista.get(i));
					msg = "lista excluida com sucesso";
				}
			}
			return msg;
		}	
	}