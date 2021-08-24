package rxjava.subject;

import io.reactivex.subjects.PublishSubject;

public class PublishSubjectExample {
    public static void main(String[] args) {
        // PublishSubject : 구독자가 등록한 시점부터의 데이터만 발행 및 구독 처리
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> System.out.println("subscribe #1 : " + data));
        subject.onNext("one");
        subject.onNext("two");
        subject.subscribe(data -> System.out.println("subscribe #2 : " + data));
        subject.onNext("three");
        subject.onComplete();
    }
}
