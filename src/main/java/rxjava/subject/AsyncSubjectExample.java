package rxjava.subject;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectExample {
    public static void main(String[] args) {
        example01();
        example02();
    }

    private static void example01() {
        // AsyncSubject : Observable 에서 발행한 마지막 데이터 구독
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("subscribe #1 : " + data));
        subject.onNext("one");
        subject.onNext("two");
        subject.subscribe(data -> System.out.println("subscribe #2 : " + data));
        subject.onNext("three");
        subject.onComplete();
    }

    private static void example02() {
        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperature);
        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        source.subscribe(subject);
    }
}
