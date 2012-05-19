/**
 * 
 */
package simplejpa.core.repository;

import javax.inject.Inject;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import simplejpa.user.User;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:spring-test.xml"} )
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Transactional
public class DefaultRepositoryTest {
    
    @Inject
    DefaultRepository repository;
    
    @Test(expected = NotFoundException.class)
    public void shouldThrowExceptionWhenModelNotFound() throws NotFoundException {
        User u = getUser();
        u.setId(-1l);
        repository.read(u);
    }
    
    @Test
    public void shouldAbleToCreateModel() throws NotFoundException {
        User u = getUser();
        repository.create(u);
        assertNotNull(u.getId());
        assertEquals(1, repository.getAll(User.class).size());
    }
    
    @Test
    public void shouldAbleDeleteModel() throws NotFoundException {
        User u = getUser();
        repository.create(u);
        assertNotNull(u.getId());
        assertEquals(1, repository.getAll(User.class).size());
        repository.delete(u);
        assertEquals(0, repository.getAll(User.class).size());
    }
    
    @Test
    public void shouldAbleUpdateModel() throws NotFoundException {
        User u = getUser();
        u.setEmail("user@example.com");
        repository.create(u);
        assertNotNull(u.getId());
        assertEquals(1, repository.getAll(User.class).size());
        User tmp = repository.read(u);
        tmp.setEmail("user1@example.com");
        User newUser = repository.update(tmp);
        assertNotNull(tmp);
        assertEquals(u.getId(), newUser.getId());
        assertEquals("user1@example.com", newUser.getEmail());
    }
    
    
    private User getUser() {
        User u = new User();
        u.setEmail("email");
        u.setPassword("password");
        u.setUsername("username");
        return u;
    }
}
