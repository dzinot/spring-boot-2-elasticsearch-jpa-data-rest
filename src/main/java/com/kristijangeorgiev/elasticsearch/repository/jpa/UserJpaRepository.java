package com.kristijangeorgiev.elasticsearch.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kristijangeorgiev.elasticsearch.entity.User;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@RepositoryRestResource
public interface UserJpaRepository extends PagingAndSortingRepository<User, Long> {

}
