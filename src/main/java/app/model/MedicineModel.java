package app.model;

import app.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicineModel {

	private String id;
	
	private String name;
	private String description;
	private String barcode_no;
	private String type;
	private boolean prescription_needed;
	private CategoryEntity category_entity;
}
