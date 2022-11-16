package creational

interface Greetings{
    fun hello()
}

object MySingleton;

object GreetingsSingleton: Greetings {
    override fun hello(){
        println("Hello")
    }
}


fun main(){
    val mySingleton1 = MySingleton
    val mySingleton2 = MySingleton

    val greetings1 = GreetingsSingleton
    val greetings2 = GreetingsSingleton

    println(mySingleton1 == mySingleton2)//true
    println(greetings1 == greetings2)//true
}