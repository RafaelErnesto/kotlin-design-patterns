package creational

interface Car{
    fun drive():Unit
}

interface AbstractCarFactory {
    fun createCar():Car
}

class RacingCar: Car {
    override fun drive() {
        println("Driving a racing car at 120 mp/h")
    }
}

class FamilyCar: Car {
    override fun drive(){
        println("Driving family car through the countryside")
    }
}

class RacingCarFactoryImpl: AbstractCarFactory {
    override fun createCar(): Car {
        return RacingCar()
    }
}

class FamilyCarFactoryImpl: AbstractCarFactory {
    override fun createCar(): Car {
        return FamilyCar()
    }
}

fun factoryResolver(carType: String): AbstractCarFactory {
    return when(carType){
        "racing" -> return RacingCarFactoryImpl()
        "family" -> return FamilyCarFactoryImpl()
        else -> throw java.lang.RuntimeException("Invalid type")
    }
}

fun main(){
    val carFactory = factoryResolver("racing")
    val car = carFactory.createCar()
    car.drive()
}

