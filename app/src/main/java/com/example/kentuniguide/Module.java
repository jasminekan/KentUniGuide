package com.example.kentuniguide;

public class Module {
    private String moduleCode;
    private String moduleName;
    private String convenorName;
    private String description;
    private String convenorEmail;

    // Constructor
    public Module(String moduleCode, String moduleName, String convenorName, String convenorEmail, String description) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.convenorName = convenorName;
        this.convenorEmail = convenorEmail;
        this.description = description;
    }

    // Getters
    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getConvenorName() {
        return convenorName;
    }

    public String getConvenorEmail() {
        return convenorEmail;
    }

    public String getDescription() {
        return description;
    }
}
