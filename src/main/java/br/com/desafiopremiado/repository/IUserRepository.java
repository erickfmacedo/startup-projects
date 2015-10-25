package br.com.desafiopremiado.repository;


import br.com.desafiopremiado.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, String> {

    User findByName(String name);


}
