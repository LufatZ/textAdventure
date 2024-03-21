package items.consumable

import entities.Player

class HealingPotion(override var remainingDurability: Int) :Potion {
    override fun use(player: Player) {
        player.health += remainingDurability
        println("")
        TODO("Not yet implemented")
    }
}