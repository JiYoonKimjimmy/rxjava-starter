package rxjava.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import rxjava.uitl.PrintUtil;

import java.util.Arrays;
import java.util.List;

public class ThreadChainingExample {
    public static void main(String[] args) {
        List<Figure> figures = Arrays.asList(
                new Figure("Red", "Ball"),
                new Figure("Green", "Ball"),
                new Figure("Blue", "Ball")
        );

        Observable.fromIterable(figures)
                .subscribeOn(Schedulers.computation())                  // 내부적으로 Thread pool 생성
                .subscribeOn(Schedulers.io())                           // 필요할때마다 Thread 생성
                .doOnSubscribe(data -> PrintUtil.printData("doOnSubscribe"))
                .doOnNext(data -> PrintUtil.printData("doOnNext [init] : ", data))
                .observeOn(Schedulers.newThread())                      // 매번 새로운 Thread 생성
                .map(data -> {data.shape = "Square"; return data;})
                .doOnNext(data -> PrintUtil.printData("doOnNext [Ball -> Square] : ", data))
                .observeOn(Schedulers.newThread())
                .map(data -> {data.shape = "Triangle"; return data;})
                .doOnNext(data -> PrintUtil.printData("doOnNext [Square -> Triangle] : ", data))
                .observeOn(Schedulers.newThread())
                .subscribe(data -> System.out.println("subscribe : " + data));
    }
}

class Figure {
    String color;
    String shape;

    public Figure(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }
}