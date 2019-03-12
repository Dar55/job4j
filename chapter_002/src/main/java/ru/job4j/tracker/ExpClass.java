package ru.job4j.tracker;

class Base {

  private void print() {
  System.out.println("1");
}
}

    class Child{
        //@Override
        private void print() {
            System.out.println("2");
        }

        public static void main (String[] args) {
           // Base obj = new Child ();
            Child obj = new Child ();
            obj.print();
        }
    }

