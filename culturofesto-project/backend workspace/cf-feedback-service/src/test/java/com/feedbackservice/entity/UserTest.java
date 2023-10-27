package com.feedbackservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.feedbackservice.role.Role;
import org.junit.jupiter.api.Test;

class UserTest {
    
    @Test
    void testCanEqual() {
        assertFalse((new User()).canEqual("Other"));
    }

   
    @Test
    void testCanEqual2() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertTrue(user.canEqual(user2));
    }

    
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setId(1L);
        actualUser.setRole(Role.USER);
        actualUser.setUserEmail("jane.doe@example.org");
        actualUser.setUserName("janedoe");
        actualUser.setUserPassword("iloveyou");
        String actualToStringResult = actualUser.toString();
        assertEquals(1L, actualUser.getId().longValue());
        assertEquals(Role.USER, actualUser.getRole());
        assertEquals("jane.doe@example.org", actualUser.getUserEmail());
        assertEquals("janedoe", actualUser.getUserName());
        assertEquals("iloveyou", actualUser.getUserPassword());
        assertEquals("User(id=1, userName=janedoe, userPassword=iloveyou, userEmail=jane.doe@example.org, role=USER)",
                actualToStringResult);
    }

    @Test
    void testConstructor2() {
        User actualUser = new User(1L, "janedoe", "iloveyou", "jane.doe@example.org", Role.USER);
        actualUser.setId(1L);
        actualUser.setRole(Role.USER);
        actualUser.setUserEmail("jane.doe@example.org");
        actualUser.setUserName("janedoe");
        actualUser.setUserPassword("iloveyou");
        String actualToStringResult = actualUser.toString();
        assertEquals(1L, actualUser.getId().longValue());
        assertEquals(Role.USER, actualUser.getRole());
        assertEquals("jane.doe@example.org", actualUser.getUserEmail());
        assertEquals("janedoe", actualUser.getUserName());
        assertEquals("iloveyou", actualUser.getUserPassword());
        assertEquals("User(id=1, userName=janedoe, userPassword=iloveyou, userEmail=jane.doe@example.org, role=USER)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        assertNotEquals(user, null);
    }

    @Test
    void testEquals2() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        assertNotEquals(user, "Different type to User");
    }

  
    @Test
    void testEquals3() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        assertEquals(user, user);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user.hashCode());
    }

    @Test
    void testEquals4() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertEquals(user, user2);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user2.hashCode());
    }

    
    @Test
    void testEquals5() {
        User user = new User();
        user.setId(2L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

   
    @Test
    void testEquals6() {
        User user = new User();
        user.setId(null);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

   
    @Test
    void testEquals7() {
        User user = new User();
        user.setId(1L);
        user.setRole(null);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

    @Test
    void testEquals8() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.ADMIN);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

    
    @Test
    void testEquals9() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("john.smith@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

    void testEquals10() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail(null);
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

   
    @Test
    void testEquals11() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("iloveyou");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

   
    @Test
    void testEquals12() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName(null);
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

   
    @Test
    void testEquals13() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("janedoe");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

        @Test
    void testEquals14() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword(null);

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertNotEquals(user, user2);
    }

   
    @Test
    void testEquals15() {
        User user = new User();
        user.setId(null);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(null);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertEquals(user, user2);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user2.hashCode());
    }

  
    @Test
    void testEquals16() {
        User user = new User();
        user.setId(1L);
        user.setRole(null);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(null);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertEquals(user, user2);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user2.hashCode());
    }

   
    @Test
    void testEquals17() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail(null);
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail(null);
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        assertEquals(user, user2);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user2.hashCode());
    }
}

