package Model;

public interface Tier2Model
{
    public void CheckLogInData(String id, String password, long id2);

    public void TeacherAssignGrade(String studentId, String course, String grade, String teacherID ,Long id);

    public void TeacherAssignAbsence(String studentId, String course, String teacherID, long id);

    public void TeacherMotivateAbsence(String studentID, String course, String date, String teacherID, long id);

    public void SecretaryCreateTeacher(String firstName, String lastName, String password, long id);

    public void SecretaryEditTeacher(String id, String password, long id2);

    public void SecretaryDeleteTeacher(String firstField, long id);
}
