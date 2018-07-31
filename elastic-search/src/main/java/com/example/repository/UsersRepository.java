package com.example.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.pojo.Users;

@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UsersRepository extends ElasticsearchRepository<Users, Long> {
	List<Users> findByName(String text);

	List<Users> findBySalary(Long salary);
}
