package com.example.rpg_game_api.model;

public class ApiResponseDescription {
    private String message;
    private String status;
    private String description;
    private String author;
    private String githubAuthor;
    private String version;
    private String repositoryUrl;

    public ApiResponseDescription(String message, String status, String description, String author, String githubAuthor,
            String version, String repositoryUrl) {
        this.message = message;
        this.status = status;
        this.description = description;
        this.author = author;
        this.githubAuthor = githubAuthor;
        this.version = version;
        this.repositoryUrl = repositoryUrl;
    }

    public ApiResponseDescription() {
    }

    public String getMessage() {
        return message;
    }

    public ApiResponseDescription setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ApiResponseDescription setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ApiResponseDescription setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ApiResponseDescription setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getGithubAuthor() {
        return githubAuthor;
    }

    public ApiResponseDescription setGithubAuthor(String githubAuthor) {
        this.githubAuthor = githubAuthor;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public ApiResponseDescription setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public ApiResponseDescription setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
        return this;
    }
}
