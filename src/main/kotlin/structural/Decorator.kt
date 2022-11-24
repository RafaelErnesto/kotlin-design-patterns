package structural

// decorate by composition
interface Airplane{
    fun canTakeOffFrom(): String
    fun canLandOn(): String
}


class ActualAirplane: Airplane {
    override fun canTakeOffFrom(): String {
        return "Can take off from: "
    }

    override fun canLandOn(): String {
        return "Can land on: "
    }

}


abstract class AirplaneDecorator(var airplane: Airplane): Airplane {


    override fun canTakeOffFrom(): String {
        return airplane.canTakeOffFrom()
    }

    override fun canLandOn(): String {
        return airplane.canLandOn()
    }
}

class HydroAirplaneDecorator(airplane: Airplane): AirplaneDecorator(airplane){
    override fun canTakeOffFrom(): String {
        return super.canTakeOffFrom() + " water"
    }

    override fun canLandOn(): String {
        return airplane.canLandOn() + " water"
    }
}

// decorate by delegation
class CargoAirplane(var airplane: Airplane): Airplane by airplane{
    override fun canTakeOffFrom(): String {
        return airplane.canTakeOffFrom() + " land"
    }

    override fun canLandOn(): String {
        return airplane.canLandOn() + " land"
    }
}

fun main(){
    var airplane: Airplane = ActualAirplane()
    airplane = HydroAirplaneDecorator(airplane)
    println(airplane.canTakeOffFrom())
    println(airplane.canLandOn())

    var airplane2: Airplane = ActualAirplane()
    airplane2 = CargoAirplane(airplane2)
    println(airplane2.canTakeOffFrom())
    println(airplane2.canLandOn())
}