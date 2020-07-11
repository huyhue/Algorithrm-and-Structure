package Assignment1;
public class NodeTrain {

    Train infoTrain;
    NodeTrain next;

    NodeTrain() {
        infoTrain = null;
        next = null;
    }

    NodeTrain(Train infoTrain, NodeTrain next) {
        this.infoTrain = infoTrain;
        this.next = next;
    }

    NodeTrain(Train infoTrain) {
        this(infoTrain, null);
    }
}
