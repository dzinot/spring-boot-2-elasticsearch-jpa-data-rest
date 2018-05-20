package com.kristijangeorgiev.elasticsearch.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

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
@Document(indexName = "profile", type = "profile")
public class Profile extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private Integer points;

	private LocalDate birthDate;

}
