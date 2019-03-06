package Internal;

public class FinishField extends Field {

    @Override
    public void acceptAnimal(Animal animal) {
        animal.goToZoo();
    }
}
