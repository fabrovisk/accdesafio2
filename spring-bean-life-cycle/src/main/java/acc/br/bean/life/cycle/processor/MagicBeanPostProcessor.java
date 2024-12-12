package acc.br.bean.life.cycle.processor;

import org.springframework.beans.factory.config.BeanPostProcessor;

import acc.br.bean.life.cycle.beans.Character;
import acc.br.bean.life.cycle.beans.Item;
import acc.br.bean.life.cycle.beans.Weapon;

public class MagicBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof Character) {
            System.out.println("5. -Character- BeanPostProcessor: Adding a touch of magic to " + ((Character) bean).getName());
        } else if (bean instanceof Weapon) {
            System.out.println("5. -Weapon- BeanPostProcessor: Adding a touch of magic to " + ((Weapon) bean).getName());
        } else if (bean instanceof Item) {
            System.out.println("5. -Item- BeanPostProcessor: Adding a touch of magic to " + ((Item) bean).getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof Character) {
            System.out.println("9. -Character- BeanPostProcessor: Magic continues for " + ((Character) bean).getName());
        } else if (bean instanceof Weapon) {
            System.out.println("9. -Weapon- BeanPostProcessor: Magic continues for " + ((Weapon) bean).getName());
        } else if (bean instanceof Item) {
            System.out.println("9. -Item- BeanPostProcessor: Magic continues for " + ((Item) bean).getName());
        }
        return bean;
    }
    
}

