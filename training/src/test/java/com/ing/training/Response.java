package com.ing.training;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class Response {

    private HttpStatus httpStatus;
    private String body;

    public Response(final ClientHttpResponse response) throws IOException {

	if (response != null) {
	    httpStatus = response.getStatusCode();
	    InputStream responseStream = response.getBody();
	    body = getBody(responseStream);

	}

    }

    public HttpStatus getHttpstatus() {
	return httpStatus;
    }

    public String getBody(InputStream responseStream) throws IOException {
	return StreamUtils.copyToString(responseStream, StandardCharsets.UTF_8);

    }
}
