package com.kristijangeorgiev.elasticsearch.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(indexName = "user", type = "user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String email;

	@Lazy
	@OneToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

}
