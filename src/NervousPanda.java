public class NervousPanda extends Panda {

    public void getScared(){
        if (pullThis != null){
            pullThis.releaseHands();
        }
    }
}
