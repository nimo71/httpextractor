package httpextractor;

public class SendRedirectResponse implements Response {

	private final String toUrl;

	public SendRedirectResponse(String toUrl) {
		if (toUrl == null) throw new ResponseException("Cannot redirect to null");
		this.toUrl = toUrl;
	}

	@Override
	public String contentType() {
		return HtmlResponse.TEXT_HTML_CHARSET_UTF_8;
	}

	@Override
	public void apply(Responder responder) {
		responder.redirect(toUrl);
	}

}
