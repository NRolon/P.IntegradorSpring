package ar.com.codoacodo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codoacodo.dto.reqres.ListResource;
import ar.com.codoacodo.service.feign.FeignResourceService;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/resource") //es para que se llame user el recurso
@RequiredArgsConstructor

public class ResourceController {
	
	@Value(value = "${ENDPOINT_REQ_RES}") //INYECTAMOS Y ASIGNAMOS A UN PRIVATE
	
	private String apiEndpoint;
	 
	
	@GetMapping()
	public ResponseEntity<ListResource> findAll(){
		
		/*  1er forma de hacerlo con rest template
		RestTemplate restTemplate = new RestTemplate();
//		String fooResourceUrl = "http://localhost:8080/spring-rest/foos";
		ResponseEntity<ListResource> response = restTemplate.getForEntity(apiEndpoint, ListResource.class);
				
		// http status code=200
		return ResponseEntity.ok(response.getBody());
		*/
		
		//2da forma con feign ( la mas adecuada por el tema escalable)
		
		FeignResourceService response = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(FeignResourceService.class))
				  .logLevel(Logger.Level.FULL)
				  .target(FeignResourceService.class, apiEndpoint);
		
		
		
		return ResponseEntity.ok(response.findAll());
	}
	
	


}
