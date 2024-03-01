package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Editora;

@Service
public class EditoraService {
		List<Editora> lista = new ArrayList<>();
		
		public String save(Editora obj) {
			lista.add(obj);
			return obj.getNome()+ "Editora salva com sucesso.";
		}
		public List<Editora> listAll(){
			return lista;
		}
		public String update(long id, Editora obj) {
			
			lista = this.listAll();
			
			if(lista != null) {
				for(int i = 0; i<lista.size();i++) {
					if(lista.get(i).getId() == id) {
						lista.set(i, obj);
						return obj.getNome()+ "Editora atualizada com sucesso";
					}
				} 
			}
			return "registro não encontrado";
		}
		public Editora findById(long idEditora) {
			
			lista = this.listAll();
			
			if(lista != null) {
				for(int i = 0; i<lista.size(); i++) {
					if(lista.get(i).getId() == idEditora) {
						return lista.get(i);
					}
				}
			}
			return null;
		}
		public String delete(long idEditora) {
			
			lista = this.listAll();
			String msg = "Não foi possivél excluir a lista.";
			if(lista != null) {
				for(int i = 0; i<lista.size(); i++) {
					lista.remove(lista.get(i));
					msg =  "Excluido com sucesso!";
				}
			}
			return msg;
		}
	}