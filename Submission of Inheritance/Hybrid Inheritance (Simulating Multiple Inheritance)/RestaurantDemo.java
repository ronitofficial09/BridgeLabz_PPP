interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " cooks delicious meals.");
    }
}

class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " serves food to customers.");
    }
}

public class RestaurantDemo {
    public static void main(String[] args) {
        Worker w1 = new Chef("Gordon", 101);
        Worker w2 = new Waiter("James", 102);

        w1.performDuties();
        w2.performDuties();
    }
}
