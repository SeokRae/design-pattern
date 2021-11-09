package com.example.creator._05_prototype._03_java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubIssueData {

    private int id;

    private String title;

    private String repositoryUser;

    private String repositoryName;

    @Override
    public String toString() {
        return "GithubIssueData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", repositoryUser='" + repositoryUser + '\'' +
                ", repositoryName='" + repositoryName + '\'' +
                '}';
    }
}
