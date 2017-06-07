package com.kovalenko.patterns.creational;

public class Student {
    private String firstName;
    private String secondName;
    private int mark;

    public static Builder getBuilder() {
        return new Student().new Builder();
    }

    public class Builder {

        public Builder firstName(String firstName) {
            Student.this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName) {
            Student.this.secondName = secondName;
            return this;
        }

        public Builder mark(int mark) {
            Student.this.mark = mark;
            return this;
        }

        public Student build() {
            return Student.this;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
