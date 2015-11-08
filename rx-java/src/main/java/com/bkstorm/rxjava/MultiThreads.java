package com.bkstorm.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MultiThreads {
	public static void main(String[] args) {
		Observable.OnSubscribe<String> subscribeFunction = (s) -> {
			emitProduct(s);
		};
		Observable.create(subscribeFunction).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(s -> {
			System.out.println(Thread.currentThread().getId());
		});
	}

	private static void emitProduct(Subscriber<? super String> subscriber) {
		System.out.println(Thread.currentThread().getId());
		subscriber.onNext("");
	}
}
