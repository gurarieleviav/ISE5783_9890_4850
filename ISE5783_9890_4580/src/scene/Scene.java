package scene;

import lighting.*;
import geometries.*;
import primitives.*;

/**
 * Scene class represents a scene
 */
public class Scene {
    public String name;
    public Color background;
    public AmbientLight ambientLight;
    public Geometries geometries = new Geometries();
    public Scene(String name) {
        this.name = name;
    }
    /**
     * Setter for the name of scene
     *
     * @param name the name
     */
    public Scene setName(String name) {
        this.name = name;
        return null;
    }
}