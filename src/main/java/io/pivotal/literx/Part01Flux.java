package io.pivotal.literx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;


/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

	public static final Logger logger = LoggerFactory.getLogger(Part01Flux.class);

//========================================================================================

	// TODO Return an empty Flux
	Flux<String> emptyFlux() {
		return Flux.empty();
	}

//========================================================================================

	// TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
	Flux<String> fooBarFluxFromValues() {
		//Flux fooFlux = Flux.just("foo");
		//Flux barFlux = Flux.just("bar");
		//Flux fooBarFlux = Flux.merge(fooFlux,barFlux);
		Flux<String> fooBarFlux2 = Flux.just("foo", "bar");
		fooBarFlux2.log().subscribe();
		return fooBarFlux2;
	}

//========================================================================================

	// TODO Create a Flux from a List that contains 2 values "foo" and "bar"
	Flux<String> fooBarFluxFromList() {
		ArrayList<String> fooBarList = new ArrayList<>();
		fooBarList.add("foo");
		fooBarList.add("bar");
		Flux<String> fooBarFluxFromList = Flux.fromIterable(fooBarList);
		fooBarFluxFromList.log().subscribe();
		return fooBarFluxFromList;
	}

//========================================================================================

	// TODO Create a Flux that emits an IllegalStateException
	Flux<String> errorFlux() {
		Flux<String> errorFlux = Flux.error(new IllegalStateException("Bad state"));
		errorFlux.log().subscribe();
		return errorFlux;
	}

//========================================================================================

		// TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
	Flux<Long> counter() {
		Flux<Long> counterFlux = Flux.interval(Duration.ofMillis(100)).take(10);
		return counterFlux;
	}

}

