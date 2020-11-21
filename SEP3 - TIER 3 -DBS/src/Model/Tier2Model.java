package Model;

public interface Tier2Model
{
    public void CheckLogInData(String id, String password, long id2);

    public void TeacherAssignGrade(String studentId, String course, String grade, String teacherID ,Long id);

    void TeacherAssignAbsence(String studentId, String course, String teacherID, long id);
}
