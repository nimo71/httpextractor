package matchers;

import httpextractor.Request;

public class RequestMatchers {
	
	public static final RequestMatcher GET = new RequestMatcher() {
		public Boolean match(Request req) { 
			return req.method().equals("GET"); 
		}
	};
	
	public static final RequestMatcher POST = new RequestMatcher() {
		public Boolean match(Request req) { 
			return req.method().equals("POST"); 
		}
	};

	public static RequestMatcher path(final String path) {
		return new RequestMatcher() {
			public Boolean match(Request req) {
				return req.path().equals(path);
			}
		};
	}
}
