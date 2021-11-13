package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

import static frc.robot.RobotContainer.driverController;

public class ChassisRun extends CommandBase {

    private Chassis mChassis;

    public ChassisRun(Chassis chassis) {
        mChassis = chassis;
        addRequirements(mChassis);
    }

    @Override
    public void initialize() {
        mChassis.driveChassis(-0.8*driverController.getRawAxis(1), 0.8*driverController.getRawAxis(4));
    }

    @Override
    public void execute() {
        mChassis.driveChassis(-0.8*driverController.getRawAxis(1), 0.8*driverController.getRawAxis(4));
    }


}
