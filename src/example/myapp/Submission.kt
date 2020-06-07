package example.myapp

const val PETROL_ENGINE = "Petrol Engine"
const val ELECTRIC_ENGINE = "Electric Engine"

abstract class Vehicle {
    abstract val seats: Int
}

interface Engine {
    val engineType: String
}

object PetrolEngine : Engine {
    override val engineType = PETROL_ENGINE
}

object ElectricEngine : Engine {
    override val engineType = ELECTRIC_ENGINE
}

abstract class Car : Vehicle(), Engine {
    override val seats = 4
}

//delegation
class Tesla : Car(), Engine by ElectricEngine {
}

class Ford : Car(), Engine by PetrolEngine {
}

//extension function
fun Car.isEnvironmentFriendly(): Boolean {
    return this.engineType.equals(ELECTRIC_ENGINE)
}

fun main() {
    val myCar = Tesla()
    val yourCar = Ford()

    println ("My car is environment friendly :"+ myCar.isEnvironmentFriendly() )
    println ("Your car is environment friendly :"+ yourCar.isEnvironmentFriendly() )
}
