package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chassis extends SubsystemBase {

    private final WPI_TalonFX lmotor;
    private final WPI_TalonFX rmotor;

    private final DifferentialDrive diffDrive;

    public Chassis() {
        lmotor = new WPI_TalonFX(1);
        rmotor = new WPI_TalonFX(2);

        lmotor.setNeutralMode(NeutralMode.Brake);
        rmotor.setNeutralMode(NeutralMode.Brake);

        diffDrive = new DifferentialDrive(lmotor, rmotor);

    }

    public void driveChassis(double xSpeed, double zRot) {
        diffDrive.curvatureDrive(xSpeed, zRot, true);
    }

    @Override
    public void periodic() {
        lmotor.feed();
        rmotor.feed();
        diffDrive.feed();
        diffDrive.feedWatchdog();
    }

}
