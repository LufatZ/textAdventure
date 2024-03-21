package world

class World {

    private var feld = Array(101){ _ -> Array(101){ _ -> WorldFeld()} }
    var posX: Int = 0
        private set
    var posY: Int = 0
        private set

    fun spawnPlayer() {
        posX = 50
        posY = 50
        TODO ("read save-game from file")
    }
    fun movePlayer(x: Int, y: Int) {
        posX = (posX + x).mod(100).coerceAtLeast(0)
        posY = (posY + y).mod(100).coerceAtLeast(0)
        println("Your coordinates are X:$posX and Y:$posY")
    }
    fun interact(){
        feld[posX][posY].interact()
    }
}