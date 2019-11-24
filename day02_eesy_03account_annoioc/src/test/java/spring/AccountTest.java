package spring;

import com.envision.spring.domain.Account;
import com.envision.spring.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
    IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");

    @Test
    public void findAllTest() {

        accountService.findAllAccount().forEach(System.out::println);
    }

    @Test
    public void findOneByIdTest() {

        System.out.println(accountService.findAccountById(1));
    }

    @Test
    public void saveTest() {
        Account account = new Account(4, "my", 1000f);
        accountService.saveAccount(account);
    }
}
