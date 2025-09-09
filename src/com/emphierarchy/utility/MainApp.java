package com.emphierarchy.utility;


import com.emphierarchy.entity.Project;
import com.emphierarchy.service.ProjectService;

import java.util.List;
import java.util.Scanner;


// This is where we run the whole project
public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the skill name:");
        String skillName = scanner.nextLine();

        System.out.println("Enter the minimum years of experience:");
        int yoe = scanner.nextInt();
        scanner.close();

        ProjectService projectService = new ProjectService();
        List<Project> projects = projectService.findProjectsBySkillAndYoe(skillName, yoe);

        if (projects != null && !projects.isEmpty()) {
            System.out.println("\nProjects with employees having skill '" + skillName + "' and at least " + yoe + " years of experience:");
            for (Project project : projects) {
                System.out.println(project);
            }
        } else {
            System.out.println("No projects found for the given criteria or a database error occurred.");
        }
    }
}