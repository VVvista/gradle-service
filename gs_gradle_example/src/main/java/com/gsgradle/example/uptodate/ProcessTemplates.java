package com.gsgradle.example.uptodate;

import java.io.File;
import java.util.HashMap;
import org.gradle.api.*;
import org.gradle.api.file.*;
import org.gradle.api.tasks.*;
/**
 * @author Wen TingTing by 2019/11/15
 */
public class ProcessTemplates extends DefaultTask{
    private com.gsgradle.example.uptodate.TemplateEngineType templateEngine;
    private FileCollection sourceFiles;
    private com.gsgradle.example.uptodate.TemplateData templateData;
    private File outputDir;

    @Input
    public com.gsgradle.example.uptodate.TemplateEngineType getTemplateEngine() {
        return this.templateEngine;
    }

    @InputFiles
    public FileCollection getSourceFiles() {
        return this.sourceFiles;
    }

    @Nested
    public com.gsgradle.example.uptodate.TemplateData getTemplateData() {
        return this.templateData;
    }

    @OutputDirectory
    public File getOutputDir() { return this.outputDir; }

    // + setter methods for the above - assume we’ve defined them

    @TaskAction
    public void processTemplates() {
        // ...
    }
}
