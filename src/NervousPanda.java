public class NervousPanda extends Panda {

    public void scare(){
        if (pullThis != null){
            pullThis.releaseHands();
        }
    }
}
