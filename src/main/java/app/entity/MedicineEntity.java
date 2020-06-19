package app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="MEDICINES")
public class MedicineEntity {

	@Id
	private String id;
	
	private String name;
	private String description;
	private String barcode_no;
	private String type;
	private boolean prescription_needed;
	
}
