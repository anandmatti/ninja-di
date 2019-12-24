package org.polar.ninja.di;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

/**
 * <p>
 * DependencyInjectorTest
 * </p>
 *
 * @author Anand Mattikopp
 * @since 15-Dec-2019
 */
public class DependencyInjectorTest {

    @Inject
    private FooService fooService;

    @Before
    public void setup(){
        DependencyInjector dependencyInjector = new DependencyInjector().with();
    }

    public void testFieldInjection(){
        fooService.doSomething();
    }

    private class FooService {
        @Inject
        private BarService barService;

        public void doSomething(){
            barService.doSomething();
        }
    }

    private class BarService {
        public void doSomething(){
            System.out.println("Inside bar service");
        }
    }
}
