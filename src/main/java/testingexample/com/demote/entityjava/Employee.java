package testingexample.com.demote.entityjava;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

	
	@Id
	private Long id;
	private String name;
	private String mail;
	
	/*
	 * @Transient private int value;
	 */}
