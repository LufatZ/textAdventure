package world

import entities.Entity
import entities.Npc
import entities.Ork
import entities.Player
import world.event.Fight
import items.consumable.HealingPotion
import items.Item
import items.weapon.WoodenSword
import kotlin.math.round
import kotlin.random.Random

class WorldFeld() {
    val items = mutableListOf<Item>()
    val entity = mutableListOf<Entity>()
    val player = Player.getInstance()

    init {
        if (Random.nextInt(0,100) > 80){
            items.add(HealingPotion(Random.nextInt(0,100)))
        }
        if (Random.nextInt(0,100) > 50) {
            entity.add(Ork(round(Random.nextDouble(0.0,20.0))))
        }else{
            entity.add(Npc(round(Random.nextDouble(0.0,10.0))))
        }
    }
    private fun interactMessage():String{
        val messages: List<String> = listOf(
            "What do you want to do?",
            "So, what's your next move, champ? The world awaits your brilliant decision.",
            "Alright, let's see if you've got what it takes. What's it gonna be?",
            "The spotlight is on you, adventurer. How will you dazzle us this time?"
        )
        val message = messages.indices.random()
        return messages[message]
    }
    fun interact(){
        if (entity.size > 0) {
            println("remaining Health: \n${player.name}    ${player.health}\n${entity[0].name}    ${entity[0].health}")
            println("attack Damage: \n${player.name}    ${player.damage}\n${entity[0].name}    ${entity[0].damage}")
            println("${interactMessage()} -> Fight | Run")
            val input: String = readln().filter { it.isLetter() }.uppercase()
            if (input == "FIGHT") {
                Fight().fight(player, entity[0])
                entity.remove(entity[0])
                if ((0..100).random() > 60) {
                    items.add(WoodenSword((50..100).random()))
                }
            }
        }
        if (items.size > 0){
            println("Do you want to loot?")
            println("Following loot is available: ${items.joinToString { it.name }}")
            val input:String = readln().filter { it.isLetter() }.uppercase()
            if (input[0] == 'J'||input[0] == 'Y'){
                for (i in items){
                    player.pickUpItem(i)
                }
            }
        }
    }
}