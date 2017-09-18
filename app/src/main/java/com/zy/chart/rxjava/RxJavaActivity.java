package com.zy.chart.rxjava;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;
import com.zy.chart.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.ResourceSingleObserver;

public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        initView();

    }

    //问题代码，再学点来修复
    private void initView() {
        File filePath = Environment.getExternalStorageDirectory();
        Observable.just(filePath)
            .flatMap(new Function<File, ObservableSource<?>>() {
                @Override
                public ObservableSource<?> apply(@NonNull File file) throws Exception {
                    return isDirectory(file);
                }
            })
            .filter(new Predicate<Object>() {
                @Override
                public boolean test(@NonNull Object o) throws Exception {
                    return ((File) o).getName().endsWith(".aat");
                }
            })
            .map(new Function<Object, String>() {
                @Override
                public String apply(@NonNull Object o) throws Exception {
                    return ((File) o).getName();
                }
            })
            .toList()
            .subscribe(new ResourceSingleObserver<List<String>>() {
                @Override
                public void onSuccess(@NonNull List<String> strings) {
                    Logger.d(strings.toString());
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Logger.d(e.getMessage());
                }
            });
    }

    private Observable isDirectory(File file) {
        if (file.isDirectory()) {
            isDirectory(file);
        } else {
            return Observable.just(file);
        }
        return Observable.just(file);
    }

    private void initView2() {
        Observable<Student> studentObservable = getStudent("张三");
        Observable<List<Student>> listObservable = getAllStudent(null);

        //创建观察者
        Observer<Student> observer = new Observer<Student>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Student s) {
                Logger.d(s.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Logger.d("onComplete");
            }
        };

        studentObservable
            .flatMap(new Function<Student, ObservableSource<Student>>() {
                @Override
                public ObservableSource<Student> apply(@NonNull Student student) throws Exception {
                    return getAllStudent(student).flatMapIterable(new Function<List<Student>, Iterable<? extends Student>>() {
                        @Override
                        public Iterable<? extends Student> apply(@NonNull List<Student> students) throws Exception {
                            return students;
                        }
                    });
                }
            })
            .subscribe(observer);

    }

    private Observable<Student> getStudent(String name) {
        //查询数据库返回数据
        Student student = new Student(name, "25");
        return Observable.just(student);
    }

    private Observable<List<Student>> getAllStudent(Student student) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Student("name" + i, i + 25 + ""));
        }
        return Observable.fromArray(list);
    }

    private void initView1() {

        //创建被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("Hello RxJava Word !");
                e.onComplete();
            }
        });

        //创建观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Logger.d("onNext value = " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Logger.d("onComplete");
            }
        };

        //被观察者订阅观察者
        observable
            .map(new Function<String, String>() {
                @Override
                public String apply(@NonNull String s) throws Exception {
                    return s + "改变数据不要在生产和反应的时候，应该在操作符中";
                }
            })
            .subscribe(observer);

    }
}
