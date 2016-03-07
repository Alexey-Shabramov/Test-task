package com.test.task.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
@Transactional
public class PasswordUtilTest {
    @Test
    public void testEncryptPassword() {
        String newPassword = "abigai111";
        assertNotNull(PasswordUtil.encryptPassword(newPassword));
        assertFalse(StringUtils.isBlank(PasswordUtil.encryptPassword(newPassword)));
        assertNotEquals(PasswordUtil.encryptPassword(newPassword), PasswordUtil.encryptPassword("abigai11"));
    }
}
