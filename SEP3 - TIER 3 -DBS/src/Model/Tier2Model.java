package Model;

import Data.Student;

public interface Tier2Model
{
    public void CheckLogInData(String id, String password, long id2);

    public void TeacherAssignGrade(String studentId, String course, String grade, String teacherID ,Long id);

    public void TeacherAssignAbsence(String studentId, String course, String teacherID, long id);

    public void TeacherMotivateAbsence(String studentID, String course, String date, String teacherID, long id);

    public void SecretaryCreateTeacher(String firstName, String lastName, String password, long id);

    public void SecretaryEditTeacher(String id, String password, long id2);

    public void SecretaryDeleteTeacher(String firstField, long id);

    public void SecretaryCreateStudent(Student data, Long id);

    public void SecretaryDeleteStudent(String studentId, long id);

    public void SecretaryEditStudent(String studentId, String address, String password, String phoneNr, Long id);

    public void SecretaryCreateClass(String classNr, String classLetter, String teacherId, Long id);

    public void SecretaryDeleteClass(String classNr, String classLetter, Long id);

    public void SecretaryCLassAddStudent(String classNr, String classLetter, String studentId, long id);

    public void SecretaryClassRemoveStudent(String classNr, String classLetter, String studentId, long id);

    public void SecretaryClassAddCourse(String classNr, String classLetter, String courseName, long id);

    public void SecretaryClassRemoveCourse(String classNr, String classLetter, String courseName, long id);

    public void SecretaryChangeOwnUsername(String username, long id);

    public void SecretaryChangeOwnPassword(String firstField, long id);
}
