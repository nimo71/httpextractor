package httpextractor;

import httpextractor.extractors.Optional;
import httpextractor.extractors.RequestExtractor;
import httpextractor.matchers.RequestMatcher;

import javax.servlet.http.HttpServletRequest;


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
	
	public <T> Optional<T> extract(RequestExtractor<T> extractor) {
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
