package com.AlbertAbuav.beans;

import com.AlbertAbuav.utils.DateUtils;

import java.util.Date;

public class Person {

        private int id;
        private String name;
        private String city;
        private Date birthday; // ==> Java.util.Date
        private Hobby hobby;

        public Person() {
        }

        public Person(String name, String city, Date birthday, Hobby hobby) {
                this.name = name;
                this.city = city;
                this.birthday = birthday;
                this.hobby = hobby;
        }

        public Person(int id, String name, String city, Date birthday, Hobby hobby) {
                this.id = id;
                this.name = name;
                this.city = city;
                this.birthday = birthday;
                this.hobby = hobby;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public Date getBirthday() {
                return birthday;
        }

        public void setBirthday(Date birthday) {
                this.birthday = birthday;
        }

        public Hobby getHobby() {
                return hobby;
        }

        public void setHobby(Hobby hobby) {
                this.hobby = hobby;
        }

        @Override
        public String toString() {
                return "Person{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", city='" + city + '\'' +
                        ", birthday=" + DateUtils.beautifyDate(birthday) +
                        ", hobby=" + hobby +
                        '}';
        }
}
