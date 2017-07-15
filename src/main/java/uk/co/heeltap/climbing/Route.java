package uk.co.heeltap.climbing;

public class Route {

	private String name;
	private String topo;
	private String grade;
	private int numStars;

	public Route(String name, int numStars, String grade, String topo) {
		this.name = name;
		this.grade = grade;
		this.topo = topo;
		this.numStars = numStars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopo() {
		return topo;
	}

	public void setTopo(String topo) {
		this.topo = topo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getNumStars() {
		return numStars;
	}

	public void setNumStars(int numStars) {
		this.numStars = numStars;
	}
	@Override
	public String toString() {
		return name + " " + grade;
	}

	public String getStars() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numStars; i++) {
			sb.append("*");
		}
		if (numStars == 0) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
	
}
