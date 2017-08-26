package br.com.lds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lds.model.entity.Acao;
import br.com.lds.model.repository.AcaoRepository;

@Service("acaoService")
@Transactional
public class AcaoServiceImpl implements AcaoService{

	@Autowired
	private AcaoRepository acaoRepository;
	
	@Override
	public List<Acao> buscarTodasAcoes() {
		return acaoRepository.findAll();
	}
	
	

}
