package example.myapp

const val PETROL_ENGINE = "Petrol Engine"
const val ELECTRIC_ENGINE = "Electric Engine"

abstract class Vehicle<T> (val fuel : T) : Engine {
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

interface FuelType {
    val instantRefill : Boolean
}

class Petrol : FuelType {
    override val instantRefill = true
}

class Electricity : FuelType {
    override val instantRefill = false
}


//delegation
class Tesla : Vehicle<Electricity>(Electricity()), Engine by ElectricEngine {
    override val seats = 2
}

class Ford : Vehicle<Petrol>(Petrol()), Engine by PetrolEngine {
    override val seats = 4
}

//extension function
fun Tesla.isEnvironmentFriendly(): Boolean {
    return this.engineType.equals(ELECTRIC_ENGINE)
}

fun main() {
    val myCar = Tesla()
    val yourCar = Ford()

    println ("My car is environment friendly :"+ myCar.isEnvironmentFriendly() )
}
