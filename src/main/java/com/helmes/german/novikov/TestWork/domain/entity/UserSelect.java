package com.helmes.german.novikov.TestWork.domain.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user_select")
@TypeDef(name = "json", typeClass = JsonType.class)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class UserSelect {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@Getter
	private String name;

	@Type(type = "json")
	@Column(columnDefinition = "json")
	@Getter
	private List<Long> sectors;

	@Getter
	@Column(name = "agree_with_terms")
	private boolean agreedWithTerms;

	public UserSelect(String name, List<Long> sectors, boolean agreedWithTerms) {
		this.name = name;
		this.sectors = sectors;
		this.agreedWithTerms = agreedWithTerms;
	}

	public void update(String name, List<Long> sectors, boolean agreedWithTerms) {
		this.name = name;
		this.sectors = sectors;
		this.agreedWithTerms = agreedWithTerms;
	}
}
