package app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="PRODUCT")
public class ProductEntity {
	
	@Id
	private String id;
	
	private String name;
	private String decription;
	private String category_id;
	private String image;
	private String manf_loc;
	private boolean in_stock;
	private int rating;
	private int potency;
	private int quantity;
	
	@Builder.Default
	private boolean active = false;
	
}
