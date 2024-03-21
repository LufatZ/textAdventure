package items

import entities.Player

interface Item {
    var remainingDurability:Int
    fun use(player: Player)
}