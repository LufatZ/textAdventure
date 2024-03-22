package world.event

import entities.Entity
import entities.Player

class Fight {
    fun fight(player: Player, entity: Entity){
        var fighter = (0..1).random()
        println("fight beginns: ${player.name} vs ${entity.name}")
        while (!player.isDead()&&!entity.isDead()) {
            if (fighter == 0) {
                entity.receiveDamage(player.dealDamage())
            } else {
                player.receiveDamage(entity.dealDamage())
            }
            fighter++
            fighter%=2
            println("remaining Health: \n${player.name}    ${player.health}\n${entity.name}    ${entity.health}")
        }
        if (player.isDead()){
            player.death()
        }
    }
}
