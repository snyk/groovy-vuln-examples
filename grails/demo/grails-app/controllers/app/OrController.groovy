package app


class OrController {
    // localhost:8080/or?redirectUrl=https://google.com
    def index() {
        redirect url: params.redirectUrl
    }

    def bad_002() {
        def sanitizedUrl = "https://google.com/${params.redirectUrl}";

        redirect url: sanitizedUrl
	}
}