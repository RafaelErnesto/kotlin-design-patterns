package creational

data class Pet(
    var weight: Double,
    var age: Int,
    val name: String
)

fun main(){
    val pet1 = Pet(1.2, 2, "Bob")
    val pet2 = pet1.copy(name = "Ruf")
    println("Pet1 name: "+pet1.name)
    println("Pet2 name: "+pet2.name)
}