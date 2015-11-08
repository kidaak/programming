package com.bkstorm.rxjava;

import rx.Observable;

public class HelloWorld {
	public static void main(String[] args) {
		Observable.just("Hello, world!").subscribe(s -> System.out.println(s));
	}
}
