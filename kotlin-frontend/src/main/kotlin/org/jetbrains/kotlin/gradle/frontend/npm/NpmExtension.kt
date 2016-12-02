package org.jetbrains.kotlin.gradle.frontend.npm

import org.gradle.api.tasks.*
import org.jetbrains.kotlin.gradle.frontend.*
import java.util.*

/**
 * @author Sergey Mashkov
 */
open class NpmExtension {
    @Nested
    val dependencies: MutableList<Dependency> = ArrayList()

    @Nested
    val versionReplacements: MutableList<Dependency> = ArrayList()

    @Nested
    val developmentDependencies: MutableList<Dependency> = ArrayList()

    @JvmOverloads
    fun dependency(name: String, version: String = "*") {
        dependencies.add(Dependency(name, version, Dependency.RuntimeScope))
    }

    fun replaceVersion(name: String, version: String) {
        versionReplacements.add(Dependency(name, version, Dependency.RuntimeScope))
    }

    @JvmOverloads
    fun devDependency(name: String, version: String = "*") {
        developmentDependencies.add(Dependency(name, version, Dependency.DevelopmentScope))
    }
}