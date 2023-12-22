
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


var swapCount = 0L
lateinit var tempArray: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())

    val inputArray = IntArray(n) { i ->
        st.nextToken().toInt()
    }

    tempArray = IntArray(n)

    mergeSort(inputArray, 0, n-1)

    println(swapCount)
}

fun mergeSort(numbers: IntArray, start: Int, end: Int) {
    //가장 작은 단위시 종료
    if (start == end) {
        return
    }

    val mid = (start + end) / 2
    // 가장 작은 단위까지 재귀
    mergeSort(numbers, start, mid)
    mergeSort(numbers, mid + 1, end)
    // 병합하면서 정렬함
    merge(numbers, start, end)
}

fun merge(numbers: IntArray, start: Int, end: Int) {
    val mid = (start + end) / 2
    var left = start
    var right = mid + 1
    var tempIndex = start

    while(left <= mid && right <= end) {
        // 꼭 등호는 왼쪽이 더 작거나 같은 조건으로 붙여야 한다.
        // 그렇지 않으면 왼쪽과 오른쪽 값이 같을 때 1을 더 계산하게 된다.
        if (numbers[left] <= numbers[right]){
            // 왼쪽 값이 더 작거나 같다 -> 오른쪽 배열에 자신보다 큰 값이 없다
            tempArray[tempIndex++] = numbers[left++]
        }else{
            tempArray[tempIndex++] = numbers[right++]
            swapCount += mid - left + 1
        }
    }

    // 왼쪽, 오른쪽 남아있는 배열 그대로 복사
    while (left <= mid) {
        tempArray[tempIndex++] = numbers[left++]
    }
    while (right <= end) {
        tempArray[tempIndex++] = numbers[right++]
    }

    // 임시 배열에 정렬한 값을 원래 배열에 반영
    for (i in start..end) {
        numbers[i] = tempArray[i]
    }
}