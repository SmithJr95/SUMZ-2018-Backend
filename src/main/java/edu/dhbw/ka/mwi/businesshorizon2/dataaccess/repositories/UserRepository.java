package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;

@Repository
public class UserRepository implements IUserRepository{

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(UserDao arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends UserDao> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<UserDao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserDao> findAllById(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserDao> findById(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDao> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDao> Iterable<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDao findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDao findByEmail(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
