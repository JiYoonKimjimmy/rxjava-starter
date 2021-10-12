package rxjava.uitl

fun main() {
    val list = listOf(1, 2, 3)

    // 함수형 프로그래밍
    for (i: Int in list) {
        val msg = convert(i)
        println(msg)
    }

    // 함수형 프로그래밍
    list.map { convert(it) }
        .forEach { println(it) }

    // 1급 객체 조건 3가지
    // 1. 변수 또는 데이터안으로 저장 가능
    val test: (String) -> Unit = { str -> println("Hello Kotlin $str") }
    val func1 = test

    // 2. 파라미터 전달 가능
    invokeFunction { func1("TEST") }

    // 3. 반환값으로 사용 가능
    val func2 = returnFunction()
    func2.invoke()
}

fun convert(i: Int): String = when (i) {
    1 -> "첫 번째"
    2 -> "두 번째"
    3 -> "세 번째"
    else -> ""
}

fun invokeFunction(f: () -> Unit) = f.invoke()

fun returnFunction(): () -> Unit = { println("This is Return Function") }
