/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rbimm5674
 */
public class MemberTest {
    
    public MemberTest() {
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
     * Test of getFullName method, of class Member.
     */
    @Test
    public void testGetFullName_Name() {
        System.out.println("getFullNameName");
        Member instance = new Member();
        instance.setFullName("Name");
        String expResult = "Name";
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailAddress method, of class Member.
     */
    @Test
    public void testGetEmailAddress_EAtE() {
        System.out.println("getEmailAddressE@E");
        Member instance = new Member();
        instance.setEmailAddress("E@E");
        String expResult = "E@E";
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class Member.
     */
    @Test
    public void testGetPhoneNumber_1() {
        System.out.println("getPhoneNumber1");
        Member instance = new Member();
        instance.setPhoneNumber("1");
        String expResult = "1";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProgramName method, of class Member.
     */
    @Test
    public void testGetProgramName_CPA() {
        System.out.println("getProgramNameCPA");
        Member instance = new Member();
        instance.setProgramName("CPA");
        String expResult = "CPA";
        String result = instance.getProgramName();
        assertEquals(expResult, result);
    }


    /**
     * Test of getYearLevel method, of class Member.
     */
    @Test
    public void testGetYearLevel_1() {
        System.out.println("getYearLevel1");
        Member instance = new Member();
        instance.setYearLevel(1);
        int expResult = 1;
        int result = instance.getYearLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, of class Member.
     */
    @Test
    public void testIsValid_False() {
        System.out.println("isValid");
        Member instance = new Member();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test if instance is valid
     */
    @Test
    public void testValidPositive(){
        System.out.println("testValidPostive");
        Member instance = new Member("Name", "Email@email.com");
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }
    /**
     * Test if instance is not valid
     */
    @Test
    public void testValidNegative(){
        System.out.println("testValidNegative");
        Member instance = new Member(null, "Email@email.com");
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }
}
