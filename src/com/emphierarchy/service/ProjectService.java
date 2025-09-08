package com.emphierarchy.service;

import com.emphierarchy.dao.ProjectDAO;
import com.emphierarchy.entity.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    private ProjectDAO projectDAO = new ProjectDAO();

    public List<Project> findProjectsBySkillAndYoe(String skillName, int yoe) {
        try {
            return projectDAO.getProjectsBySkillAndYoe(skillName, yoe);
        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            return null;
        }
    }
}