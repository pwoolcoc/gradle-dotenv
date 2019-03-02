package io.github.pwoolcoc

import io.github.cdimascio.dotenv.Dotenv
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec

class DotenvPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create("dotenv", DotenvExtension::class.java, project)
        val excludes = extension.excludeTasks.getOrElse(listOf())

        val dotenv = Dotenv.load()
        project.tasks.forEach { task ->
            if (task is JavaExec && task.name !in excludes) {
                for (env in dotenv) {
                    task.environment(env.key, env.value)
                }
            }
        }
    }
}
