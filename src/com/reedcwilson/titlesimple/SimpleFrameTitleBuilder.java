package com.reedcwilson.titlesimple;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.impl.FrameTitleBuilder;
import org.jetbrains.annotations.NotNull;

public class SimpleFrameTitleBuilder extends FrameTitleBuilder {
  private static FrameTitleBuilder defaultBuilder;

  public static void setDefaultBuilder(FrameTitleBuilder defaultBuilder) {
    SimpleFrameTitleBuilder.defaultBuilder = defaultBuilder;
  }

  @Override
  public String getProjectTitle(@NotNull Project project) {
    String title = defaultBuilder.getProjectTitle(project);
    String noTrees = title.replaceAll("(treeservices-|trees-)", "");
    return noTrees.substring(0, noTrees.indexOf(" - "));
  }

  @Override
  public String getFileTitle(@NotNull Project project, @NotNull VirtualFile virtualFile) {
    return "";
  }
}