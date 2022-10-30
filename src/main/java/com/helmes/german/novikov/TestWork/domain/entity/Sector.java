package com.helmes.german.novikov.TestWork.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sector")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Sector {

	@Id
	@Schema(nullable = false)
	private Long value;

	@Column
	@Getter
	@Schema(nullable = false)
	private String name;

	@Getter
	@Column
	@Schema(nullable = false)
	private long parent;

}
