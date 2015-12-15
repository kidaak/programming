package com.bkstorm.rxjava;

import rx.Observable;
import rx.Subscriber;

public class Async {
	public static void main(String[] args) {
		Observable.OnSubscribe<String> subscribeFunction = (s) -> asyncProcessingOnSubscribe(s);
		Observable<String> asyncObservable = Observable.create(subscribeFunction);
		asyncObservable.skip(5).subscribe((incomingValue) -> System.out.println(incomingValue));
	}

	private static void asyncProcessingOnSubscribe(Subscriber<? super String> s) {
		final Subscriber<? super String> subscriber = s;
		Thread thread = new Thread(() -> produceSomeValues(subscriber));
		thread.start();
	}

	private static void produceSomeValues(Subscriber<? super String> subscriber) {
		for (int ii = 0; ii < 10; ii++) {
			if (!subscriber.isUnsubscribed()) {
				subscriber.onNext("Pushing value from async thread " + ii);
			}
		}
	}
}
