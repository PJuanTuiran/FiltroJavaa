package com.riwi;

import com.riwi.controller.CourseController;
import com.riwi.controller.InscriptionController;
import com.riwi.controller.ScoreController;
import com.riwi.controller.StudentController;
import com.riwi.entities.CourseEntity;
import com.riwi.entities.InscriptionEntity;
import com.riwi.entities.ScoreEntity;
import com.riwi.entities.StudentEntity;
import com.riwi.persistence.ConfigDB;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// menu que interactua con el usario
        int optionManager = 0, optionCRUD = 0, optionSearch = 0;
        do {
           optionManager =  getValidIntegerInput("""
            1. student Manager
            2. course Manager
            3. inscription Manager
            4. score Manager Manager
            5. Exit
            
            Enter your option:
            """, 1, 5);

            switch (optionManager) {
                case 1:
                    do {
                       optionCRUD= getValidIntegerInput("""
                        1. Create Student
                        2. Update Student
                        3. Search Student
                        4. Exit
                        
                        Enter your option:
                        """,1,4);

                        switch (optionCRUD) {
                            case 1:
                                String name = "";
                                String email = "";
                                // simple validacion de un input tipo string
                                while (name.isEmpty()) {
                                    name = JOptionPane.showInputDialog("insert student name");
                                    if (name == null || name.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Model cannot be empty. Please enter a valid model.");
                                        name= "";
                                    }
                                }

                                while (email.isEmpty()) {
                                    email = JOptionPane.showInputDialog("insert the email");
                                    if (email == null || email.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Model cannot be empty. Please enter a valid model.");
                                        email= "";
                                    }
                                }


                                StudentEntity student = new StudentEntity();
                                student.setName(name);
                                student.setEmail(email);
                                StudentController.create(student);
                                break;

                            case 2:

                                String nameUp = "";
                                String emailUp = "";
                                Boolean status = null;

                                int id = -1;
                                while (id <= 0) {
                                    String idStr = JOptionPane.showInputDialog("Enter the ID of the student you want to update");
                                    try {
                                        id = Integer.parseInt(idStr);
                                        if (id <= 0) {
                                            JOptionPane.showMessageDialog(null, "must be a positive number. Please enter a valid number.");
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number");
                                    }
                                }
                                while (nameUp.isEmpty()) {
                                    nameUp = JOptionPane.showInputDialog("insert student name");
                                    if (nameUp == null || nameUp.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "name cannot be empty. Please enter a valid name");
                                        nameUp= "";
                                    }
                                }

                                while (emailUp.isEmpty()) {
                                    emailUp = JOptionPane.showInputDialog("insert the email");
                                    if (emailUp == null || emailUp.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "email cannot be empty. Please enter a valid email.");
                                        emailUp= "";
                                    }
                                }



                                StudentEntity studentUpdate = new StudentEntity();
                                studentUpdate.setName(nameUp);
                                studentUpdate.setEmail(emailUp);

                                StudentController.update(studentUpdate, id);



                                break;

                            case 3:
                                do {
                                   optionSearch =  getValidIntegerInput("""
                                            1. Search By Id
                                            2. Serach By email
                                            3. Search ALl
                                            4. exit
                                            """,1,4);



                                    switch (optionSearch) {
                                        case 1:
                                            int idToSearch = getValidInt("insert the ID to search");
                                            StudentController.readById(idToSearch);

                                            break;

                                        case 2:

                                            String emailToSearch = getValidString("Insert the EMAIL to search");
                                            StudentController.readByEmail(emailToSearch);

                                        case 3:
                                            StudentController.getAll();

                                            break;


                                    }
                                } while (optionSearch != 4);
                                break;
                        }
                    } while (optionCRUD != 4);
                    break;
                case 2:
                    do {
                       optionCRUD =  getValidIntegerInput("""
                        1. Create Course
                        2. Search Course
                        3. Delete Course
                        4. Update Course
                        5. Exit
                        
                        Enter your option:
                        """,1,5);

                        switch (optionCRUD) {
                            case 1:

                                String nameCourse = getValidString("insert the name of course");
                                CourseEntity courseCreated = new CourseEntity();
                                courseCreated.setName(nameCourse);

                                CourseController.create(courseCreated);


                                break;

                            case 2:
                                CourseController.getAll();

                                break;

                            case 3:
                                int idToDelete = getValidInt("insert the ID to delete");
                                CourseController.delete(idToDelete);

                                break;

                            case 4:

                                int idToUpdate = getValidInt("Insert the ID to upadate");
                                String nameNew = getValidString("Insert the new Name");

                                CourseEntity courseEntity = new CourseEntity();
                                courseEntity.setName(nameNew);
                                CourseController.update(courseEntity, idToUpdate);

                                break;
                        }
                    } while (optionCRUD != 5);
                    break;
                case 3:
                    do {
                        optionCRUD = getValidIntegerInput("""
                        1. Create Inscription
                        2. Delete Inscription
                        3. Exit
                    
                        
                        Enter your option:
                        """, 1, 3);

                        switch (optionCRUD) {
                            case 1:
                                String fecha = JOptionPane.showInputDialog("Inset the date");
                                Time hora = Time.valueOf(JOptionPane.showInputDialog("insert the time"));
                                InscriptionEntity inscriptionEntity = new InscriptionEntity();
                                inscriptionEntity.setFechaInscription(fecha);
                                inscriptionEntity.setHoraInscription(hora);
                                InscriptionController.create(inscriptionEntity);


                                break;

                            case 2:
                                int IdInsDele = getValidInt("insert the ID to delete");
                                InscriptionController.delete(IdInsDele);
                                break;


                            case 3:

                                break;

                            case 4:

                                break;
                        }
                    } while (optionCRUD != 5);
                    break;
                case 4:
                    do {
                       optionCRUD =  getValidIntegerInput("""
                        1. Create Score
                        2. Update Score
                        3. Exit
                        
                        Enter your option:
                        """,1,3);

                        switch (optionCRUD) {
                            case 1:
                                String description = getValidString("insert the description");
                                int score = getValidInt("insert the score");
                                ScoreEntity scoreEntity = new ScoreEntity();
                                scoreEntity.setDescription(description);
                                scoreEntity.setValue((double) score);
                                ScoreController.create(scoreEntity);

                                break;

                            case 2:
                                int idScore = getValidInt("insert the ID to update");
                                String descriptionNew = getValidString("insert to description to update");
                                int scoreNerw = getValidInt("insert the new score");
                                ScoreEntity scoreUpdated = new ScoreEntity();
                                scoreUpdated.setDescription(descriptionNew);
                                scoreUpdated.setValue((double) scoreNerw);
                                ScoreController.update(scoreUpdated, idScore);



                               break;


                        }
                    } while (optionCRUD != 5);
                    break;
            }
        } while (optionManager != 5);

        JOptionPane.showMessageDialog(null, "Thank you for using our application!");
    }
    // metodo para validar la entrada del menu principal
    private static int getValidIntegerInput(String message, int min, int max) {
        while (true) {
            String input = JOptionPane.showInputDialog(message);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía. Intente nuevamente.");
                continue;
            }
            try {
                int value = Integer.parseInt(input.trim());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número válido.");
            }
        }
    }
    // metodo para validar inputs de tipo entenro
    private static int getValidInt(String mss){
        while (true) {
            String numberI = JOptionPane.showInputDialog(mss);
            if (numberI == null || numberI.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía. Intente nuevamente.");
                continue;
            }
            try {
                int value = Integer.parseInt(numberI.trim());
                return value;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número válido.");
            }
        }
    }
   // metodo para validar inputs de tipo String
    private static String getValidString(String mss){
        String string = JOptionPane.showInputDialog(mss);
        while (string.isEmpty()) {
            string = JOptionPane.showInputDialog("insert the email");
            if (string == null || string.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "email cannot be empty. Please enter a valid email.");
                string = "";
            }
        };
        return string;
    }



}