package br.edu.ifce.aracati.computacao.guitura.bo;

import java.util.NoSuchElementException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.edu.ifce.aracati.computacao.guitura.dao.AtrativoTuristicoNaturalDAO;
import br.edu.ifce.aracati.computacao.guitura.entitys.AtrativoTuristicoNatural;

@Service
public class AtrativoTuristicoNaturalBO {

	@Inject
	private AtrativoTuristicoNaturalDAO atNaturalDAO;
	
	public AtrativoTuristicoNatural buscarPorId(Long id) {
		AtrativoTuristicoNatural atrativoTuristico;
		try {
			atrativoTuristico = atNaturalDAO.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
		
		return atrativoTuristico;
	}
}
