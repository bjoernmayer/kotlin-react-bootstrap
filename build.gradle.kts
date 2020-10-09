import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinJsPluginWrapper
import org.jlleitschuh.gradle.ktlint.BaseKtlintCheckTask
import org.jlleitschuh.gradle.ktlint.KtlintApplyToIdeaTask
import org.jlleitschuh.gradle.ktlint.KtlintCheckTask
import org.jlleitschuh.gradle.ktlint.KtlintFormatTask
import org.jlleitschuh.gradle.ktlint.KtlintPlugin

plugins {
    idea

    kotlin("js") apply false

    id("org.jlleitschuh.gradle.ktlint")
}

allprojects {
    group = "react"
}

repositories {
    mavenCentral()
}

subprojects {
    apply<IdeaPlugin>()
    apply<KtlintPlugin>()

    repositories {
        mavenCentral()
        jcenter()
    }

    plugins.withType<KotlinJsPluginWrapper> {
        extensions.configure<KotlinJsProjectExtension> {
            js {
                browser()
                useCommonJs()
            }
        }

        tasks.withType<KotlinJsCompile>().configureEach {
            kotlinOptions {
                if (name == "compileKotlinJs") {
                    sourceMapEmbedSources = "always"
                    sourceMap = true
                } else {
                    sourceMap = false
                }
            }
        }
    }

    this.ktlint {
        this.version.set(version("ktlint"))
    }

    // Task grouping
    val groupToTasks = mapOf(
        "ktlint" to setOf(
            BaseKtlintCheckTask::class,
            KtlintCheckTask::class,
            KtlintApplyToIdeaTask::class,
            KtlintFormatTask::class,
            org.jlleitschuh.gradle.ktlint.KtlintInstallGitHookTask::class
        )
    )

    groupToTasks.forEach { (group, tasksSet) ->
        tasksSet.forEach {
            tasks.withType(it) {
                this.group = group
            }
        }
    }
}
