package ru.job4j.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    private RoleStore roleStore;

    @BeforeEach
    void setUp() {
        roleStore = new RoleStore();
    }

    @Test
    void whenAddRoleThenCanFindById() {
        roleStore.add(new Role("1", "user"));
        Role result = roleStore.findById("1");
        assertThat(result)
                .isNotNull()
                .extracting(Role::getRoleName)
                .isEqualTo("user");
    }

    @Test
    void whenAddDuplicateIdThenFirstRoleIsStored() {
        roleStore.add(new Role("1", "user"));
        roleStore.add(new Role("1", "admin"));
        Role result = roleStore.findById("1");
        assertThat(result)
                .isNotNull()
                .extracting(Role::getRoleName)
                .isEqualTo("user");
    }

    @Test
    void whenReplaceExistingRoleThenNewRoleIsStored() {
        roleStore.add(new Role("1", "user"));
        roleStore.replace("1", new Role("1", "admin"));
        Role result = roleStore.findById("1");
        assertThat(result)
                .isNotNull()
                .extracting(Role::getRoleName)
                .isEqualTo("admin");
    }

    @Test
    void whenReplaceSuccessfulThenReturnTrue() {
        roleStore.add(new Role("1", "user"));
        boolean result = roleStore.replace("1", new Role("1", "admin"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceFailsThenReturnFalse() {
        roleStore.add(new Role("1", "user"));
        boolean result = roleStore.replace("10", new Role("10", "admin"));
        assertThat(result).isFalse();
    }

    @Test
    void whenFindByIdNonExistingRoleThenReturnNull() {
        Role result = roleStore.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenDeleteRoleThenRoleNotFound() {
        roleStore.add(new Role("1", "user"));
        roleStore.delete("1");
        Role result = roleStore.findById("1");
        assertThat(result).isNull();
    }

}