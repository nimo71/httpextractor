package httpextractor;

import httpextractor.extractors.RequestExtractor;

import javax.servlet.http.HttpServletRequest;

import matchers.RequestMatcher;

public class Request {
	public HttpServletRequest servletRequest;
	
	public Request(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	public Boolean match(RequestMatcher... matchers) {
		for (RequestMatcher c : matchers) {
			if (!c.match(this)) return false; 
		}
		return true;
	}
	
	public <T> T extract(RequestExtractor<T> extractor) {
		return extractor.extract(this);
	}

	public String method() {
		return servletRequest.getMethod();
	}

	public String path() {
		return servletRequest.getPathInfo();
	}

	public String param(String name) {
		return servletRequest.getParameter(name);
	}
}
