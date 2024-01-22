package com.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.unit.user.User;
import com.unit.user.UserCalculate;
import org.junit.jupiter.api.Test;

public class UserServiceTests {

    @Test
    void getFullname() {
        User user= new User();
        user.setName("name");
        assertEquals("name name", new UserCalculate().calculateFullName(user.getName()));
    }

    @Test
    void getFullname_mock() {
        UserCalculate uc = mock(UserCalculate.class);
        User user= new User();
        user.setName("name");

        when(uc.calculateFullName(eq("name"))).thenReturn("mock name");
        when(uc.calculateFullName(eq("oleksandr"))).thenReturn("mock oleksandr");
        assertEquals("mock name", uc.calculateFullName(user.getName()));

        user.setName("oleksandr");
        assertEquals("mock oleksandr", uc.calculateFullName(user.getName()));


        when(uc.calculateFullName(any())).thenReturn("mock name").thenReturn("mock ivan");

        assertEquals("mock name", uc.calculateFullName(user.getName()));
        assertEquals("mock ivan", uc.calculateFullName(user.getName()));

        verify(uc, times(4)).calculateFullName(any());
        verify(uc, times(1)).calculateFullName("name");
        verify(uc, times(3)).calculateFullName("oleksandr");

    }


}
