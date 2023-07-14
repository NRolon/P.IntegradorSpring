package ar.com.codoacodo.service.feign;

import java.util.List;

import ar.com.codoacodo.dto.reqres.ListResource;
import feign.RequestLine;

public interface FeignResourceService {

	@RequestLine("GET")
    ListResource findAll();
	
	
	// feign + histryx + resilence4js
	
	
}
