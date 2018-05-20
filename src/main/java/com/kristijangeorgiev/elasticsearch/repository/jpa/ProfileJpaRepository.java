package com.kristijangeorgiev.elasticsearch.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kristijangeorgiev.elasticsearch.entity.Profile;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@RepositoryRestResource
public interface ProfileJpaRepository extends PagingAndSortingRepository<Profile, Long> {

}
