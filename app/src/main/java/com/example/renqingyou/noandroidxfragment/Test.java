package com.example.renqingyou.noandroidxfragment;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public enum Sex{
        MALE,FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public Sex getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int compareByAge(Test a, Test b){
        return a.birthday.compareTo(b.birthday);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String... args){
        Test[] persons = new Test[10];

//使用匿名类
        Arrays.sort(persons, new Comparator<Test>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public int compare(Test o1, Test o2) {
                return o1.birthday.compareTo(o2.birthday);
            }
        });

//使用lambda表达式
        Arrays.sort(persons, (o1, o2) -> o1.birthday.compareTo(o2.birthday));

//使用lambda表达式和类的静态方法
        Arrays.sort(persons, (o1, o2) -> Test.compareByAge(o1,o2));

//使用方法引用
//引用的是类的静态方法
        Arrays.sort(persons, Test::compareByAge);


        ComparisonProvider provider = new ComparisonProvider();

//使用lambda表达式
//对象的实例方法
        Arrays.sort(persons,(a,b)->provider.compareByAge(a,b));

//使用方法引用
//引用的是对象的实例方法
        Arrays.sort(persons, provider::compareByAge);
    }


    static class ComparisonProvider{
        public int compareByName(Test a, Test b){
            return a.getName().compareTo(b.getName());
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public int compareByAge(Test a, Test b){
            return a.getBirthday().compareTo(b.getBirthday());
        }
    }

    public void a(View v) {

    }


}
