fun main() {
    val input = readLine()
    val (number1, number2) = input!!.split(" ").map { it.trim().toInt() }
    
    print(number1 + number2)
}