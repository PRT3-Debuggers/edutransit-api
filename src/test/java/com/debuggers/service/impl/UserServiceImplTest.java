package com.debuggers.service.impl;

/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.User;
import com.debuggers.factory.UserFactory;
import com.debuggers.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTest {

    private UserRepository userRepo;
    private UserServiceImpl userService;
    private User testUser;

    @BeforeEach
    void setUp() {
        userRepo = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepo);

        testUser = new User.Builder()
                .setId(2L)
                .setFirstName("Bonga")
                .setLastName("Velem")
                .setEmailAddress("bonga@example.com")
                .setPassword("SecurePass@123")
                .build();
    }

    @Test
    void getAllUser() {
        when(userRepo.findAll()).thenReturn(List.of(testUser)); // returns a List

        Set<User> users = userService.getAllUser(); // converted to Set in service

        assertNotNull(users);
        assertEquals(1, users.size());
        assertTrue(users.contains(testUser));
        verify(userRepo).findAll();
    }

    @Test
    void read() {
        when(userRepo.findById(1L)).thenReturn(Optional.of(testUser));

        Optional<User> result = userService.read(1L);

        assertTrue(result.isPresent());
        assertEquals("Bonga", result.get().getFirstName());
        verify(userRepo).findById(1L);
        System.out.println("Read user: " + result);
    }

    @Test
    void create() {
        when(userRepo.save(testUser)).thenReturn(testUser);

        User result = userService.create(testUser);

        assertNotNull(result);
        assertEquals("Bonga", result.getFirstName());
        verify(userRepo).save(testUser);
        System.out.println(testUser);
    }

    @Test
    void update() {
        when(userRepo.save(testUser)).thenReturn(testUser);

        User result = userService.update(testUser);

        assertNotNull(result);
        // assertEquals("USER-001", result.getId());
        verify(userRepo).save(testUser);
    }

    @Test
    void delete() {
        doNothing().when(userRepo).deleteById(1L);

        userService.delete(1L);

        verify(userRepo).deleteById(1L);
    }
}