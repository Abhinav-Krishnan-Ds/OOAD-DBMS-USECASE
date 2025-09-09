package com.emphierarchy.dao;

import com.emphierarchy.dbconnection.DBConnection;
import com.emphierarchy.entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// This is where we write the query
public class ProjectDAO {
    private static final String PROJECTS_QUERY =
        "SELECT DISTINCT p.id, p.project_name, p.project_desc FROM Project p " +
        "JOIN Project_assignment pa ON p.id = pa.project_id " +
        "JOIN Employee_skill es ON pa.emp_id = es.emp_id " +
        "JOIN Skill s ON es.skill_id = s.id " +
        "WHERE s.skill_name = ? AND es.experience >= ?";

    public List<Project> getProjectsBySkillAndYoe(String skillName, int yoe) throws SQLException {
        List<Project> projects = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(PROJECTS_QUERY)) {

            ps.setString(1, skillName);
            ps.setInt(2, yoe);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String projectName = rs.getString("project_name");
                    String projectDesc = rs.getString("project_desc");
                    projects.add(new Project(id, projectName, projectDesc));
                }
            }
        }
        return projects;
    }
}