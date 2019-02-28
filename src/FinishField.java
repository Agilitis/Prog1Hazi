public class FinishField extends Field {

    @Override
    public void acceptAnimal(Animal animal) {
        givePoint(animal.getPointValue());
        animal.goToZoo();
    }

    private void givePoint(int point){

    }
}
