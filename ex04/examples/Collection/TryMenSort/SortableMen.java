class SortableMen implements Comparable<SortableMen> {
  private String name;
  private Integer age;

  public SortableMen (String n, Integer a) {
    name = n;
    age = a;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String toString() {
    return new StringBuffer(128).append("Name: ").append(name).append(", Age: ").append(age.toString()).toString();
  }

  public void setName(String n) {
   name = n;
  }

  public void setAge(Integer a) {
    age = a;
  }

  public int compareTo(SortableMen v) {
    int result;
    result = name.compareTo(v.getName());
    return result == 0 ? age.compareTo(v.getAge()) : result ;
  }

}
