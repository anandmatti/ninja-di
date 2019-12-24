package org.polar.ninja.di;

import javax.inject.Named;
import java.lang.annotation.Annotation;

/**
 * <p>
 * Key
 * </p>
 *
 * @author Anand Mattikopp
 * @since 15-Dec-2019
 */
public class Key<T> {
    private final Class<T> type;
    private final String name;
    private final Class<? extends Annotation> qualifier;

    public Key(Class<T> type, String name, Class<? extends Annotation> qualifier) {
        this.type = type;
        this.name = name;
        this.qualifier = qualifier;
    }

    public static <T> Key<T> of(Class<T> type) {
        return new Key<>(type, null, null);
    }

    public static <T> Key<T> of(Class<T> type, String name) {
        return new Key<>(type, name, Named.class);
    }

    public static <T> Key<T> of(Class<T> type, Class<? extends Annotation> qualifier) {
        return new Key<>(type, null, qualifier);
    }

    public static <T> Key<T> of(Class<T> type, Annotation qualifier) {
        if (qualifier == null) {
            return Key.of(type);
        } else {
            return Key.of(type, qualifier.annotationType());
        }
    }

    public Class<T> getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Class<? extends Annotation> getQualifier() {
        return qualifier;
    }
}
