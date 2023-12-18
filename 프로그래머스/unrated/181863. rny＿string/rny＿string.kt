class Solution {
    fun solution(rny_string: String): String {
        //var answer: String = ""
        val chars: List<Char> = rny_string.toList()
        val answer = chars.map { char ->
            if(char == 'm') {
                "rn"
            } else char
        }.joinToString("")
        return answer
    }
}