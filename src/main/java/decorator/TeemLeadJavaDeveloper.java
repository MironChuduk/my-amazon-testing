package decorator;

public class TeemLeadJavaDeveloper extends DeveloperDecorator {
    public TeemLeadJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String manageTeam() {
        return "Manage the team... ";
    }

    @Override
    public String doWork() {
        return super.doWork() + manageTeam();
    }
}
