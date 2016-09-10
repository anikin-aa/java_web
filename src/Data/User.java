package Data;

public class User {
    public Integer id;
    public String Name, Email, Surname, Position;
    public Integer age, passNumb, passSeries, salary;

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Integer getPassNumb() {
        return passNumb;
    }

    public void setPassNumb(Integer passNumb) {
        this.passNumb = passNumb;
    }

    public Integer getPassSeries() {
        return passSeries;
    }

    public void setPassSeries(Integer passSeries) {
        this.passSeries = passSeries;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public User(Integer id, String name, String email, String surname, String position, Integer age, Integer passNumb, Integer passSeries, Integer salary) {
        this.id = id;
        Name = name;
        Email = email;
        Surname = surname;
        Position = position;
        this.age = age;
        this.passNumb = passNumb;
        this.passSeries = passSeries;
        this.salary = salary;
    }

    public User(String name, String email, String surname, String position, Integer age, Integer passNumb, Integer passSeries, Integer salary) {
        Name = name;
        Email = email;
        Surname = surname;
        Position = position;
        this.age = age;
        this.passNumb = passNumb;
        this.passSeries = passSeries;
        this.salary = salary;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getpassNumb() {
        return passNumb;
    }

    public void setpassNumb(Integer passNumb) {
        this.passNumb = passNumb;
    }

    public Integer getpassSeries() {
        return passSeries;
    }

    public void setpassSeries(Integer passSeries) {
        this.passSeries = passSeries;
    }

    @Override
    public String toString() {
        return "(" + "'" + Name + "','" + Surname + "','" + Email + "','" + Position + "','" + age + "','" + passSeries + "','" + passNumb + "','" + salary + "')";
    }
}
