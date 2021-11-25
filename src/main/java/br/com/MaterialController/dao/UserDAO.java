package br.com.MaterialController.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.MaterialController.beans.User;

public interface UserDAO extends CrudRepository<User, Integer>{
	public User findByName(String name);

}
