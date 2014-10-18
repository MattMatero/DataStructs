
/**
 * Write a description of interface IList here.
 * 
 * @author Stephen Bloch
 * @version Oct. 7, 2013
 */
public interface IList<E> extends Makeable<IList<E>>
{
    /** delete all alements. */
    public IList clear ();
    
    /** insert element just before current position.
     * If current position is past end of list, equivalent to append(item).
     */
    public IList<E> insert (E item);
    
    /** append element at end of list. */
    public IList<E> append (E item);
    
    /** Remove current element.
     *  If list is empty, or if "current position" is outside list,
     *  throw exception. */
    public IList<E> remove() throws IndexOutOfBoundsException;
    
    /** Make "current position" refer to first element. 
        What happens if list is empty? 
        Shaffer doesn't say, but I infer that "current position"
        refers to just past the last element. */
    public IList<E> moveToStart();
    
    /** Make "current position" refer to just past last element. */
    public IList<E> moveToEnd();
    
    /** Move "current position" one step closer to beginning;
     *  no change if already at first element (or empty?).
     */
    public IList<E> prev();
    
    /** Move "current position" one step closer to end;
     * no change if already past last element (or empty?).
     */
    public IList<E> next();
    
    /** get number of elements in list. */
    public int length();
    
    /** get number of elements before "current position" */
    public int currPos();
    
    /** Move "current position" so there are the specified number
     * of elements before it.  moveToPos(0) is equivalent to moveToStart().
     */
    public IList<E> moveToPos (int pos) throws IndexOutOfBoundsException;
    
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
}
