package creational

//common builder implementation
class HttpHeaderBuilder {
    private lateinit var contentType: String
    private var cookie: String? = null
    private var token: String? = null
    private var custom = mutableListOf<String>()

    class HttpHeader internal constructor(
        val contentType: String,
        val cookie: String?,
        val token: String?,
        val custom: List<String>,
    )

    fun contentType(value: String): HttpHeaderBuilder {
        contentType = value
        return this
    }

    fun cookie(value: String): HttpHeaderBuilder {
        cookie = value
        return this
    }

    fun token(value: String): HttpHeaderBuilder{
        token = value
        return this
    }

    fun custom(value: String): HttpHeaderBuilder {
        custom.add(value)
        return this
    }

    fun build(): HttpHeader {
        return HttpHeader(contentType, cookie, token, custom)
    }
}

//another way of implementing a builder in koltin
data class HttpHeader2(
    var contentType: String
){
    private var cookie: String? = null
    private var token: String? = null
    private var custom = mutableListOf<String>()

    fun cookie(value: String) =  apply {
        cookie = value
    }

    fun token(value: String) = apply {
        token = value
    }

    fun custom(value: String) = apply {
        custom.add(value)
    }
}

fun main(){
    val header = HttpHeaderBuilder()
        .contentType("application/json")
        .token("jwt_token")
        .build()

    val header2 = HttpHeader2("application/json")
        .token("token")
}