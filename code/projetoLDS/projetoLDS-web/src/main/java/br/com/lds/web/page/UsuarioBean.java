/**
 * 
 */
package br.com.lds.web.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

import br.com.lds.web.mbean.page.comum.BasicBean;

@Component
@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean extends BasicBean {

	private static final long serialVersionUID = 8522156423349093114L;

	
	@Override
	public void exibirMensagem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preRenderView() {
		// TODO Auto-generated method stub
		
	}

	
}
