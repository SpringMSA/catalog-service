package org.example.catalogservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog {

	private String productId;
	private String productName;
	private Integer unitPrice;
	private Integer stock;
	private LocalDate createdAt;
}
