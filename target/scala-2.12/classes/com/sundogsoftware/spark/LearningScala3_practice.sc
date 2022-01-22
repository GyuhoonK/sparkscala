// Functions

// format def <function name>(parameter name: type ...) : return type = { }

def squareIt(x:Int) : Int = { // don't forget equal(=)
  x*x
}

def cubeIt(x:Int): Int={x*x*x}
println(squareIt(2))
println(cubeIt(3))

// 함수는 다른 함수를 매개변수로 사용할 수 있다
def transformInt(x:Int, f: Int => Int):Int ={
  f(x)
}
val result = transformInt(2, cubeIt)
println(result)

// lambda func
transformInt(3, x=>x*x*x)

transformInt(10, x => x/2)
// multi line lambda func
transformInt(2, x => {val y = x * 2; y*y})

// EXERCISE
// Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
// Write a function that converts a string to upper-case, and use that function of a few test strings.
// Then, do the same thing using a function literal instead of a separate, named function.

def upperIt(x:String): String={
  x.toUpperCase()
}
println(upperIt("foo"))
println(upperIt("myname"))

def applyF(x:String, f: String=>String):String ={
  f(x)
}
println(applyF("foo", upperIt))