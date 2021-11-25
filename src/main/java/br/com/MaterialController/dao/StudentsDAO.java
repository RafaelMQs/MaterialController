package br.com.MaterialController.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.MaterialController.beans.Students;

public interface StudentsDAO extends CrudRepository<Students, Integer>{
	
	public Students findByName(String name);
}
