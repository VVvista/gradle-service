package com.gradle.example

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author WenTingTing by 2019/12/2
 */
class ProjectVersion implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println  'reading the version file'
        project.task('projectVersion'){
            println "project version"
        }
    }
}