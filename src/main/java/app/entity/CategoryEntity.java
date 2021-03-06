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
@Document(collection="CATEGORY")
public class CategoryEntity {

	@Id private String id;
	private String name;
	private String description;
	private String image;
	private int count;
	
	@Builder.Default
	private boolean active = false;
}
