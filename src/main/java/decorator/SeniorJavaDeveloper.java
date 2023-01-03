package decorator;

public class SeniorJavaDeveloper extends DeveloperDecorator {
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String codeReview() {
        return "Code reviewing... ";
    }

    @Override
    public String doWork() {
        return super.doWork() + codeReview();
    }
}
