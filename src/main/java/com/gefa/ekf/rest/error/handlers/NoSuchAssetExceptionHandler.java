package com.gefa.ekf.rest.error.handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.gefa.ekf.application.exceptions.NoSuchAssetException;
import com.gefa.ekf.rest.error.ErrorCodeNum;
import com.gefa.ekf.rest.error.GeneralErrorCode;

@Provider
public class NoSuchAssetExceptionHandler implements ExceptionMapper<NoSuchAssetException> {

	@Override
	public Response toResponse(NoSuchAssetException exception) {
		return Response.status(Status.NOT_FOUND)
				.entity(new GeneralErrorCode(String.valueOf(Status.NOT_FOUND),
						ErrorCodeNum.RESOORCE_NOT_FOUND.getUserMessage(), exception.getLocalizedMessage().toString()))
				.build();
	}

}
