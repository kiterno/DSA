package design.pattern.command;

public class App {
    public static void main(String[] args) {
        Switcher switcher = new Switcher();

        Light light = new Light();
        TurnOffCommand turnOffCommand = new TurnOffCommand(light);
        TurnOnCommand turnOnCommand = new TurnOnCommand(light);

        switcher.addCommand(turnOffCommand);
        switcher.addCommand(turnOnCommand);

        switcher.executeCommands();
    }
}
