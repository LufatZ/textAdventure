package items

import entities.Player

interface Item {
    var remainingDurability:Int
    val name:String
    fun use(player: Player)
}