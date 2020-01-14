package algorithms;

public interface AlgorithmsInterface extends Runnable {

    /**
     * @param delay set the given amount of delay in an animation
     */
    void setAnimationDelay(double delay);

    /**
     * @return return the current delay of the animation
     */
    double getAnimationDelay();
}
