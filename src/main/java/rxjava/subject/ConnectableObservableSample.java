package rxjava.subject;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class ConnectableObservableSample {
    public static void main(String[] args) throws InterruptedException {
        String[] arr = {"one", "two", "three"};
        Observable<String> observable = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> arr[i])
                .take(arr.length);

        // ConnectableObservable : 득정 시점부터 데이터를 발행 및 구독 처리
        ConnectableObservable<String> source = observable.publish();
        source.subscribe(data -> System.out.println("subscribe #1 : " + data));
        source.subscribe(data -> System.out.println("subscribe #2 : " + data));
        source.connect();       // 데이터 발행 start

        Thread.sleep(200);
        source.subscribe(data -> System.out.println("subscribe #3 : " + data));
        Thread.sleep(100);
    }
}