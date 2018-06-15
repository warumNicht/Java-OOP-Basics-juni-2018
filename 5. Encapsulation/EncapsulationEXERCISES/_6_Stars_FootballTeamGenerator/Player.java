package _6_Stars_FootballTeamGenerator;

public class Player {
    private String name;
    private double endurance;
    private double sprint;
    private  double dribble;
    private  double passing;
    private  double shooting;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public void setName(String name) {
        if(name==null||name.replaceAll("\\s+","").length()==0){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void setEndurance(double endurance) {
        if(endurance<0||endurance>100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    public void setSprint(double sprint) {
        if(sprint<0||sprint>100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    public void setDribble(double dribble) {
        if(dribble<0||dribble>100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    public void setPassing(double passing) {
        if(passing<0||passing>100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    public void setShooting(double shooting) {
        if(shooting<0||shooting>100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }
    double sumPlayerSkills(){
        return endurance+sprint+dribble+passing+shooting;
    }
    private double calculatePlayerAverage(){
        return this.sumPlayerSkills()/5;
    }

    public String getName() {
        return name;
    }
}
