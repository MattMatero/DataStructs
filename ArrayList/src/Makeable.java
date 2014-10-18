
/**
 * An interface for classes that support a couple of pseudoconstructors.
 * 
 * @author Stephen Bloch
 * @version Oct. 7, 2013
 */
public interface Makeable<T extends Makeable>
{
    public T makeEmpty();
}
