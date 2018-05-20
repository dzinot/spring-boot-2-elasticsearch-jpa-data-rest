package com.kristijangeorgiev.elasticsearch;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import com.kristijangeorgiev.elasticsearch.repository.elasticsearch.UserElasticSearchRepository;
import com.kristijangeorgiev.elasticsearch.repository.jpa.UserJpaRepository;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.kristijangeorgiev.elasticsearch.repository.jpa" })
@EnableElasticsearchRepositories(basePackages = "com.kristijangeorgiev.elasticsearch.repository.elasticsearch")
public class SpringBoot2ElasticsearchJpaDataRestApplication {

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Autowired
	private UserElasticSearchRepository userElasticSearchRepository;

	// This allows us to return a Projection from the controller
	@Bean
	public SpelAwareProxyProjectionFactory projectionFactory() {
		return new SpelAwareProxyProjectionFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2ElasticsearchJpaDataRestApplication.class, args);
	}

	@PostConstruct
	public void init() {
		userElasticSearchRepository.deleteAll();
		userElasticSearchRepository.saveAll(userJpaRepository.findAll());
	}
}
