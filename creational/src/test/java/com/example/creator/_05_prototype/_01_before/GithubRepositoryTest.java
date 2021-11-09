package com.example.creator._05_prototype._01_before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GithubRepositoryTest {

    @DisplayName("Git Repository에 대한 이슈 복제 테스트")
    @Test
    void testCase1() {
        GithubRepository repository = new GithubRepository();
        repository.setUser("whiteship");
        repository.setName("live-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

        String url = githubIssue.getUrl();
        System.out.println(url);
    }
}