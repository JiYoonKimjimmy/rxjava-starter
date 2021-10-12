package fp

fun main() {
    val f1: () -> Unit = { println("Function 1") }
    val f2: () -> Unit = { println("Function 2") }

    testFunction(f1) {
        f1()
        f2()
    }

    val test: (Int, Int) -> Int = fun(a, b) = a + b
    println(test(3, 5))
}

fun testFunction(f1:() -> Unit, f2:() -> Unit) {
    f1()
    f2()
}
