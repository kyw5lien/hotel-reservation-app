package helperclasses;

import services.CustomerService;

import java.util.Collection;
import java.util.Random;

public abstract class RandomCollectionElement {
    /**
     * @author stackoverflow-user: Autocrab
     */
    public static Object getRandomElement(Collection collection){
        Random random = new Random();
        int i = random.nextInt(collection.size());
        return collection.toArray()[i];
    }
}
