package ru.job4j.tracker;

class Base {

  public void print() {
  System.out.println("1");
}
}

    class Child extends Base{
        @Override
        public void print() {
            System.out.println("2");
        }

        public static void main (String[] args) {
           Base obj = new Child ();
           // Child obj = new Child ();
            obj.print();
        }
    }

