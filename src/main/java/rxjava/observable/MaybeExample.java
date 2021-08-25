package rxjava.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MaybeExample {
    public static void main(String[] args) {
        // Maybe : 0 ~ 1개의 데이터를 발행 및 구독 처리 (success or fail or complete)
        createMaybe();
    }

    private static void createMaybe() {
        Maybe.create(
                new MaybeOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Exception {
                        emitter.onSuccess("create maybe subscribe");
                        emitter.onComplete();
                    }
                }
        ).subscribe(
                new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("onSuccess : " + s);
                    }
                },
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                },
                new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("Complete");
                    }
                }
        );
    }
}
