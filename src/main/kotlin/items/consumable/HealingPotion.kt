package items.consumable

import entities.Player

class HealingPotion(override var remainingDurability: Int, override val name: String="Healing Potion") :Potion {
    override fun use(player: Player) {
        player.health += remainingDurability
        if (player.health>100){
            player.health = 100.0
        }
        println("$player used a healing potion. Health: ${player.health}")
    }
}