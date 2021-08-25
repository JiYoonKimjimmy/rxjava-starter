package rxjava.observable;

import io.reactivex.Observable;

public class ObservableExample {
    public static void main(String[] args) {
        emit();
    }

    public static void emit() {
        /*
         * Observable.class : 데이터의 변화가 발생하는 data source
         * just() : 기본적인 Observable 선언 방식으로, data source 에 String 정보 2개를 발행
         * subscribe() : Observable 를 구독하며 발행된 데이터를 소비
         */
        Observable
                .just("Hello", "RxJava")
                .subscribe(System.out::println);
    }
}
