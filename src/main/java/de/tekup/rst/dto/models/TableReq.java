package de.tekup.rst.dto.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

import de.tekup.rst.entities.TableType;
import lombok.Data;

@Data
public class TableReq {
	
	@Min(2)
	@Max(value = 10,message = "Nombre de couvert est au max 10.")
	private int nbCouverts;
	private TableType type;
	@PositiveOrZero
	private double supplement;

}
