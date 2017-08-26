package br.com.lds.web.mbean.page.comum;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 
 * Axxiom Soluções Tecnológicas
 * 
 * @author ajsantos
 * @date 20 de mar de 2017
 * @descriptions Implementação de operações basicas para Gerenciador de Manager
 *               Bean no JSF
 */
public abstract class BasicBean implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String url;

	private boolean mensagem = false;

	public Log log = LogFactory.getLog(getClass().getSimpleName());

	/**
	 * Retorna o usuario logado no sistema.
	 * 
	 * @return UsuarioExterno retorn E-mail caso contrário apenas o usuario.
	 */
	public String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			return auth.getName();
		}
		return null;
	}

	/**
	 * 
	 * @description retorna o objeto de autenticação do spring, con isso conseguimos
	 *              obter as informações necessários do ususário.
	 * @return {@link Authentication}
	 */
	public Authentication getAuthentication() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			return auth;
		}
		return null;
	}

	public void redirecionarPagina(String pagina) throws IOException {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		response.sendRedirect(pagina);
	}

	public void fecharModal(String idModal) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("$('#" + idModal + "').modal('close');");
	}

	public void exibirMensagemSucesso(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
	}

	public void exibirMensagemErro(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", mensagem));
	}

	public abstract void exibirMensagem();

	/**
	 * @description Construtor para os Beans JSF
	 */
	public abstract void preRenderView();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isMensagem() {
		return mensagem;
	}

	public void setMensagem(boolean mensagem) {
		this.mensagem = mensagem;
	}

}
