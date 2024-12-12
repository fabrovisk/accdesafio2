//package acc.br.bean.life.cycle.beans;

//public class Item {
//    private String name;

//    public Item(String name) {
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

public class Item implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Item(String name) {
        System.out.println("1. -Item- Instantiation: A new item has been created.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. -Item- BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. -Item- BeanFactoryAware: Setting bean factory for " + getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. -Item- ApplicationContextAware: Setting application context.");
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        System.out.println("6. -Item- @PostConstruct: " + getName() + " is prepared for use.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. -Item- Initialization: " + getName() + " is ready for use.");
    }

    public void customInit() {
        System.out.println("8. -Item- Custom Initialization: Executing custom init for " + getName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. -Item- @PreDestroy: " + getName() + " is preparing for disposal.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. -Item- DisposableBean: " + getName() + " is being disposed.");
        restAndRecover();
    }

    private void restAndRecover() {
        System.out.println("12. -Item- DisposableBean: " + getName() + " is being processed and prepared for recycling.");
    }

    public void customDestroy() {
        System.out.println("13. -Item- Custom Destruction: " + getName() + " is performing a final action.");

    }
}
