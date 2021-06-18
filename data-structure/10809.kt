val alphabet=IntArray(26){-1}
fun main(){
    val s= readLine()
    for(i in s!!){
        val index=s.indexOf(i)
        when(i){
            'a'->findAlphabetIndex(0,index)
            'b'-> findAlphabetIndex(1,index)
            'c'->findAlphabetIndex(2,index)
            'd'->findAlphabetIndex(3,index)
            'e'->findAlphabetIndex(4,index)
            'f'->findAlphabetIndex(5,index)
            'g'->findAlphabetIndex(6,index)
            'h'->findAlphabetIndex(7,index)
            'i'->findAlphabetIndex(8,index)
            'j'->findAlphabetIndex(9,index)
            'k'->findAlphabetIndex(10,index)
            'l'->findAlphabetIndex(11,index)
            'm'->findAlphabetIndex(12,index)
            'n'->findAlphabetIndex(13,index)
            'o'->findAlphabetIndex(14,index)
            'p'->findAlphabetIndex(15,index)
            'q'->findAlphabetIndex(16,index)
            'r'->findAlphabetIndex(17,index)
            's'->findAlphabetIndex(18,index)
            't'->findAlphabetIndex(19,index)
            'u'->findAlphabetIndex(20,index)
            'v'->findAlphabetIndex(21,index)
            'w'->findAlphabetIndex(22,index)
            'x'->findAlphabetIndex(23,index)
            'y'->findAlphabetIndex(24,index)
            'z'->findAlphabetIndex(25,index)
        }
    }

    for(j in alphabet){
        print("$j ")
    }
}
fun findAlphabetIndex(a:Int,b:Int){
    if(alphabet[a]==-1) alphabet[a]=b
}
