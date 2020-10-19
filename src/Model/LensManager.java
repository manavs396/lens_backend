package Model;

import java.util.ArrayList;

/**
 *This class make the data structure for storage on lenses
 * and also add and retrieve the lens
 */
public class LensManager {

    private ArrayList<Lens> lens_list;

    public LensManager() {
        lens_list = new ArrayList<>();
    }

    public void add(Lens lens_inp) {
        lens_list.add(lens_inp);
    }

    public Lens get_retrieve(int lens_input) {
        if ((lens_input >= 0) && (lens_input < lens_list.size())) {
            return lens_list.get(lens_input);
        }
        throw new IllegalArgumentException("Index of lens is invalid!!");
    }
}
