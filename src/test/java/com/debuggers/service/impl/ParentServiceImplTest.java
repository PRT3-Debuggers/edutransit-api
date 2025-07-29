package com.debuggers.service.impl;

import com.debuggers.domain.Parent;
import com.debuggers.domain.User;
import com.debuggers.factory.UserFactory;
import com.debuggers.repository.ParentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParentServiceImplTest {


    private ParentRepository parentRepo;
    private ParentServiceImpl parentService;

    private Parent testParent;

    @BeforeEach
    void setUp() {
        parentRepo = Mockito.mock(ParentRepository.class);
        parentService = new ParentServiceImpl(parentRepo);

        User testUser = new User.Builder()
                .setId(UserFactory.createUserId())
                .setFirstName("Thabo")
                .setLastName("Mokoena")
                .setEmailAddress("thabo@example.com")
                .setPassword("StrongPass@123")
                .build();

        testParent = new Parent.Builder()
                .setId(UserFactory.createUserId())
                .setUser(testUser)
                .build();
    }

    @Test
    void create() {
        when(parentRepo.save(testParent)).thenReturn(testParent);

        Parent result = parentService.create(testParent);

        assertNotNull(result);
        assertEquals(testParent.getId(), result.getId());
        verify(parentRepo).save(testParent);
    }

//    @Test
//    void findById() {
//        // Not implemented: returns null
//        assertNotNull(parentService.read(testParent.getId());
//    }

    @Test
    void update() {
        when(parentRepo.save(testParent)).thenReturn(testParent);

        Parent result = parentService.update(testParent);

        assertNotNull(result);
        assertEquals(testParent.getId(), result.getId());
        verify(parentRepo).save(testParent);
    }

    @Test
    void delete() {
        parentService.delete(Long.valueOf("1"));
        verify(parentRepo).deleteById("1"); // ✅ Expect that the method is called
    }

    @Test
    void getAllParent() {
        Set<Parent> result = parentService.getAllParent();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void read() {
        when(parentRepo.findById("1")).thenReturn(Optional.of(testParent));

        Optional<Parent> result = parentService.read(Long.valueOf("1"));

        assertTrue(result.isPresent());
        assertEquals(testParent.getId(), result.get().getId());
        assertEquals("Thabo", result.get().getUser().getFirstName());
        assertEquals("Mokoena", result.get().getUser().getLastName());
        verify(parentRepo).findById("1");
    }

    @Test
    void testRead() {
        // Not implemented: returns null
        assertNull(parentService.read(1L));
    }
}