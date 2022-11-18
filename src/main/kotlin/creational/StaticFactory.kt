package creational

class Quote {
    var value: String

    private constructor(value:String){
        this.value = value
    }

    companion object{
        fun valueOf(value: String): Quote =
            if(value.isEmpty()) {
                throw java.lang.RuntimeException("Quote cannot be empty")
            } else
                Quote(value)
    }
}


fun main(){
    val myQuote = Quote.valueOf("The sky is blue")
    println(myQuote.value)
}