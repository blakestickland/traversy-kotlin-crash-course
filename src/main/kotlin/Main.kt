import java.util.*

fun main() {
    // Immutable variables are declared with keyword "val"
    val b = 1
    // Mutable variables are declared with "var"
    var a = 2
    a = 10
    // Variables cannot change their type once declared.
    // a= "ten" // this will throw a type mismatch error

    // Numbers
    val wholeNumber = 3
    val bigNumber = 3L
    // Decimals
    val preciseDecimal = 3.33
    val decimal = 3.33f
    // Boolean
    val iLoveVegetables = false
    val iLovePizza = true
    // Characters
    val iamALetter = 'A'
    // String
    val firstName = "Blake"
    // Arithmetic operators
    val x = 3 * 4   // 12
    println("The value of x is $x")
    val y = 3f / 4f // 0.75
    println("The value of y is $y")
    val z = 10 % 3
    println("The value of z is $z")

    // Logic operators
    val amIAnAdult = true
    val amIAProgrammer = true
    val amIAnAdultProgrammer = amIAnAdult && amIAProgrammer // true
    println(amIAnAdultProgrammer)
    val amIAnAdultProgrammer2 = amIAnAdult || amIAProgrammer // true
    println(amIAnAdultProgrammer2)
    val amIAnAdultProgrammer3 = amIAnAdult != amIAProgrammer // false
    println(amIAnAdultProgrammer3)
    val amIAnAdultProgrammer4 = amIAnAdult == amIAProgrammer // true
    println(amIAnAdultProgrammer4)

    // String methods are available
    val string = "Kotlin is the best language"
    println(string.uppercase(Locale.getDefault()))

    // conditionals
    val c = 1 + 3
    if (c == 2) {
        println("c is 2")
    } else if (c == 3) {
        println("c is 3")
    } else {
        println("c is neither 2 nor 3")
    }
    val v = if (c == 2) 2 else 3 // check if c is equal to 2; if so, assign value 2 to v; if not assign value 3 to v

    // null values and null pointer exceptions
    // Kotlin is a nul safe language and Java is not (Java would crash if we accessed a variable that contained null)
    // Kotlin will make sure when we press Run that nothing will crash our program
    val d: Int? = null


    // Calculator to add numbers with user input
//    val number1 = readLine()
//    val number2 = readLine()
//    val result = number1!!.toInt() + number2!!.toInt() // adding !! means we are certain the value will not be null
//    println(result) // This will work but could make the program crash which we want to prevent
//
//    // Instead....
//    val number3 = readLine()?.ifBlank { null } ?: "0" // will assign "0" if no user input
//    val number4 = readLine()?.ifBlank { null } ?: "0"
//    println(number3)
//    println(number4)
//    val result2 = number3.toInt() + number4.toInt()
//    println(result2)

    // ---------------------------

    val shoppingList = listOf<String>("Lamborghini", "Penthouse", "Rolex") // immutable list
    println(shoppingList[2]) // Will print out Rolex

    val shoppingListMutable = mutableListOf<String>("Lamborghini", "Penthouse", "Rolex")
    println(shoppingListMutable[1]) // Will print out Penthouse
    shoppingListMutable.add("Ferrari")
    println(shoppingListMutable[shoppingListMutable.size - 1]) // Will print out Ferrari

    // ----------
    // LOOPS (while loop and for loop)
    var counter = 0
    while (counter < shoppingListMutable.size)    {
        println(shoppingListMutable[counter]) // will print each item in list on new line
        counter++
    }
    // easier to achieve the same with a for loop

    for (shoppingItem in shoppingListMutable) {
        println(shoppingItem)
    }

    for (i in 1..10) {
        println(i)
    }

    val xx = 3
    when (xx) {
        in 1..2 -> println("xx is between 1 and 2")
        in 2..10 -> println("xx is between 3 and 10")
        else -> {
            println("xx is not in the range 1 to 10")
        }
    }

    // FUNCTIONS
    print10Numbers()

    val yy = isEven(5)
    println(yy)

    val yyy = 3
    println(yyy.isOdd())

    // ----------------- CLASSES -----------------
//    val dog = Animal("Dog")   // CAnnot create an instance  of an abstract class so this line errors
    val dog2 = Dog()
//    dog2.bark()
    dog2.makeSound()

    val cat = Cat()
//    cat.meow()
    cat.makeSound()

    // have problem that we can still create an Animal. This is because Animal is an Open class.
    // We change it to an Abstract class to model behaviour we want in the subclasses.

    val bear = object : Animal("Camembear") {
        override fun makeSound() {
            println("ROOOOAAARRR!!!")
        }
    }
    bear.makeSound()

    // --------- EXCEPTIONS   TRY  /  CATCH -----------
    val myNum = readLine() ?: "0"
//    myNum.toInt()   // User types in "hello"
                    // Exception in thread "main" java.lang.NumberFormatException:
                    // For input string: "hello"

    val parsedNumber = try {
        myNum.toInt()
    } catch (e: Exception) {
        0   // if it is not possible to parse the user input to a number, we will return 0
    }
    println(parsedNumber) // if we type something invalid as a value for myNum, program will return 0.
}

// FUNCTIONS
fun print10Numbers() {
    for (i in 1..10) {
        println(i)
    }
}

// Can extend a type with custom functions -> This one checks if number is odd and returns a boolean.
fun Int.isOdd(): Boolean {
    return this % 2 == 1
}
fun isEven(num: Int = 10): Boolean {    // Added a default parameter of Int = 10
    return num % 2 == 0
}

