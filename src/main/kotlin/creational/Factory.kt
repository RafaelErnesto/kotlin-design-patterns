package creational

interface Dog{
    var weight: Double
    var color: String
    val breed: String
}

data class Rusky(
    override var weight: Double = 1.0,
    override var color: String = "White"
):Dog{
    override val breed: String = "Siberian Rusky"
}

data class Shiba(
    override var weight: Double = 1.0,
    override var color: String = "Yellow"

):Dog{
    override val breed: String = "Shiba Inu"
}

fun dogFactory(tag: String): Dog{
    return when(tag){
        "Shiba" -> Shiba()
        "Rusky" -> Rusky()
        else -> throw java.lang.RuntimeException("This tag does not exists")
    }
}

fun main(){
    val myShiba: Dog = dogFactory("Shiba")
    val myRusky: Dog = dogFactory("Rusky")
}