plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        analysis()
        binaryCompatibilityValidator {
            apiValidation {
                for (project in allprojects) {
                    if (project.path.contains("sample")) {
                        ignoredProjects += project.name
                    }
                }
            }
        }
        coverage()
        documentation {
            changelog()
            readme {
                badges()
            }
            site()
        }
        nexus()
    }
}
