package projectClass;

public class ProjectClass {
	private String projectName;
	private String projectDescription;
	
	public String Project(){
		return elevatorPitch("to be created");
		
	}
	public String Project(String projectName) {
		this.projectName = projectName;
		return elevatorPitch(projectName);
	}
	public String Project(String projectName, String projectDescription) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		return elevatorPitch(projectName + ":" + projectDescription);
	}
	private String elevatorPitch(String thePitch) {
		return "New project " + thePitch;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


}
