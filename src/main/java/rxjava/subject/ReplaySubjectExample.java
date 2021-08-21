package rxjava.subject;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample {
    public static void main(String[] args) {
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