package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class UserServiceTest {

    @Test
    void testGetUserById() {
        UserRepository userRepositoryMock = mock(UserRepository.class);
        UserService userService = new UserService(userRepositoryMock);
        User expectedUser = new User(1L, "oussama");

        when(userRepositoryMock.findUserById(1L)).thenReturn(expectedUser);

        User result = userService.getUserById(1L);

        assertEquals(1L, result.getId());
        assertEquals("oussama", result.getName());
        verify(userRepositoryMock).findUserById(1L);
    }
}