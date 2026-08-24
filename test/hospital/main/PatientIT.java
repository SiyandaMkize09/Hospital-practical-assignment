/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package hospital.main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SIYANDA
 */
public class PatientIT {
    
    public PatientIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPatientId method, of class Patient.
     */
    @Test
    public void testGetPatientId() {
        System.out.println("getPatientId");
        Patient instance = null;
        String expResult = "";
        String result = instance.getPatientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFirstName method, of class Patient.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Patient instance = null;
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getLastName method, of class Patient.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Patient instance = null;
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAge method, of class Patient.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Patient instance = null;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getGender method, of class Patient.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Patient instance = null;
        String expResult = "";
        String result = instance.getGender();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMedicalCondition method, of class Patient.
     */
    @Test
    public void testGetMedicalCondition() {
        System.out.println("getMedicalCondition");
        Patient instance = null;
        String expResult = "";
        String result = instance.getMedicalCondition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCategory method, of class Patient.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Patient instance = null;
        PatientCategory expResult = null;
        PatientCategory result = instance.getCategory();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFirstName method, of class Patient.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Patient instance = null;
        instance.setFirstName(firstName);
       
    }

    /**
     * Test of setLastName method, of class Patient.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Patient instance = null;
        instance.setLastName(lastName);
       
    }

    /**
     * Test of setAge method, of class Patient.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 0;
        Patient instance = null;
        instance.setAge(age);
     
    }

    /**
     * Test of setGender method, of class Patient.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "";
        Patient instance = null;
        instance.setGender(gender);
       
    }

    /**
     * Test of setMedicalCondition method, of class Patient.
     */
    @Test
    public void testSetMedicalCondition() {
        System.out.println("setMedicalCondition");
        String medicalCondition = "";
        Patient instance = null;
        instance.setMedicalCondition(medicalCondition);
  
    }

    /**
     * Test of setCategory method, of class Patient.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        PatientCategory category = null;
        Patient instance = null;
        instance.setCategory(category);
        // TODO review the generated
    }

    /**
     * Test of displayPatient method, of class Patient.
     */
    @Test
    public void testDisplayPatient() {
        System.out.println("displayPatient");
        Patient instance = null;
        instance.displayPatient();
       
    }
    
}
