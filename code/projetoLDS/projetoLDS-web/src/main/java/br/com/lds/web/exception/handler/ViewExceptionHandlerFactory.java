package br.com.lds.web.exception.handler;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class ViewExceptionHandlerFactory extends ExceptionHandlerFactory {
	private ExceptionHandlerFactory parent;

	public ViewExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler handler = new ViewExceptionHandler(parent.getExceptionHandler());
		return handler;
	}

}