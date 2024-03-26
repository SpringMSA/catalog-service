package org.example.catalogservice.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.catalogservice.jpa.CatalogEntity;
import org.example.catalogservice.service.CatalogService;
import org.example.catalogservice.vo.ResponseCatalog;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog-service")
public class CatalogController {

	private final Environment env;
	private final CatalogService catalogService;

	@GetMapping("/health_check")
	public String status() {
		return String.format("Its Working in Catalog Service on PORT %s",
				env.getProperty("local.server.port"));
	}

	@GetMapping("/catalogs")
	public ResponseEntity<List<ResponseCatalog>> getAllCatalogs() {
		Iterable<CatalogEntity> catalogList = catalogService.getAllCatalogs();
		List<ResponseCatalog> result = new ArrayList<>();
		catalogList.forEach(v -> result.add(new ModelMapper().map(v, ResponseCatalog.class)));
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
