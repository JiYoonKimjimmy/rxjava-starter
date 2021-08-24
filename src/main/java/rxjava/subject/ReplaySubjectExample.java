package rxjava.subject;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample {
    public static void main(String[] args) {
        // ReplaySubject : 구독자가 등록된 순간 처음부터 끝까지 모든 데이터 발행 및 구독 처리
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println("subscribe #1 : " + data));
        subject.onNext("one");
        subject.onNext("two");
        subject.subscribe(data -> System.out.println("subscribe #2 : " + data));
        subject.onNext("three");
        subject.subscribe(data -> System.out.println("subscribe #3 : " + data));
        subject.onComplete();
    }
}