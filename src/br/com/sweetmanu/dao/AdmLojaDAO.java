package br.com.sweetmanu.dao;

import java.util.HashMap;

import br.com.sweetmanu.modelos.AdmLoja;

public class AdmLojaDAO {

	Integer idAdm = 0;
	HashMap<Integer, AdmLoja> listaDeAdmLoja = new HashMap<Integer, AdmLoja>();


	public void salvar(AdmLoja admLoja) {

		if(admLoja.getId() == null){
			this.idAdm++;
			admLoja.setId(this.idAdm);
			listaDeAdmLoja.put(this.idAdm, admLoja);
		}else{
			listaDeAdmLoja.put(admLoja.getId(), admLoja);
		}
		
	}

}
