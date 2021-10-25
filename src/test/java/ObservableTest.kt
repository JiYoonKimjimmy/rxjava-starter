import io.reactivex.Observable
import org.junit.jupiter.api.Test
import rxjava.uitl.PrintUtil

class ObservableTest {
    @Test
    fun test() {
        var result: String = "default"
        Observable
            .just("Hello", "observable")
            .subscribe {s ->
                result += s
                PrintUtil.printData(s)
            }
        println(result)
    }
}

