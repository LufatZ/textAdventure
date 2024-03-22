package entities

open class Entity(var health:Double = 10.0,val name:String, var damage: Double = 1.0){
    fun receiveDamage(dealDamage: Double) {
        //TODO
        health -= dealDamage
    }
    fun dealDamage():Double{
        //TODO
        return damage
    }
    fun isDead():Boolean{
        return health <= 0
    }
}