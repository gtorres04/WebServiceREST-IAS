package co.com.ias.pruebatecnica.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import co.com.ias.pruebatecnica.ws.dto.PaisDto;
import co.com.ias.pruebatecnica.ws.response.dto.ListaDto;
import co.com.ias.pruebatecnica.ws.service.IPaisService;
import co.com.ias.pruebatecnica.ws.support.ConstantesMappingURL;
import co.com.ias.pruebatecnica.ws.support.Enumeraciones.CodigosResponseDto;
import co.com.ias.pruebatecnica.ws.support.Enumeraciones.EjecucionResponseDto;


@Controller
@RequestMapping("/api/pais")
public class PaisController {
	
	@Autowired
	@Qualifier("PaisServiceImpl")
	private IPaisService iPaisService;
	
	/**
	 * Se listan todos las Paiss.
	 * @return
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value=ConstantesMappingURL.LISTAR_URL_MAPPING, method = RequestMethod.GET)
	public ResponseEntity<ListaDto<PaisDto>> listar(){
		ResponseEntity<ListaDto<PaisDto>> responseEntity;
		List<PaisDto> paisDtos = iPaisService.findAll(PaisDto.class);
		ListaDto<PaisDto> listaDto = new ListaDto<>();
		listaDto.setList(paisDtos);
		listaDto.setCodigo(CodigosResponseDto.SUCCES.getValue());
		listaDto.setEjecucion(EjecucionResponseDto.SUCCES.getValue());
		responseEntity = new ResponseEntity<>(listaDto, HttpStatus.OK);
		return responseEntity;
	}

}