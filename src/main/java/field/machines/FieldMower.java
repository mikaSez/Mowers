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

    private Coordinates lastPosition;
    private Mower machine;
    private Field field;

    public FieldMower(Mower machine, Field field){
        this.machine = machine;
        this.field = field;
    }

    /**
     * Advance the mower only if the next position is inside boundaries defined by the {@Field}
     * */
    public void advance() {
        lastPosition = new Coordinates(machine.getCoordinates());
        machine.advance();
        if(!field.InBounds(machine.getCoordinates())){
            machine.forceCoordinates(lastPosition);
        }
    }

    @Override
    public void right() {
        machine.right();
    }

    @Override
    public void left() {
        machine.left();
    }

    @Override
    public Alignment getAlignment() {
        return machine.getAlignment();
    }


    @Override
    public String toString(){
        return machine.toString();
    }
}
