package httpextractor;


public class HtmlResponse implements Response {
	public static final String TEXT_HTML_CHARSET_UTF_8 = "text/html;charset=UTF-8";
	
	private final String html;
	
	public HtmlResponse(String html) {
		this.html = html;
	}

	@Override
	public String contentType() {
		return TEXT_HTML_CHARSET_UTF_8;
	}

	@Override
	public void apply(Responder responder) {
		responder.body(html);
	}
}
