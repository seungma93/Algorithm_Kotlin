fun main(args: Array<String>) {
    val s1 = readLine()!!
    
    val result = s1.map{
        val char = it.toChar()
        when(char.isUpperCase()) {
            true -> char.toLowerCase()
            false -> char.toUpperCase()
        }
    }.joinToString("")
    
    print(result)
}