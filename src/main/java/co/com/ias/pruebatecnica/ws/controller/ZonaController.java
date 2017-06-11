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
import co.com.ias.pruebatecnica.ws.dto.ZonaDto;
import co.com.ias.pruebatecnica.ws.response.dto.ListaDto;
import co.com.ias.pruebatecnica.ws.service.IZonaService;
import co.com.ias.pruebatecnica.ws.support.ConstantesMappingURL;
import co.com.ias.pruebatecnica.ws.support.Enumeraciones.CodigosResponseDto;
import co.com.ias.pruebatecnica.ws.support.Enumeraciones.EjecucionResponseDto;


@Controller
@RequestMapping("/api/zona")
public class ZonaController {
	
	@Autowired
	@Qualifier("ZonaServiceImpl")
	private IZonaService iZonaService;
	
	/**
	 * Se listan todos las zonas.
	 * @return
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value=ConstantesMappingURL.LISTAR_URL_MAPPING, method = RequestMethod.GET)
	public ResponseEntity<ListaDto<ZonaDto>> listar(){
		ResponseEntity<ListaDto<ZonaDto>> responseEntity = null;
		List<ZonaDto> zonaDtos = iZonaService.findAll(ZonaDto.class);
		ListaDto<ZonaDto> listaDto = new ListaDto<>();
		listaDto.setList(zonaDtos);
		listaDto.setCodigo(CodigosResponseDto.SUCCES.getValue());
		listaDto.setEjecucion(EjecucionResponseDto.SUCCES.getValue());
		responseEntity = new ResponseEntity<>(listaDto, HttpStatus.OK);
		return responseEntity;
	}

}