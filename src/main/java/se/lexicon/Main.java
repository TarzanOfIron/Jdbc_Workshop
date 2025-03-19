package se.lexicon;

import se.lexicon.dao.CityDaoImpl;
import se.lexicon.model.City;

/**
 * Represents the entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Needs completion

        City city1 = new City(4083, "cityyy", "AFG", "Middle east", 1234);

        CityDaoImpl cityDao = new CityDaoImpl();
        System.out.println(cityDao.findById(1));
        System.out.println("=====================");

        cityDao.findByCode("AGF").forEach(System.out::println);
        System.out.println("=====================");
        //cityDao.findAll().forEach(System.out::println);

        System.out.println("=====================");
        System.out.println(cityDao.save(city1));

        System.out.println("=====================");
        cityDao.update(city1);
        //cityDao.findAll().forEach(System.out::println);

        System.out.println("=====================");
        cityDao.deleteById(city1.getId());
        cityDao.findAll().forEach(System.out::println);



    }
}
