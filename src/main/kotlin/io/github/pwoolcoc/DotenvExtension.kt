package io.github.pwoolcoc

import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property

open class DotenvExtension(project: Project) {
    val excludeTasks: Property<List<String>> = project.objects.property<List<String>>()
}

inline fun <reified T> ObjectFactory.property() = this.property(T::class.java)