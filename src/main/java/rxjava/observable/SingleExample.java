package rxjava.observable;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;

public class SingleExample {
    public static void main(String[] args) {
        // Single : 단 1개의 데이터만 발행 및 구독 처리
        justSingle();
        createSingle();
    }

    private static void justSingle() {
        Single.just("just single subscribe")
                .subscribe(System.out::println);
    }

    private static void createSingle() {
        Single<String> createdSingle = Single.create(
                new SingleOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull SingleEmitter<String> emitter) throws Exception {
                        emitter.onSuccess("create single subscribe");
                    }
                }
        );
        createdSingle.subscribe(System.out::println);
    }
}
