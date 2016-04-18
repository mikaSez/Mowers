package field.machines;


import position.Alignment;
import position.Coordinates;
import field.Field;

/**
 * A mower strongly bounded to a field. <br/>
 * It can operate only inside a field.
 *
 */
public class FieldMower implements Machine{

    private final Mower mower;
    private final Field field;

    public FieldMower(Mower mower, Field field){
        this.mower = mower;
        this.field = field;
    }

    /**
     * Advance the mower only if the next position is inside boundaries defined by the {@link Field}
     * */
    public void advance() {
        Coordinates lastPosition = new Coordinates(mower.getCoordinates());
        mower.advance();
        if(!field.InBounds(mower.getCoordinates())){
            mower.forceCoordinates(lastPosition);
        }
    }

    @Override
    public void right() {
        mower.right();
    }

    @Override
    public void left() {
        mower.left();
    }

    @Override
    public Alignment getAlignment() {
        return mower.getAlignment();
    }


    @Override
    public String toString(){
        return mower.toString();
    }
}
