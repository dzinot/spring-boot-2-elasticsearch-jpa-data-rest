package com.kristijangeorgiev.elasticsearch.entity.projection;

import java.time.LocalDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.kristijangeorgiev.elasticsearch.entity.User;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@Projection(name = "userProjection", types = User.class)
public interface UserProjection {

	String getUsername();

	String getEmail();

	ProfileProjection getProfile();

	LocalDateTime getCreatedOn();

	LocalDateTime getUpdatedOn();

}
