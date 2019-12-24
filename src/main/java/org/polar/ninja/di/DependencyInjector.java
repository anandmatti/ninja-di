package org.polar.ninja.di;

import javax.inject.Provider;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * DependencyInjector
 * </p>
 *
 * @author Anand Mattikopp
 * @since 14-Dec-2019
 */
public final class DependencyInjector {
    private final Set<Module> moduleList = new HashSet<>();
    private final Map<Key, Provider<?>> providers = new ConcurrentHashMap<>();
    private final Map<Class, Object[]> injectedFields = new ConcurrentHashMap<>();
    private final Map<Key, Object> singletons = new ConcurrentHashMap<>();

    public DependencyInjector() {
    }

    public DependencyInjector(Iterable<Module> modules) {
        addModules(modules);
    }

    /**
     * fluent interface method for addModule command
     * @param module
     * @return DependencyInjector
     */
    public DependencyInjector with(Module module) {
        addModules(Arrays.asList(module));
        return this;
    }

    /**
     * fluent interface for addModules command
     * @param modules
     * @return DependencyInjector
     */
    public DependencyInjector with(Module... modules) {
        addModules(Arrays.asList(modules));
        return this;
    }

    /**
     * Adds instance of Module to the DependencyInjector object.
     * @param module
     */
    public void addModule(Module module) {
        addModules(Arrays.asList(module));
    }

    /**
     * Adds list of instances of Module to the DependencyInjector object.
     * @param modules
     */
    public void addModules(Module... modules) {
        addModules(Arrays.asList(modules));
    }

    /**
     * Adds list of instances of Module to the DependencyInjector object.
     * @param modules
     */
    public void addModules(Iterable<Module> modules) {
        resolveDependencies(modules);
        addToModuleList(modules);
    }

    /**
     * resolves the dependencies for the objects in all instances of <code>Module</>
     * @param modules
     */
    private void resolveDependencies(Iterable<Module> modules) {
        for (Module module : modules) {

        }
    }

    /**
     * Adds all instances of Module to the DependencyInjector's <code>moduleList</code>
     * @param modules
     */
    private void addToModuleList(Iterable<Module> modules) {
        List<Module> moduleList = new ArrayList<>();
        modules.iterator().forEachRemaining(moduleList::add);
        this.moduleList.addAll(moduleList);
    }

}
