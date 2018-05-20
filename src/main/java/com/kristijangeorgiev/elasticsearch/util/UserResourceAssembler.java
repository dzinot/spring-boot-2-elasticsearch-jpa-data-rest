package com.kristijangeorgiev.elasticsearch.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.kristijangeorgiev.elasticsearch.entity.User;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@Component
public class UserResourceAssembler implements ResourceAssembler<User, Resource<User>> {

	@Autowired
	private EntityLinks entityLinks;

	@Override
	public Resource<User> toResource(User user) {
		Link self = entityLinks.linkFor(User.class).slash(user.getId()).withSelfRel();
		Link rel = entityLinks.linkFor(User.class).slash(user.getId()).withRel("user");
		Link profile = entityLinks.linkFor(User.class).slash(user.getId()).slash("profile").withRel("profile");

		return new Resource<>(user, self, rel, profile);
	}

}
