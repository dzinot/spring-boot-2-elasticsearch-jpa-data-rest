package com.kristijangeorgiev.elasticsearch.entity.projection;

import java.time.LocalDate;

import org.springframework.data.rest.core.config.Projection;

import com.kristijangeorgiev.elasticsearch.entity.Profile;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@Projection(name = "profileProjection", types = Profile.class)
public interface ProfileProjection {

	String getFirstName();

	String getLastName();

	Integer getPoints();

	LocalDate getBirthDate();

}
