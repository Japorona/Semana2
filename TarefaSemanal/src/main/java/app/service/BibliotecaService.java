package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Biblioteca;

@Service
public class BibliotecaService {
		List<Biblioteca> lista = new ArrayList<>();
		
		public String Save(Biblioteca biblioteca) {
			lista.add(biblioteca);
			return biblioteca.getNome()+ "Livro salvo com sucesso.";
		}
		public List<Biblioteca> listAll(){
			return lista;
		}
		public String update(long id, Biblioteca obj) {
					
					lista = this.listAll();
					
					if(lista != null) {
						for(int i = 0; i<lista.size();i++) {
							if(lista.get(i).getId() == id) {
								lista.set(i, obj);
								return obj.getNome()+ "Biblioteca atualizada com sucesso";
							}
						} 
					}
					return "registro não encontrado";
				}
		public Biblioteca findById(long idBiblioteca) {
			
			lista = this.listAll();
			
			if(lista != null) {
				for(int i=0; i<lista.size(); i++) {
					if(lista.get(i).getId() == idBiblioteca) {
						return lista.get(i);
					}
				}
			}
			return null;
				
		}
		public String delete(long idBiblioteca) {
			lista = this.listAll();
			String msg = "Não foi possivel excluir a lista";
			
			if(lista != null) {
				for(int i=0; i<lista.size();i++) {
					lista.remove(lista.get(i));
					msg = "Lista Excluida com sucesso";
				}
			}
			return msg;
		}	
	}