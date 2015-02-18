

package drawable.fragmenttransition;

/**
 * This represents a sample data.
 */
public class Meat {

    public int resourceId;
    public String title;
    public String type;

    public Meat(int resourceId, String title, String type) {
        this.resourceId = resourceId;
        this.title = title;
        this.type = type;
    }

    public static final Meat[] MEATS = {
            new Meat(R.drawable.p1, "Ivan Sotirov","Skype"),
            new Meat(R.drawable.p2, "Vanq Stoeva","Skype"),
            new Meat(R.drawable.p3, "Kaloqn PS","Skype"),
            new Meat(R.drawable.p4, "Iskren","Messenger"),
            new Meat(R.drawable.p5, "Petar","Messenger"),
            new Meat(R.drawable.p6, "Pavel","Messenger"),
            new Meat(R.drawable.p7, "Ivanina","Messenger"),
            new Meat(R.drawable.p8, "Gosho","Messenger"),
            new Meat(R.drawable.p9, "Mitaka","Hangout"),
            new Meat(R.drawable.p10, "Vasko","Hangout"),
            new Meat(R.drawable.p11, "Plamena","Hangout"),
    };

}
