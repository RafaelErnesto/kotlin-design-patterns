package structural

interface House{
    fun info(): String
}

abstract class Material(private val house: House): House {
    override fun info(): String {
        return house.info()
    }

}

class BrickHouse(house: House): Material(house){
    override fun info(): String{
        return super.info() + " made of brick"
    }
}

class WoodHouse(house: House): Material(house){
    override fun info(): String{
        return super.info() + " made of wood"
    }
}

class OneBedroomHouse: House{
    override fun info(): String {
        return "A house with one bedroom"
    }
}

class ThreeBedroomHouse: House{
    override fun info(): String {
        return "A house with three bedroom"
    }
}

fun main(){
    val oneBedHouse = OneBedroomHouse()
    val threeBedroomHouse = ThreeBedroomHouse()
    val brickHouse = BrickHouse(oneBedHouse)
    val woodHouse = WoodHouse(threeBedroomHouse)
    println(brickHouse.info())
    println(woodHouse.info())
}