package httpextractor;


public class HtmlResponse implements Response {
	private static final String TEXT_HTML_CHARSET_UTF_8 = "text/html;charset=UTF-8";
	
	private final String html;
	
	public HtmlResponse(String html) {
		this.html = html;
	}
	
	public String body() {
		return html;
	}

	public String contentType() {
		return TEXT_HTML_CHARSET_UTF_8;
	}
}
