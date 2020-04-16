import java.util.*

fun main()=with(Scanner(System.`in`)){
    val x= nextLine()
    var pipeCount:Int=0
    var stack=Stack<Int>()
    for((index,value) in x.withIndex()){
        if(value.equals('(')){
            stack.push(index)
        }
        else{
            if(stack.peek()-index==-1){
                //레이저라면
                stack.pop()
                pipeCount+=stack.size
            }
            else{
                stack.pop()
                pipeCount++
            }
        }

    }

    println(pipeCount)


}
