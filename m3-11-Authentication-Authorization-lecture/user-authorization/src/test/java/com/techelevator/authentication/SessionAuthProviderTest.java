package com.techelevator.authentication;

import javax.servlet.http.HttpSession;

import com.techelevator.model.User;
import com.techelevator.model.UserDao;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * SessionAuthProviderTest
 */
public class SessionAuthProviderTest {
    private SessionAuthProvider sut;
    private HttpSession mockedSession;
    private UserDao mockedDao;

    @Before
    public void before() {
        mockedSession = mock(HttpSession.class);
        mockedDao = mock(UserDao.class);
        sut = new SessionAuthProvider(mockedSession, mockedDao);
    }

    @Test
    public void testLogOut() {
        sut.logOff();

        verify(mockedSession).removeAttribute(SessionAuthProvider.USER_KEY);
        verify(mockedSession).invalidate();
    }

    @Test
    public void isLoggedInSuccessTest() {
        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(new User());

        assertTrue(sut.isLoggedIn());
    }

    @Test
    public void isLoggedInFailTest() {
        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(null);

        assertFalse(sut.isLoggedIn());
    }

    @Test
    public void getCurrentUserWithUserTest() {
        User mockedUser = new User();
        mockedUser.setId(0);
        mockedUser.setUsername("TEST");

        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(mockedUser);

        User fromSut = sut.getCurrentUser();

        assertEquals(mockedUser.getId(), fromSut.getId());
        assertEquals(mockedUser.getUsername(), fromSut.getUsername());
    }

    @Test
    public void getCurrentUserWithNullTest() {
        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(null);

        User fromSut = sut.getCurrentUser();

        assertNull(fromSut);
    }

    @Test
    public void registerTest() {
        sut.register("TEST", "TESTPASS", "TESTROLE");

        verify(mockedDao).saveUser("TEST", "TESTPASS", "TESTROLE");
    }

    @Test
    public void signInSuccessTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");
        when(mockedDao.getValidUserWithPassword("TEST", "TEST")).thenReturn(testUser);

        assertTrue(sut.signIn("TEST", "TEST"));
        verify(mockedSession).setAttribute(SessionAuthProvider.USER_KEY, testUser);
    }

    @Test
    public void signInFailTest() {
        when(mockedDao.getValidUserWithPassword("TEST", "TEST")).thenReturn(null);

        assertFalse(sut.signIn("TEST", "TEST"));
    }

    @Test
    public void changePasswordSuccessTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");

        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(testUser);
        when(mockedDao.getValidUserWithPassword("TEST", "TEST")).thenReturn(testUser);

        assertTrue(sut.changePassword("TEST", "NEWVALUE"));
        verify(mockedDao).changePassword(testUser, "NEWVALUE");
    }

    @Test
    public void changePasswordBadPasswordTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");

        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(testUser);
        when(mockedDao.getValidUserWithPassword("TEST", "TEST")).thenReturn(null);

        assertFalse(sut.changePassword("TEST", "NEWVALUE"));
        verify(mockedDao, times(0)).changePassword(testUser, "NEWVALUE");
    }

    @Test
    public void changePasswordNoOneLoggedInTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");

        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(null);
        when(mockedDao.getValidUserWithPassword("TEST", "TEST")).thenReturn(testUser);

        assertFalse(sut.changePassword("TEST", "NEWVALUE"));
        verify(mockedDao, times(0)).changePassword(testUser, "NEWVALUE");
    }

    @Test
    public void hasRoleSuccessTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");
        testUser.setRole("user");

        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(testUser);

        assertTrue(sut.userHasRole(new String[] {"user"}));
    }

    @Test
    public void hasRoleFailTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");
        testUser.setRole("user");
        
        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(testUser);

        assertFalse(sut.userHasRole(new String[] {"admin"}));
    }

    @Test
    public void hasRoleMultipleSuccessTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");
        testUser.setRole("user");
        
        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(testUser);

        assertTrue(sut.userHasRole(new String[] {"admin", "user", "editor"}));
    }

    @Test
    public void hasRoleMultipleFailTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");
        testUser.setRole("user");
        
        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(testUser);

        assertFalse(sut.userHasRole(new String[] {"admin", "manager", "editor"}));
    }

    @Test
    public void hasRoleNullTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");
        testUser.setRole("user");
        
        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(testUser);

        assertFalse(sut.userHasRole(null));
    }

    @Test
    public void hasRoleEmptyTest() {
        User testUser = new User();
        testUser.setId(0);
        testUser.setUsername("TEST");
        testUser.setRole("user");
        
        when(mockedSession.getAttribute(SessionAuthProvider.USER_KEY)).thenReturn(testUser);

        assertFalse(sut.userHasRole(new String[] {}));
    }
}