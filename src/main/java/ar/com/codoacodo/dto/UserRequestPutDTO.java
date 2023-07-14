package ar.com.codoacodo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class UserRequestPutDTO {

	@NotNull //tipo numerico
	private Long id; 
	@NotBlank //tipo string
	private String password;
}
