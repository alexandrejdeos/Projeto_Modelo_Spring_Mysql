/**
 * 
 */
package br.com.lds.web.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

import br.com.lds.web.mbean.page.comum.BasicBean;

/**
 * @author lucas.vieira
 * @date 2017-06-07
 * @description Bean com as funcionalidades da tela de Manter Usuario
*/
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
