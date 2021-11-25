package br.com.MaterialController.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.MaterialController.beans.Materials;

public interface MaterialsDAO extends CrudRepository<Materials, Integer> {
	
	public Materials findByType(String type);
}