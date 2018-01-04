package com.kai;

/**
 * Created by FengKai on 2018/1/4.
 */
public class Main10 {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person p = personFactory.create("JCK","12");

        personFactory = (String name, String age) -> { return new Person(name,age); };

        personFactory = (name,age)->new Person(name,age);

        personFactory = new PersonFactory<Person>() {
            @Override
            public Person create(String name, String age) {
                return new Person(name,age);
            }
        };

        PersonFactory<Man> manPersonFactory = Man::new;
        Man m = manPersonFactory.create("MAN","23");

    }
}

interface PersonFactory<P extends Person> {
    P create(String name, String age);
    //P create();
}

class Man extends Person {

    Man(String name, String age) {
        super.age=age;
        super.name=name;
    }
}

class Person {
    String name, age;

    Person() {

    }

    Person(String name,String age){
        this.age=age;
        this.name=name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
