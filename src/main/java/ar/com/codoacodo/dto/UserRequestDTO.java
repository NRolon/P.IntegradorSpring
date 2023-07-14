package ar.com.codoacodo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequestDTO { //request de entrada
	
	
	private String username;
	private String password;
	private List<String> roles;

	
}
