

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author Wen TingTing by 2019/11/28
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