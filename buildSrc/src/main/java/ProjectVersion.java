import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Wen TingTing by 2019/12/1
 */
public class ProjectVersion implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.task("projectVersion");
    }

}
