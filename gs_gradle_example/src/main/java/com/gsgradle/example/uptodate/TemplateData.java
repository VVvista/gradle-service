package com.gsgradle.example.uptodate;

import java.util.HashMap;
import java.util.Map;
import org.gradle.api.tasks.Input;
/**
 * @author Wen TingTing by 2019/11/15
 */
public class TemplateData {
    private String name;
    private Map<String, String> variables;

    public TemplateData(String name, Map<String, String> variables) {
        this.name = name;
        this.variables = new HashMap<>(variables);
    }

    @Input
    public String getName() { return this.name; }

    @Input
    public Map<String, String> getVariables() {
        return this.variables;
    }
}
