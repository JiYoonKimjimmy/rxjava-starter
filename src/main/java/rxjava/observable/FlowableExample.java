package rxjava.observable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import rxjava.uitl.PrintUtil;

public class FlowableExample {
    public static void main(String[] args) throws Exception {
//        backPressure();
        noBackPressure();
    }

    private static void backPressure() throws Exception {
        PrintUtil.printData("backPressure()");
        Observable.range(1, 10000)
                .doOnNext(i -> PrintUtil.printData("doOnNext", i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    PrintUtil.printData("subscribe", i);
                    Thread.sleep(100);
                });
        Thread.sleep(10000);
    }

    private static void noBackPressure() throws Exception {
        PrintUtil.printData("noBackPressure()");
        Flowable.range(1, 10000)
                .doOnNext(i -> PrintUtil.printData("doOnNext", i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    PrintUtil.printData("subscribe", i);
                    Thread.sleep(100);
                });
        Thread.sleep(10000);
    }

}
