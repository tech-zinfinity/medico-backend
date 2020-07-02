package app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor@Builder
public class UpdateCategoryStatusWithProductsRequest {

	private String category_id;
	private boolean status;
	private List<String> prList;
}
