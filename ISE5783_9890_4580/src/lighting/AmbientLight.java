package lighting;

import primitives.*;

/**
 * AmbientLight class represents ambient light in the image
 */
public class AmbientLight {
    Color intensity;

    /**
     * Constructor for AmbientLight
     *
     * @param iA light intensity
     * @param kA factor of how much the light reduces as distance grows
     */
    public AmbientLight(Color iA, Double3 kA) {
        this.intensity = new Color(iA.scale(kA).getColor());
    }
/**
 * Default constructor for AmbientLight
 * sets the background color as black
 */
}