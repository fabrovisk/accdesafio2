//package acc.br.bean.life.cycle.beans;

//public class Weapon {
//    private String name;

//    public Weapon(String name) {
//        this.name = name;
//    }

//    public String getName() {
//        return name;
//    }
//}


package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Weapon implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Weapon(String name) {
        System.out.println("1. -Weapon- Instantiation: A new weapon has been created.");
        this.name = name;
    }

	public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. -Weapon- BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. -Weapon- BeanFactoryAware: Setting bean factory for " + getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. -Weapon- ApplicationContextAware: Setting application context.");
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        System.out.println("6. -Weapon- @PostConstruct: " + getName() + " is prepared for use.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. -Weapon- Initialization: " + getName() + " is ready for use.");
    }

    public void customInit() {
        System.out.println("8. -Weapon- Custom Initialization: Executing custom init for " + getName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. -Weapon- @PreDestroy: " + getName() + " is preparing for disposal.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. -Weapon- DisposableBean: " + getName() + " is being disposed.");
        restAndRecover();
    }

    private void restAndRecover() {
        System.out.println("12. -Weapon- DisposableBean: " + getName() + " is being disassembled and secured for storage.");
    }

    public void customDestroy() {
        System.out.println("13. -Weapon- Custom Destruction: " + getName() + " is performing a final action.");

    }
}
