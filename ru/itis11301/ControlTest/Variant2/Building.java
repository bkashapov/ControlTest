package ru.itis11301.ControlTest.Variant2;

public class Building implements BuildingInterface{
    public void start() {
        System.out.println("Стройка началась");
        StageList stageList = new StageList();
        stageList.add(new ProjectStage());
        stageList.add(new FoundationStage());
        stageList.add(new WallStage());
        stageList.add(new RoofStage());
        stageList.add(new FinishingStage());


        while(true) {
            try {
                stageList.current.updateStatus();
                stageList.current.updateStatus();
            } catch (RejectException e) {
                System.out.println("Этап «" + stageList.current.getName() + "» забраковался");
                if (stageList.prev() == null) {
                    System.out.println("Проект забракован");
                    finish();
                    return;
                }
                stageList.current.status = Status.PLANNED;
                continue;
            }
            if (stageList.current.status == Status.COMPLETED) {
                System.out.println("Этап «" + stageList.current.getName() + "» завершен");
            }
            if (stageList.next() == null && stageList.current.status == Status.COMPLETED){
                break;
            }
        }
        finish();
    }
    public void finish() {
        System.out.println("Стройка завершена");
    }
}
