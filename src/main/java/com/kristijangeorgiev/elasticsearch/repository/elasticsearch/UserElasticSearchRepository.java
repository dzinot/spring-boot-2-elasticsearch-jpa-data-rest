package com.kristijangeorgiev.elasticsearch.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformationCreator;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kristijangeorgiev.elasticsearch.entity.User;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@RepositoryRestResource
public interface UserElasticSearchRepository
		extends ElasticsearchRepository<User, Long>, ElasticsearchEntityInformationCreator {

}
