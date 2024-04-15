import java.util.Scanner

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    print("Enter two numbers: ")

    val number1 = reader.nextDouble()
    val number2 = reader.nextDouble()

    print("Enter an operator (+, -, *, /): ")
    val operator = reader.next()[0]

    val result = when (operator) {
        '+' -> number1 + number2
        '-' -> number1 - number2
        '*' -> number1 * number2
        '/' -> if (number2 != 0.0) number1 / number2 else Double.NaN
        else -> {
            println("$operator is not a valid operator")
            return
        }
    }

    println("Result: $result")
}
