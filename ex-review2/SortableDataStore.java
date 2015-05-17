class SortableDataStore implements Comparable<SortableDataStore> { 

  protected String productItem, noItem, orderInfo;

  public SortableDataStore() {
    // fill in the area
  }

  public SortableDataStore(String p, String n, String o) {
    // fill in the area
    this.productItem = p;
    this.noItem = n;
    this.orderInfo = o;
  }

  public String toString() {
    // fill in the area
    return new String(productItem + ", " + noItem + ", " + orderInfo) ;
  }

  public int compareTo(SortableDataStore s) {
    int res;
    res = productItem.compareTo(s.productItem);
    if ( res != 0 ) {
      return res;
    }
    res = noItem.compareTo(s.noItem);
    if ( res != 0 ) {
      return res;
    }
    return 0;
  }

} // end of DataStore
