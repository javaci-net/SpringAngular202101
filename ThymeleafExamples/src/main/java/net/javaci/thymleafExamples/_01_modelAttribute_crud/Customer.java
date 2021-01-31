package net.javaci.thymleafExamples._01_modelAttribute_crud;


import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.Size;
import javax.validation.constraints.Size;

import lombok.*;

@Data
public class Customer {
	
	@NotEmpty
	private String name;
	
	@Size(min = 2, max = 5)
	private String lastName;

}
