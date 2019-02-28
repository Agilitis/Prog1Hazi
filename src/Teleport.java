public class Teleport extends  Field {


    @Override
    public void acceptAnimal(Animal animal){
        neighBours[0].acceptAnimal(animal);
    }
}
