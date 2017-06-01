package br.edu.ifce.aracati.computacao.guitura.restful;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.aracati.computacao.guitura.bo.AtrativoTuristicoNaturalBO;
import br.edu.ifce.aracati.computacao.guitura.entitys.AtrativoTuristicoNatural;

@RestController
@RequestMapping(value="/guitura/rest")
public class AtrativoTuristicoNaturalRest {

	@Inject
	private AtrativoTuristicoNaturalBO atNaturalBO;
	
	/** 
	 * http://localhost:porta/guitura/api/atrativoTuristicoNatural/{id}
	 * @return
	 */
	@RequestMapping(value="/atrativoTuristicoNatural/{id}", method=RequestMethod.GET)
	public ResponseEntity<AtrativoTuristicoNatural> buscarAtrativoTuristicoNaturalPorId(@PathVariable("id") Long id){
		AtrativoTuristicoNatural atrativoTuristico = atNaturalBO.buscarPorId(id);
		if(atrativoTuristico != null) {
			return new ResponseEntity<>(atrativoTuristico, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
