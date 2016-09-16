package Data;


public class User {
    public Integer id;
    public String name, email, surname, position;
    public Integer age, salary;

    public User(Integer id, String name, String email, String surname, String position, Integer age, Integer salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    public User(String name, String email, String surname, String position, Integer age, Integer salary) {
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age != null) {
            this.age = age;
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position != null) {
            this.position = position;
        }
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        if (salary != null) {
            this.salary = salary;
        }
    }
}
