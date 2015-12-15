package com.bkstorm.rxjava;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import rx.Observable;

public class Operators {

	@Test
	public void fromOperator() {
		query("Hello World").subscribe(urls -> {
			Observable.from(urls).subscribe(url -> System.out.println(url));
		});
	}

	@Test
	public void flatMapOperator1() {
		query("Hello World").flatMap(urls -> Observable.from(urls)).subscribe(url -> System.out.println(url));
	}

	@Test
	public void flatMapOperator2() {
		query("Hello World").flatMap(urls -> Observable.from(urls)).flatMap(url -> getTitle(url))
				.filter(title -> title != null).take(5).subscribe(title -> System.out.println(title));
	}

	private Observable<List<String>> query(String text) {
		List<String> urls = new ArrayList<>();
		urls.add("url1");
		urls.add("url2");
		urls.add("url3");
		return Observable.just(urls);
	}

	private Observable<String> getTitle(String url) {
		return Observable.just("title " + url);
	}
}
