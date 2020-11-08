package Tier2Mediator;

import Data.Student;

public interface Tier2Connection
{
    public boolean isConnected();
    public void closeSocket();
    public void connect(int port);
    public void waitFromTier2();

    public void openStudentWindow(Student data, long id);
    public void logInError(String error, Long id);
}
