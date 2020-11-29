package Model;

import Data.*;
import Data.Secretary;
import Data.Class;
import Tier2Mediator.Tier2Connection;
import Tier2Mediator.Tier2SocketConnection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ModelManager implements Model, Tier2Model {
    Tier2Connection tier2Connection;
    String dateField = "";

    ////TESTING
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Grade> gradesB = new ArrayList<Grade>();
    ArrayList<Absence> absences = new ArrayList<Absence>();
    Student student;
    ArrayList<Teacher> teachers;
    Class aClass;
    Class bClass;
    ArrayList<Student> studentsA, studentsB;
    ArrayList<Class> classes;
    Secretary secretary;

    public ModelManager()
    {
        tier2Connection = new Tier2SocketConnection(this);
        tier2Connection.connect(6969);
        tier2Connection.waitFromTier2();

        SimpleDateFormat formatterDate = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date = new Date();
        dateField = formatterDate.format(date);

        //testing
        grades.add(new Grade(7, "01/02/2020", "Math"));
        grades.add(new Grade(10, "01/02/2020", "Math"));
        grades.add(new Grade(9, "01/02/2020", "Math"));
        grades.add(new Grade(10, "01/02/2020", "Math"));
        grades.add(new Grade(8, "01/02/2020", "Romanian"));
        grades.add(new Grade(5, "01/02/2020", "Romanian"));
        grades.add(new Grade(7, "01/02/2020", "Chemistry"));
        grades.add(new Grade(5, "01/02/2020", "Chemistry"));
        grades.add(new Grade(10, "01/02/2020", "English"));
        grades.add(new Grade(10, "01/02/2020", "English"));
        grades.add(new Grade(2, "01/02/2020", "Chemistry"));
        grades.add(new Grade(10, "01/02/2020", "Computer Science"));
        grades.add(new Grade(9, "01/02/2020", "Computer Science"));
        grades.add(new Grade(10, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(10, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(9, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(10, "01/02/2020", "Computer Science"));

        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", true, "Romanian"));
        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", true, "Math"));
        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", false, "Chemistry"));
        absences.add(new Absence("01/02/2020", false, "English"));
        absences.add(new Absence("01/02/2020", false, "Computer Science"));
        absences.add(new Absence("01/02/2020", true, "Computer Science"));
        absences.add(new Absence("01/02/2020", true, "Computer Science"));

        studentsA = new ArrayList<Student>();
        studentsB = new ArrayList<Student>();

        student = new Student("1", "Dodonica", "Puta mica", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsA.add(student);
        student = new Student("3", "Paul", "Balan", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsA.add(student);
        student = new Student("4", "Mircea", "Dobre", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsB.add(student);
        student = new Student("5", "Sandu", "Chilat", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", gradesB, absences);
        studentsB.add(student);

        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Math"));
        courses.add(new Course("Chemistry"));
        courses.add(new Course("English"));
        courses.add(new Course("Computer Science"));
        courses.add(new Course("Romanian"));


        ArrayList<Course> courses2 = new ArrayList<Course>();
        courses2.add(new Course("Math"));
        courses2.add(new Course("Chemistry"));
        courses2.add(new Course("English"));
        courses2.add(new Course("Computer Science"));
        courses2.add(new Course("Romanian"));
        courses2.add(new Course("Sugilimie"));


        aClass = new Class(12, 'A', "112", studentsA, courses);
        bClass = new Class(11, 'B', "112", studentsB, courses2);
        classes = new ArrayList<Class>();
        classes.add(aClass);
        classes.add(bClass);

        teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("2", "Baba", "Cloanta", "2", classes));


        secretary = new Secretary("0", "0", teachers, classes);

    }

    synchronized private String getNewId()
    {
        String maxNr = "0";

        for (int i = 0; i < teachers.size(); i++)
            if (Integer.parseInt(teachers.get(i).getId()) > Integer.parseInt(maxNr))
                maxNr = teachers.get(i).getId();

        for (int i = 0; i < studentsA.size(); i++)
            if (Integer.parseInt(studentsA.get(i).getId()) > Integer.parseInt(maxNr))
                maxNr = studentsA.get(i).getId();

        for (int i = 0; i < studentsB.size(); i++)
            if (Integer.parseInt(studentsB.get(i).getId()) > Integer.parseInt(maxNr))
                maxNr = studentsB.get(i).getId();

        if (Integer.parseInt(secretary.getId()) > Integer.parseInt(maxNr))
            maxNr = secretary.getId();

        maxNr = String.valueOf(Integer.valueOf(maxNr) + 1);

        return maxNr;
    }

    private Teacher getTeacherData(String id)
    {
        System.out.println("----------TEACHER DATA ");
        for (int i = 0; i < teachers.size(); i++)
            if (teachers.get(i).getId().equals(id))
                return teachers.get(i);
        return null;
    }

    private Student getStudentData(String id)
    {
        System.out.println("----------STUDENT DATA ");
        for (int i = 0; i < studentsA.size(); i++)
            if (studentsA.get(i).getId().equals(id))
                return studentsA.get(i);

        for (int i = 0; i < studentsB.size(); i++)
            if (studentsB.get(i).getId().equals(id))
                return studentsB.get(i);
        return null;
    }

    private Secretary getSecretaryData(String id)
    {
        System.out.println("----------SECRETARY DATA " + secretary.getId());
        return this.secretary;
    }

    private String isUserValid(String id, String password)
    {

        for (int i = 0; i < teachers.size(); i++)
            if (teachers.get(i).getId().equals(id) && teachers.get(i).getPassword().equals(password))
                return "Teacher";

        if (id.equals("0") && password.equals("0"))
            return "Secretary";

        for (int i = 0; i < studentsA.size(); i++)
            if (studentsA.get(i).getId().equals(id) && studentsA.get(i).getViewGradePassword().equals(password))
                return "Student";

        for (int i = 0; i < studentsB.size(); i++)
            if (studentsB.get(i).getId().equals(id) && studentsB.get(i).getViewGradePassword().equals(password))
                return "Student";

        return null;
    }

    @Override
    public void CheckLogInData(String id, String password, long id2)
    {
        ///FOR NOW
        String validUser = isUserValid(id, password);
        if (validUser == null) {
            tier2Connection.logInError("There was an error", id2);
            System.out.println("!!!!!!!!!!!!!!!!");
        } else if (validUser.equals("Student"))
            tier2Connection.openStudent(getStudentData(id), id2);
        else if (validUser.equals("Teacher"))
            tier2Connection.openTeacher(getTeacherData(id), id2);
        else if (validUser.equals("Secretary"))
            tier2Connection.openSecretary(getSecretaryData(id), id2);
    }

    @Override
    public void TeacherAssignGrade(String studentId, String course, String grade, String teacherID, Long id)
    {
        System.out.println("!!!!!!!!!!!!!!!!!!ASSIGN GRADE");

        for (int i = 0; i < studentsA.size(); i++)
            if (studentsA.get(i).getId().equals(studentId)) {
                studentsA.get(i).getGrades().add(new Grade(Integer.valueOf(grade), dateField, course));
                tier2Connection.openTeacher(getTeacherData(teacherID), id);
            }

        for (int i = 0; i < studentsB.size(); i++)
            if (studentsB.get(i).getId().equals(studentId)) {
                studentsB.get(i).getGrades().add(new Grade(Integer.valueOf(grade), dateField, course));
                tier2Connection.openTeacher(getTeacherData(teacherID), id);
            }


        tier2Connection.teacherError("Something is wrong boyy", id);
    }


    public void TeacherAssignAbsence(String studentId, String course, String teacherID, long id)
    {
        System.out.println("!!!!!!!!!!!!!!!!!!ASSIGN Absence");

        for (int i = 0; i < studentsA.size(); i++)
            if (studentsA.get(i).getId().equals(studentId)) {
                studentsA.get(i).getAbsences().add(new Absence(this.dateField, false, course));
                tier2Connection.openTeacher(getTeacherData(teacherID), id);
            }

        for (int i = 0; i < studentsB.size(); i++)
            if (studentsB.get(i).getId().equals(studentId)) {
                studentsB.get(i).getAbsences().add(new Absence(this.dateField, false, course));
                tier2Connection.openTeacher(getTeacherData(teacherID), id);
            }


        tier2Connection.teacherError("Something is wrong boyy", id);
    }

    public void TeacherMotivateAbsence(String studentID, String course, String date, String teacherID, long id)
    {
        System.out.println("!!!!!!!!!!!!!!!!!!MOTIVATE ABSENCE");

        for (int i = 0; i < studentsA.size(); i++)
            if (studentsA.get(i).getId().equals(studentID))
                for (int j = 0; j < studentsA.get(i).getAbsences().size(); j++)
                    if (studentsA.get(i).getAbsences().get(j).getDate().equals(date) && studentsA.get(i).getAbsences().get(j).getCourse().equals(course) && !studentsA.get(i).getAbsences().get(j).isMotivated()) {
                        studentsA.get(i).getAbsences().get(j).setMotivated(true);
                        tier2Connection.openTeacher(getTeacherData(teacherID), id);
                    }

        for (int i = 0; i < studentsB.size(); i++)
            if (studentsB.get(i).getId().equals(studentID))
                for (int j = 0; j < studentsB.get(i).getAbsences().size(); j++)
                    if (studentsB.get(i).getAbsences().get(j).getDate().equals(date) && studentsB.get(i).getAbsences().get(j).getCourse().equals(course) && !studentsB.get(i).getAbsences().get(j).isMotivated()) {
                        studentsB.get(i).getAbsences().get(j).setMotivated(true);
                        tier2Connection.openTeacher(getTeacherData(teacherID), id);
                    }


        tier2Connection.teacherError("Something is wrong boyy", id);
    }

    @Override
    public void SecretaryCreateTeacher(String firstName, String lastName, String password, long id)
    {
        this.teachers.add(new Teacher(this.getNewId(), firstName, lastName, password, null));

        tier2Connection.openSecretary(getSecretaryData("0"), id);
    }

    @Override
    public void SecretaryEditTeacher(String id, String password, long id2)
    {
        for (int i = 0; i < teachers.size(); i++)
            if (teachers.get(i).getId().equals(id))
            {
                teachers.get(i).setPassword(password);
                tier2Connection.openSecretary(getSecretaryData("0"), id2);
            }
        tier2Connection.secretaryError("Teacher not found", id2);
    }

    @Override
    public void SecretaryDeleteTeacher(String firstField, long id)
    {
        for (int i = 0; i < teachers.size(); i++)
            if (teachers.get(i).getId().equals(firstField))
            {
                teachers.remove(teachers.get(i));
                tier2Connection.openSecretary(getSecretaryData("0"), id);
            }
        tier2Connection.secretaryError("Teacher not found", id);
    }

    @Override
    public void SecretaryCreateStudent(Student data, Long id)
    {
        data.setId(this.getNewId());
        studentsA.add(data);

        tier2Connection.openSecretary(getSecretaryData("0"), id);
    }

    @Override
    public void SecretaryDeleteStudent(String studentId, long id)
    {
        for (int i = 0; i < studentsA.size(); i++)
            if (studentsA.get(i).getId().equals(studentId))
            {
                studentsA.remove(studentsA.get(i));
                tier2Connection.openSecretary(getSecretaryData("0"), id);
            }
        for (int i = 0; i < studentsB.size(); i++)
            if (studentsB.get(i).getId().equals(studentId))
            {
                studentsB.remove(studentsB.get(i));
                tier2Connection.openSecretary(getSecretaryData("0"), id);
            }
        tier2Connection.secretaryError("Student not found", id);
    }

    @Override
    public void SecretaryEditStudent(String studentId, String address, String password, String phoneNr, Long id)
    {
        for (int i = 0; i < studentsA.size(); i++)
            if (studentsA.get(i).getId().equals(studentId))
            {
                studentsA.get(i).setAddress(address);
                studentsA.get(i).setViewGradePassword(password);
                studentsA.get(i).setPhoneNumber(phoneNr);
                tier2Connection.openSecretary(getSecretaryData("0"), id);
            }
        for (int i = 0; i < studentsB.size(); i++)
            if (studentsB.get(i).getId().equals(studentId))
            {
                studentsB.get(i).setAddress(address);
                studentsB.get(i).setViewGradePassword(password);
                studentsB.get(i).setPhoneNumber(phoneNr);
                tier2Connection.openSecretary(getSecretaryData("0"), id);
            }
        tier2Connection.secretaryError("Student not found", id);
    }

    @Override
    public void SecretaryCreateClass(String classNr, String classLetter, String teacherId, Long id)
    {
        classes.add(new Class(Integer.valueOf(classNr), classLetter.charAt(0), teacherId, null, null));
        tier2Connection.openSecretary(getSecretaryData("0"), id);
    }

    @Override
    public void SecretaryDeleteClass(String classLetter, String classNr, Long id)
    {
        for (int i = 0; i < classes.size(); i++)
            if (classes.get(i).getLetter() == classLetter.charAt(0) && classes.get(i).getYear() == Integer.parseInt(classNr))
            {
                classes.remove(classes.get(i));
                tier2Connection.openSecretary(getSecretaryData("0"), id);
            }
        tier2Connection.secretaryError("Class not found", id);
    }

    @Override
    public void SecretaryCLassAddStudent(String classNr, String classLetter, String studentId, long id)
    {
        for(int i = 0; i < classes.size(); i++)
        {
            if(classes.get(i).getLetter() == classLetter.charAt(0) && classes.get(i).getYear() == Integer.parseInt(classNr))
            {
                for (int j = 0; j < studentsA.size(); j++)
                    if (studentsA.get(j).getId().equals(studentId))
                    {
                        if(classes.get(i).getStudents() == null)
                        {
                            ArrayList<Student> auxStudList = new ArrayList<Student>();
                            auxStudList.add(studentsA.get(j));
                            classes.get(i).setStudents(auxStudList);
                        }
                        else {
                            ArrayList<Student> auxStudList = classes.get(i).getStudents();
                            auxStudList.add(studentsA.get(j));
                            classes.get(j).setStudents(auxStudList);
                        }
                        tier2Connection.openSecretary(getSecretaryData("0"), id);
                    }
                for (int j = 0; j < studentsB.size(); j++)
                    if (studentsB.get(j).getId().equals(studentId))
                    {
                        if(classes.get(i).getStudents() == null)
                        {
                            ArrayList<Student> auxStudList = new ArrayList<Student>();
                            auxStudList.add(studentsB.get(j));
                            classes.get(i).setStudents(auxStudList);
                        }
                        else {
                            ArrayList<Student> auxStudList = classes.get(i).getStudents();
                            auxStudList.add(studentsB.get(j));
                            classes.get(j).setStudents(auxStudList);
                        }
                        tier2Connection.openSecretary(getSecretaryData("0"), id);
                    }
                tier2Connection.secretaryError("Student not found", id);
            }

        }
        tier2Connection.secretaryError("Class not found", id);
    }

    @Override
    public void SecretaryClassRemoveStudent(String classNr, String classLetter, String studentId, long id)
    {
        for(int i = 0; i < classes.size(); i++)
        {
            if(classes.get(i).getLetter() == classLetter.charAt(0) && classes.get(i).getYear() == Integer.parseInt(classNr))
            {
                for (int j = 0; j < classes.get(i).getStudents().size(); j++)
                {
                    if(classes.get(i).getStudents().get(j).getId().equals(studentId))
                    {
                        classes.get(i).getStudents().remove(j);
                        tier2Connection.openSecretary(getSecretaryData("0"), id);
                    }
                }
                tier2Connection.secretaryError("Student not found", id);
            }

        }
        tier2Connection.secretaryError("Class not found", id);
    }

    @Override
    public void SecretaryClassAddCourse(String classNr, String classLetter, String courseName, long id)
    {
        for(int i = 0; i < classes.size(); i++)
        {
            if(classes.get(i).getLetter() == classLetter.charAt(0) && classes.get(i).getYear() == Integer.parseInt(classNr))
            {
                if(classes.get(i).getCourses() == null)
                {
                    ArrayList<Course> newCourses = new ArrayList<Course>();
                    newCourses.add(new Course(courseName));
                    classes.get(i).setCourses(newCourses);
                }
                else
                {
                    ArrayList<Course> newCourses = classes.get(i).getCourses();
                    newCourses.add(new Course(courseName));
                    classes.get(i).setCourses(newCourses);
                }
                tier2Connection.openSecretary(getSecretaryData("0"), id);
            }

        }
        tier2Connection.secretaryError("Class not found", id);
    }

    @Override
    public void SecretaryClassRemoveCourse(String classNr, String classLetter, String courseName, long id)
    {
        for(int i = 0; i < classes.size(); i++)
        {
            if(classes.get(i).getLetter() == classLetter.charAt(0) && classes.get(i).getYear() == Integer.parseInt(classNr))
            {
                for (int j = 0; j < classes.get(i).getCourses().size(); j++)
                {
                    if(classes.get(i).getCourses().get(j).getName().equals(courseName))
                    {
                        classes.get(i).getCourses().remove(j);
                        tier2Connection.openSecretary(getSecretaryData("0"), id);
                    }
                }
                tier2Connection.secretaryError("Course not found", id);
            }

        }
        tier2Connection.secretaryError("Class not found", id);
    }
}
