package entities

import items.Item
import kotlin.system.exitProcess

class Player(health:Int = 100) : Entity(health) {
    companion object {
        private val instance: Player = Player()
        fun getInstance(): Player {
            return instance
        }
    }
    var inventory: MutableList<Item> = mutableListOf()
    val player = getInstance()
    fun death() {
        val message = listOf(
            "You really stepped in it this time, didn't you? Better luck on your next attempt!",
            "Wow, that was just sad. I can't believe you botched it that badly. Try not to embarrass yourself next time.",
            "Oops, looks like someone needs to go back to adventure rookie school! Don't worry, you'll get it someday.",
            "That attempt was about as effective as a sandpaper pillow. Maybe put a little more thought into it this time?",
            "Yeesh, I've seen zombies put up more of a fight than that. At least act like you're trying next time!",
            "You are a noop... A dead noop. Try again! Do it better next time!"
        )
        val number:Int = message.indices.random()
        println(message[number])
        exitProcess(1)
    }
    fun showInventory(): String {
        inventory = player.inventory
        val inventoryString = buildString {
            appendLine("\nINVENTORY")
            if (inventory.isNotEmpty()) {
                for ((index, item) in inventory.withIndex()) {
                    appendLine("    %-3s   %s".format(index, item))
                }
                appendLine("wich item do you want to use? -> \" + player.inventory.indices")
            } else {
                appendLine("Your inventory is empty.")
            }
        }
        return inventoryString
    }
    fun pickUpItem(i: Item) {
        inventory.add(i)
        println("you picked up $i")
    }
    private fun removeItem(i: Item) {
        //TODO
    }
    fun useItem(){
        println(showInventory())
        try {
            val number = readln().toInt()
            if (number in 0..player.inventory.size){
                val item:Item = player.inventory[number]
                item.use(this)
            }
        }catch (e: Exception){
            println("There is no item!")
        }
    }
}