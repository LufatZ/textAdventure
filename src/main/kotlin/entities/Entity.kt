package entities

open class Entity(var health:Int = 10, val damage: Int = 1){
    fun receiveDamage(dealDamage: Int) {
        //TODO
        health -= dealDamage
    }
    fun dealDamage():Int{
        //TODO
        return damage
    }
    fun isDead():Boolean{
        return health <= 0
    }
}