package com.my_project.newstest.model.network

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
enum class ServerStatus {

    OK {
        override fun getCode(): Int {
            return 200
        }

        override fun getDesk(): String {
            return "OK"
        }
    },
    CREATED {
        override fun getCode(): Int {
            return 201
        }

        override fun getDesk(): String {
            return "Created"
        }
    },
    ACCEPTED {
        override fun getCode(): Int {
            return 202
        }

        override fun getDesk(): String {
            return "Accepted"
        }
    },
    NO_CONTENT {
        override fun getCode(): Int {
            return 204
        }

        override fun getDesk(): String {
            return "No Content"
        }
    },
    RESET_CONTENT {
        override fun getCode(): Int {
            return 205
        }

        override fun getDesk(): String {
            return "Reset Content"
        }
    },
    PARTIAL_CONTENT {
        override fun getCode(): Int {
            return 206
        }

        override fun getDesk(): String {
            return "Partial Content"
        }
    },
    MOVED_PERMANENTLY {
        override fun getCode(): Int {
            return 301
        }

        override fun getDesk(): String {
            return "Moved Permanently"
        }
    },
    FOUND {
        override fun getCode(): Int {
            return 302
        }

        override fun getDesk(): String {
            return "Found"
        }
    },
    SEE_OTHER {
        override fun getCode(): Int {
            return 303
        }

        override fun getDesk(): String {
            return "See Other"
        }
    },
    NOT_MODIFIED {
        override fun getCode(): Int {
            return 304
        }

        override fun getDesk(): String {
            return "Not Modified"
        }
    },
    USE_PROXY {
        override fun getCode(): Int {
            return 305
        }

        override fun getDesk(): String {
            return "Use Proxy"
        }
    },
    TEMPORARY_REDIRECT {
        override fun getCode(): Int {
            return 307
        }

        override fun getDesk(): String {
            return "Temporary Redirect"
        }
    },
    BAD_REQUEST {
        override fun getCode(): Int {
            return 400
        }

        override fun getDesk(): String {
            return "Bad Request. The request was unacceptable, often due to a missing or misconfigured parameter"
        }
    },
    UNAUTHORIZED {
        override fun getCode(): Int {
            return 401
        }

        override fun getDesk(): String {
            return "Unauthorized. Your API key was missing from the request, or wasn't correct."
        }
    },
    PAYMENT_REQUIRED {
        override fun getCode(): Int {
            return 402
        }

        override fun getDesk(): String {
            return "Payment Required"
        }
    },
    FORBIDDEN {
        override fun getCode(): Int {
            return 403
        }

        override fun getDesk(): String {
            return "Forbidden"
        }
    },
    NOT_FOUND {
        override fun getCode(): Int {
            return 404
        }

        override fun getDesk(): String {
            return "Not Found"
        }
    },
    METHOD_NOT_ALLOWED {
        override fun getCode(): Int {
            return 405
        }

        override fun getDesk(): String {
            return "Method Not Allowed"
        }
    },
    NOT_ACCEPTABLE {
        override fun getCode(): Int {
            return 406
        }

        override fun getDesk(): String {
            return "Not Acceptable"
        }
    },
    PROXY_AUTHENTICATION_REQUIRED {
        override fun getCode(): Int {
            return 407
        }

        override fun getDesk(): String {
            return "Proxy Authentication Required"
        }
    },
    REQUEST_TIMEOUT {
        override fun getCode(): Int {
            return 408
        }

        override fun getDesk(): String {
            return "Request Timeout"
        }
    },
    CONFLICT {
        override fun getCode(): Int {
            return 409
        }

        override fun getDesk(): String {
            return "Conflict"
        }
    },
    GONE {
        override fun getCode(): Int {
            return 410
        }

        override fun getDesk(): String {
            return "Gone"
        }
    },
    LENGTH_REQUIRED {
        override fun getCode(): Int {
            return 411
        }

        override fun getDesk(): String {
            return "Length Required"
        }
    },
    PRECONDITION_FAILED {
        override fun getCode(): Int {
            return 412
        }

        override fun getDesk(): String {
            return "Precondition Failed"
        }
    },
    REQUEST_ENTITY_TOO_LARGE {
        override fun getCode(): Int {
            return 413
        }

        override fun getDesk(): String {
            return "Request Entity Too Large"
        }
    },
    REQUEST_URI_TOO_LONG {
        override fun getCode(): Int {
            return 414
        }

        override fun getDesk(): String {
            return "Request-URI Too Long"
        }
    },
    UNSUPPORTED_MEDIA_TYPE {
        override fun getCode(): Int {
            return 415
        }

        override fun getDesk(): String {
            return "Unsupported Media Type"
        }
    },
    REQUESTED_RANGE_NOT_SATISFIABLE {
        override fun getCode(): Int {
            return 416
        }

        override fun getDesk(): String {
            return "Requested Range Not Satisfiable"
        }
    },
    EXPECTATION_FAILED {
        override fun getCode(): Int {
            return 417
        }

        override fun getDesk(): String {
            return "Expectation Failed"
        }
    },

    TOO_MANY_REQUESTS{
        override fun getCode(): Int {
            return 429
        }

        override fun getDesk(): String {
            return "Too Many Requests. You made too many requests within a window of time and have been rate limited. Back off for a while."
        }
    },

    INTERNAL_SERVER_ERROR {
        override fun getCode(): Int {
            return 500
        }

        override fun getDesk(): String {
            return "Server Error. Something went wrong on our side."
        }
    },
    NOT_IMPLEMENTED {
        override fun getCode(): Int {
            return 501
        }

        override fun getDesk(): String {
            return "Not Implemented"
        }
    },
    BAD_GATEWAY {
        override fun getCode(): Int {
            return 502
        }

        override fun getDesk(): String {
            return "Bad Gateway"
        }
    },
    SERVICE_UNAVAILABLE {
        override fun getCode(): Int {
            return 503
        }

        override fun getDesk(): String {
            return "Service Unavailable"
        }
    },
    GATEWAY_TIMEOUT {
        override fun getCode(): Int {
            return 504
        }

        override fun getDesk(): String {
            return "Gateway Timeout"
        }
    },
    HTTP_VERSION_NOT_SUPPORTED {
        override fun getCode(): Int {
            return 505
        }

        override fun getDesk(): String {
            return "HTTP Version Not Supported"
        }
    };

    abstract fun getCode(): Int

    abstract fun getDesk(): String

    companion object {

        fun compareCode(code: Int): ServerStatus? {
            for (s in ServerStatus.values()) {
                if (code == s.getCode()) return s
            }
            return null
        }
    }
}



