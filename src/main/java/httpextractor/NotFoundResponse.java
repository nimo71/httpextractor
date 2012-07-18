package httpextractor;


public class NotFoundResponse implements Response {

	@Override
	public String contentType() {
		return HtmlResponse.TEXT_HTML_CHARSET_UTF_8;
	}

	@Override
	public void apply(Responder responder) {
		responder.notFound();
	}
}
