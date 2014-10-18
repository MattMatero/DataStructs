import java.util.Comparator;

/**
 * Write a description of interface List here.
 * 
 * @author Cliff Shaffer, with minor modifications by Stephen Bloch
 * @version Oct. 7, 2013
 */
public interface MList<E> extends Makeable<MList<E>>
{
    /** delete all alements. */
    public void clear ();
    
    /** insert element just before current position.
     * If current position is past end of list, equivalent to append(item).
     * After insertion, current refers to the just-inserted item.
     */
    public void insert (E item);
    
    /** append element at end of list.
        After appending, current refers to the just-appended item.*/
    public void append (E item);
    
    /** Remove current element and return it.
     *  If list is empty, or if "current position" is outside list,
     *  Shaffer returns null. 
        After removing, current refers to the item just AFTER the
        one that we just removed.  */
    public E remove();
    
    /** Make "current position" refer to first element. 
        What happens if list is empty? 
        Shaffer doesn't say, but I infer that "current position"
        refers to just past the last element. */
    public void moveToStart();
    
    /** Make "current position" refer to just past last element. */
    public void moveToEnd();
    
    /** Move "current position" one step closer to beginning;
     *  no change if already at first element (or empty?).
     */
    public void prev();
    
    /** Move "current position" one step closer to end;
     * no change if already past last element (or empty?).
     */
    public void next();
    
    /** get number of elements in list. */
    public int length();
    
    /** get number of elements before "current position" */
    public int currPos();
    
    /** Move "current position" so there are the specified number
     * of elements before it.  moveToPos(0) is equivalent to moveToStart().
     */
    public void moveToPos (int pos) throws IndexOutOfBoundsException;
    
    /** Get value at current position. */
    public E getValue() throws IndexOutOfBoundsException;
    
    /** Does the "current position" refer to an actual element?
     * (As opposed to being past the end of the list, or the list
     * being empty)
     */
    public boolean currentElementExists ();
    
    /**
     * Display the list in a nice readable form, e.g.
     * "[red, <<green>>, blue]" for a list with elements "red", "green",
     * and "blue", of which "green" is the current element.
     */
    public String toString();
    
    /**
     * Sorts the list from smallest to largest using a comparator
     */
    public void sort(Comparator<E> order);
}
