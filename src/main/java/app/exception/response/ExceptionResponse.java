package app.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@EqualsAndHashCode@Builder
public class ExceptionResponse {

	private String errcode;
	private String errmessage;
	private String errgravity;
}
