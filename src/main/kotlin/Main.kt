import entities.Player
import items.Item
import world.World

fun main() {
    val player: Player = Player()
    val feld: World = World()

    feld.spawnPlayer()
    while(!player.isDead()){
        println("Where do you want to go? N | O (E) | S | W")
        var input = readln().filter { it.isLetter() }.uppercase()
        when(input){
            "N" -> {
                feld.movePlayer(1,0)
            }
            "O", "E" -> {
                feld.movePlayer(0,1)
            }
            "S" -> {
                feld.movePlayer(-1,0)
            }
            "W" -> {
                feld.movePlayer(0,-1)
            }
            else -> {
                println("Error: $input is no valid direction!")
            }
        }
        feld.interact()
        println("Do you want to use an item?")
        input = readln().filter { it.isLetter() }.uppercase()
        if (input[0] == 'J'){
            player.useItem()
        }
    }
}