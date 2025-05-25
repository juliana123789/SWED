public class Developer {
    private String name;
    private int age;
    private int workExperience;
    private String programmingLanguage;
    private double salary;

    //constructor
    public Developer(String name, int age, int workExperience, String programmingLanguage, double salary) {
        setName(name);
        setAge(age);
        setExperience(workExperience);
        setProgrammingLanguage(programmingLanguage);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name can not be null or empty.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 16 && age <= 100) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be between 16 and 100 years.");
        }
    }

    public int getExperience() {
        return workExperience;
    }

    public void setExperience(int workExperience) {
        if (workExperience >= 0) {
            this.workExperience = workExperience;
        } else {
            throw new IllegalArgumentException("Work experience can not be null or empty.");
        }
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        if (programmingLanguage != null && !programmingLanguage.trim().isEmpty()) {
            this.programmingLanguage = programmingLanguage;
        } else {
            throw new IllegalArgumentException("Programming language can not be null or empty.");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary can not be null or empty.");
        }
    }

    public static void main(String[] args) {
        try {
            Developer dev = new Developer("Juliana Grabowski", 21, 2, "Java", 1300);
            System.out.println("Developer:");
            System.out.println("Name: " + dev.getName());
            System.out.println("Age: " + dev.getAge());
            System.out.println("Work experience: " + dev.getExperience() + " years");
            System.out.println("Programming language: " + dev.getProgrammingLanguage());
            System.out.println("Salary: " + dev.getSalary() + " EUR");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}