package Tier2Mediator;

import Data.Secretary;
import Data.Student;
import Data.Teacher;

public interface Tier2Connection
{
    public boolean isConnected();
    public void closeSocket();
    public void connect(int port);
    public void waitFromTier2();

    public void openStudent(Student data, long id);
    public void logInError(String error, Long id);

    public void openTeacher(Teacher data, Long id);
    public void teacherError(String error, Long id);

    public void openSecretary(Secretary secretaryData, long id2);
    public void secretaryError(String error, Long id2);
}
