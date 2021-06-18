fun main(){
    val s= readLine()
    val alphabet= IntArray(26){0}

    for(i in s!!){
       when(i){
           'a'->alphabet[0]++
           'b'->alphabet[1]++
           'c'->alphabet[2]++
           'd'->alphabet[3]++
           'e'->alphabet[4]++
           'f'->alphabet[5]++
           'g'->alphabet[6]++
           'h'->alphabet[7]++
           'i'->alphabet[8]++
           'j'->alphabet[9]++
           'k'->alphabet[10]++
           'l'->alphabet[11]++
           'm'->alphabet[12]++
           'n'->alphabet[13]++
           'o'->alphabet[14]++
           'p'->alphabet[15]++
           'q'->alphabet[16]++
           'r'->alphabet[17]++
           's'->alphabet[18]++
           't'->alphabet[19]++
           'u'->alphabet[20]++
           'v'->alphabet[21]++
           'w'->alphabet[22]++
           'x'->alphabet[23]++
           'y'->alphabet[24]++
           'z'->alphabet[25]++
       }
    }
    for(j in alphabet){
        print("$j ")
    }
}