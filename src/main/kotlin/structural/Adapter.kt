package structural

class Mp4Format(override var size: Double): Mp4{
    override val format: String = "Mp4"
}

interface Mvi{
    val format: String
    val size: Double
}

interface Mp4{
    val format: String
    val size: Double
}

class MviFormat(override var size: Double): Mvi {
    override val format: String = "Mvi"
}

fun Mp4Format.toMvi(): Mvi {
    return MviFormat(size = 12.4)
}

fun executeMvi(mviVideo: Mvi) {
    println("Executing: "+mviVideo.format+", of size: "+mviVideo.size)
}

fun main(){
    val mp4Object = Mp4Format(size = 12.4)
    executeMvi(mp4Object.toMvi())
}