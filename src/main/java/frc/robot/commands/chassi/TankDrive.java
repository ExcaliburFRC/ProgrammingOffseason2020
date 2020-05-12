package frc.robot.commands.chassi;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;

public class TankDrive extends CommandBase {
    public TankDrive() {
        addRequirements(Robot.m_chassi);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double left = OI.driveJoystick.getRawAxis(0);
        double right = OI.driveJoystick.getRawAxis(4);
        Robot.m_chassi.setSpeeds(left, right);

    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
    @Override
    public void end(boolean interrupted) {
    }
}