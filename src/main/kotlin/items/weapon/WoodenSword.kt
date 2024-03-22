package items.weapon

import entities.Player
import items.Item

class WoodenSword(override var remainingDurability: Int, override val name: String="Wooden Sword") :Item {
    override fun use(player: Player) {
        player.damage *= (0.02*remainingDurability)
    }
}