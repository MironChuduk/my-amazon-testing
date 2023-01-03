package strategy;

public class Person {
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void executeActivity() {
        activity.doSomething();
    }
}
