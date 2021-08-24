package rxjava.subject;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectExample {
    public static void main(String[] args) {
        // BehaviorSubject : 구독하는 순간 최근 데이터 or 기본값 데이터를 발행 및 구독 처리
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("BLUE");
        subject.subscribe(data -> System.out.println("subscribe #1 : " + data));
        subject.onNext("RED");
        subject.onNext("GREEN");
        subject.subscribe(data -> System.out.println("subscribe #2 : " + data));
        subject.onNext("WHITE");
        subject.onComplete();
    }
}
// subscribe #1 : BLUE
// subscribe #1 : RED
// subscribe #1 : GREEN
// subscribe #2 : GREEN
// subscribe #1 : WHITE
// subscribe #2 : WHITE