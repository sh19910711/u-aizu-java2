public int size()
public boolean isEmpty()
public boolean contains(Object elem)
public Iterator<E> iterator()
public Object[] toArray()
public <T> T[] toArray(T[] dest)
public boolean add(E elem)
public boolean remove(Object elem)

String[] strings = new String[collection.size()];
strings = collection.toArray(strings);

String[] strings = collection.toArray(new String[0]);

public boolean containsAll(Collection<?> coll)
public boolean addAll(Collection<? extends E> coll)
public boolean removeAll(Collection<?> coll)
public boolean retainAll(Collection<?> coll)
public void clear()
