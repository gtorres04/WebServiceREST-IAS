package co.com.ias.pruebatecnica.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import co.com.ias.pruebatecnica.ws.dto.AveDto;
import co.com.ias.pruebatecnica.ws.response.dto.Dto;
import co.com.ias.pruebatecnica.ws.response.dto.ListaDto;
import co.com.ias.pruebatecnica.ws.response.dto.ResponseDto;
import co.com.ias.pruebatecnica.ws.service.IAveService;
import co.com.ias.pruebatecnica.ws.support.ConstantesMappingURL;
import co.com.ias.pruebatecnica.ws.support.Enumeraciones.CodigosResponseDto;
import co.com.ias.pruebatecnica.ws.support.Enumeraciones.EjecucionResponseDto;


@Controller
@RequestMapping("/api/ave")
public class AveController {
	
	@Autowired
	@Qualifier("AveServiceImpl")
	private IAveService iAveService;
	
	/**
	 * Se registra el ave en la base de datos.
	 * @param ave
	 * @return
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value=ConstantesMappingURL.REGISTRAR_URL_MAPPING, method = RequestMethod.POST)
	public ResponseEntity<Dto<AveDto>> registrar(@RequestBody AveDto aveDto){
		ResponseEntity<Dto<AveDto>> responseEntity;
		Dto<AveDto> dto = new Dto<>();
		iAveService.create(aveDto);
		dto.setObject(aveDto);
		dto.setCodigo(CodigosResponseDto.SUCCES.getValue());
		dto.setEjecucion(EjecucionResponseDto.SUCCES.getValue());
		responseEntity = new ResponseEntity<>(dto, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * se modifica el ave en la base de datos.
	 * @param ave
	 * @return
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value=ConstantesMappingURL.EDITAR_URL_MAPPING, method = RequestMethod.POST)
	public ResponseEntity<Dto<AveDto>> editar(@RequestBody AveDto aveDto){
		ResponseEntity<Dto<AveDto>> responseEntity;
		Dto<AveDto> dto = new Dto<>();
		iAveService.update(aveDto);
		dto.setObject(aveDto);
		dto.setCodigo(CodigosResponseDto.SUCCES.getValue());
		dto.setEjecucion(EjecucionResponseDto.SUCCES.getValue());
		responseEntity = new ResponseEntity<>(dto, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * se modifica el ave en la base de datos.
	 * @param ave
	 * @return
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value=ConstantesMappingURL.ELIMINAR_URL_MAPPING, method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> eliminar(@RequestBody AveDto aveDto){
		ResponseEntity<ResponseDto> responseEntity;
		ResponseDto responseDto = new ResponseDto();
		iAveService.delete(aveDto);
		responseDto.setCodigo(CodigosResponseDto.SUCCES.getValue());
		responseDto.setEjecucion(EjecucionResponseDto.SUCCES.getValue());
		responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * Se listan todos los aves.
	 * @return
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value=ConstantesMappingURL.LISTAR_URL_MAPPING, method = RequestMethod.GET)
	public ResponseEntity<ListaDto<AveDto>> listar(){
		ResponseEntity<ListaDto<AveDto>> responseEntity;
		List<AveDto> aveDtos = iAveService.findAll(AveDto.class);
		ListaDto<AveDto> listaDto = new ListaDto<>();
		listaDto.setList(aveDtos);
		listaDto.setCodigo(CodigosResponseDto.SUCCES.getValue());
		listaDto.setEjecucion(EjecucionResponseDto.SUCCES.getValue());
		responseEntity = new ResponseEntity<>(listaDto, HttpStatus.OK);
		return responseEntity;
	}

}