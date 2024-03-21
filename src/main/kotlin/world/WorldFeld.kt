package world

import entities.Entity
import entities.Npc
import entities.Ork
import entities.Player
import event.Fight
import items.consumable.HealingPotion
import items.Item
import items.weapon.WoodenSword

class WorldFeld() {
    val items = mutableListOf<Item>()
    val entity = mutableListOf<Entity>()
    val player = Player.getInstance()

    init {
        if ((0..100).random() > 80){
            items.add(HealingPotion((0..100).random()))
        }
        if ((0..100).random() > 50) {
            entity.add(Ork((5..10).random()))
        }else{
            entity.add(Npc(10))
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
            println("remaining Health: \n$player    ${player.health}\n$entity    ${entity[0].health}")
            println("remaining Damage: \n$player    ${player.damage}\n$entity    ${entity[0].damage}")
            println("${interactMessage()} => Fight | Run")
            val input: String = readln().filter { it.isLetter() }.uppercase()
            if (input == "FIGHT") {
                Fight().fight(player, entity[0])
                entity.remove(entity[0])
                if ((0..100).random() > 10) {
                    items.add(WoodenSword((50..100).random()))
                }
            }
        }
        if (items.size > 0){
            println("Do you want to loot?")
            println("Following loot is available: $items")
            val input:String = readln().filter { it.isLetter() }.uppercase()
            if (input[0] == 'J'){
                for (i in items){
                    player.pickUpItem(i)
                }
            }
        }
    }
}