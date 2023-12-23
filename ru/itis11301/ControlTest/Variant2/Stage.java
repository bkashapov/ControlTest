package ru.itis11301.ControlTest.Variant2;
import java.util.Random;
public abstract class Stage {
    protected String name;
    protected Status status;
    public Stage next;
    public Stage prev;
    public Stage(String name) {
        this.name = name;
        status = Status.PLANNED;
    }

    public String getName() {
        return name;
    }

    public Status updateStatus() throws RejectException{
        Random r = new Random();
        if (status == Status.PLANNED) {
            status = (r.nextInt(20) + 1) == 1 ? Status.REJECTED : Status.IN_PROGRESS;
        }
        else if (status == Status.IN_PROGRESS) {
            status = (r.nextInt(20) + 1) == 1 ? Status.REJECTED : Status.COMPLETED;
        }
        else if (status == Status.COMPLETED) {
            System.out.println("Этап уже выполнен");
        }
        if (status == Status.REJECTED) {
            throw new RejectException("Этап забракован");
        }

        return null;

    }
}
