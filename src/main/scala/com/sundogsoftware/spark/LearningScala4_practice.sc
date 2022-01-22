

val captaionStuff = ("Picard", "Enterprise-D", "NCC-1701-D")
println(captaionStuff)

// Refer to the individual fields with a ONE-BASED index
println(captaionStuff._1)
println(captaionStuff._2)
println(captaionStuff._3)

val picardShip = "Picard" -> "Enterprise-D"
println(picardShip._2)
println(picardShip._1)

val aBunchOfSturff = ("Kick", 1964, true) // different data type

// Lists
// Like a tuple, but more functionality
// Must be of same type

val shipList = List("Enterprise", "Defiant", "Voyager", "Deep Sea")
println(shipList(1)) // Unlike Tuple, ZERO-BASED index
println(shipList(0))

println(shipList.head)
println(shipList.tail) // excluding head element

for (ship <- shipList) {
  println(ship)
}
val backwardShips = shipList.map((ship: String) => {ship.reverse})

for (ship <- backwardShips) {println(ship)}

// reduce() to combine together all the items in a collection
val numberList = List(1, 2, 3, 4, 5)
val sum = numberList.reduce( (x : Int, y: Int) => x + y)
println(sum)

// filter() remove stuff
val iHateFives = numberList.filter((x : Int) => x != 5)
println(iHateFives)

val iHateThrees = numberList.filter(_ != 3)

// concatenate lists
val moreNumbers = List(6,7,8)
val lotsOfNumbers = numberList ++ moreNumbers

val revered = numberList.reverse

val sorted = revered.sorted

val lotsOfDuplicates = numberList ++ numberList
val distinctValues = lotsOfDuplicates.distinct

val maxValue = numberList.max
val total = numberList.sum

val hasThree = iHateThrees.contains(3)

// Maps
val shipMap = Map("Kirk" -> "Enterprise", "Picard" -> "Enterprise-D", "Sisko" -> "Deep Space Nine")
println(shipMap("Kirk"))
println(shipMap.contains("Archer"))

val archersShip = util.Try(shipMap("Archer")) getOrElse "Unknown"
println(archersShip)

// EXERCISE
// Create a list of the numbers 1-20; your job is to print out numbers that are evenly divisible by three. (Scala's
// modula operator, like other languages, is %, which gives you the remainder after division. For example, 9 % 3 = 0
// because 9 is evenly divisible by 3.) Do this first by iterating through all the items in the list and testing each
// one as you go. Then, do it again by using a filter function on the list instead.

val numList = (1 to 20).toList
val divinedByThree = numList.filter(_%3 == 0)