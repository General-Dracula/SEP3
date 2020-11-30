package com.example.tier3NetworkPackages;

public enum NetworkType
{
  //Log In
    LogInRequest,
    LogInError,

    //Get Student Data
    StudentData,



  TeacherData,
  TeacherError,

  TeacherAssignGrade,
  TeacherAssignAbsence,
  TeacherMotivateAbsence,

  SecretaryData,
  SecretaryError,
  SecretaruCreateTeacher,
  SecretaryEditTeacher,
  SecretaryDeleteTeacher,

  SecretaryCreateStudent,
  SecretaryDeleteStudent,
  SecretaryEditStudent,

  SecretaryCreateClass,
  SecretaryDeleteClass,
  SecretaryClassAddStudent,
  SecretaryClassRemoveStudent,
  SecretaryClassAddCourse,
  SecretaryClassRemoveCourse,
  SecretaryChangeUsername,
  SecretaryChangePassword

}
