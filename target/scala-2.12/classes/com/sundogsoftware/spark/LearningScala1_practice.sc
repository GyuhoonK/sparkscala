// VALUES are immutable constants.
val hello : String = "Hola!"
// we can't change hello more.

// VARIABLES are mutable.
var helloThere: String = hello
helloThere = hello + " There!"

println(helloThere) // printLiNe

// 레이스 컨디션 ?

val immutableHelloThere = hello + " There!"
println(immutableHelloThere)

// Data Types
val numberOne: Int = 1
val truth : Boolean = true // true or false (lower case)
val letterA: Char = 'a'
val pi: Double = 3.14159265
val piSinglePrecision: Float = 3.14159265f // 부동소수점
val bigNumber: Long = 123456789
val smallNumber : Byte = 127 // signed : -127 ~ 127, unsigned : 0 ~ 255

println("Here is a mess : " + numberOne + truth + letterA + pi + bigNumber)

println(f"Pi is about $piSinglePrecision%.3f")
// $ -> val/varName , %.3f -> 소수점 세자리수까지 표시
println(f"Zero padding on the left : $numberOne%05d")
// %d

println(s"I can use the a prefix to use variables like $numberOne $truth $letterA")
//without +, concatenate variables

println(s"The Prefix isn't limited to variables; I can include any expression. Like ${1+2}")
// curly bracket : the result of expression

val theUltimateAnswer: String = "To Life, the universe, and everything is 42. "
val pattern = """.* ([\d]+).*""".r // .r means regex
val pattern(answerString) = theUltimateAnswer
val answer = answerString.toInt //Convert
println(answer)

val isGreater = 1>2
val isLesser = 1 < 2
val impossible = isGreater & isLesser // byte operator
val anotherway = isGreater || isLesser // logical operator

val picard: String = "Picard"
val bestCaption: String = "Picard"
val isBest: Boolean = picard == bestCaption

