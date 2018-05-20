package com.kristijangeorgiev.elasticsearch.controller;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kristijangeorgiev.elasticsearch.entity.User;
import com.kristijangeorgiev.elasticsearch.entity.projection.UserProjection;
import com.kristijangeorgiev.elasticsearch.repository.elasticsearch.UserElasticSearchRepository;
import com.kristijangeorgiev.elasticsearch.repository.jpa.UserJpaRepository;
import com.kristijangeorgiev.elasticsearch.util.UserResourceAssembler;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private ProjectionFactory projectionFactory;

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Autowired
	private UserElasticSearchRepository userElasticSearchRepository;

	@Autowired
	private PagedResourcesAssembler<UserProjection> projectionPagedAssembler;

	@Autowired
	private PagedResourcesAssembler<User> entityPagedAssembler;

	@Autowired
	private UserResourceAssembler userResourceAssembler;

	// Query for Entity
	@GetMapping("/query")
	public ResponseEntity<?> query(@RequestParam("q") String query, Pageable p) {
		return ResponseEntity.ok(entityPagedAssembler.toResource(
				(Page<User>) userElasticSearchRepository.search(QueryBuilders.queryStringQuery(query), p),
				userResourceAssembler));
	}

	// Query for Projection
	@GetMapping("/queryProjection")
	public ResponseEntity<?> queryProjection(@RequestParam("q") String query, Pageable p) {
		return ResponseEntity.ok(projectionPagedAssembler.toResource(
				(Page<UserProjection>) userElasticSearchRepository.search(QueryBuilders.queryStringQuery(query), p)
						.map(user -> projectionFactory.createProjection(UserProjection.class, user))));
	}

	@GetMapping("/clear")
	public ResponseEntity<?> manualClear() {
		userElasticSearchRepository.deleteAll();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/add")
	public ResponseEntity<?> manualAdd() {
		userElasticSearchRepository.deleteAll();
		userElasticSearchRepository.saveAll(userJpaRepository.findAll());
		return ResponseEntity.ok().build();
	}

}
