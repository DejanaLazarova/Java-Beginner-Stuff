public class HumanRobotOperator implements RobotOperator {

    @Override
    public void run(Worker robot) {
    	
        robot.work();
        robot.stopWorking();
    }
}
