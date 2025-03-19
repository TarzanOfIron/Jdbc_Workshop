package se.lexicon.dao;

import com.mysql.cj.protocol.Resultset;
import se.lexicon.Database.DatabaseConnection;
import se.lexicon.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Represents the implementation of CityDao for interacting with the 'city' table in the database.
 */
public class CityDaoImpl implements CityDao {

    Connection connection = DatabaseConnection.getConnection();

    @Override
    public Optional<City> findById(int id) {
        String sql = "SELECT * FROM city WHERE ID = ?";
        Optional<City> cityToReturn = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeQuery();
            try (ResultSet resultSet = statement.getResultSet()) {
                if (resultSet.next()) {
                    cityToReturn = Optional.of(new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR during find city by id: " + e.getMessage());
            e.printStackTrace();
        }
        return cityToReturn;
    }

    @Override
    public List<City> findByCode(String code) {
        String sql = "SELECT * FROM city WHERE CountryCode = ?";
        ArrayList<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, code);
            statement.executeQuery();
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR during find by country code: " + e.getMessage());
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public List<City> findByName(String name) {
        String sql = "SELECT FROM city WHERE name = ?";
        LinkedList<City> cities = new LinkedList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeQuery();

            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR during find by name: " + e.getMessage());
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public List<City> findAll() {
        String sql = "SELECT * FROM city";
        LinkedList<City> cities = new LinkedList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")));
            }

        } catch (SQLException e) {
            System.out.println("ERROR during find all: " + e.getMessage());
            e.printStackTrace();
        }

        return cities;
    }

    @Override
    public City save(City city) {
        String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES (?,?,?,?) ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, city.getName());
            statement.setString(2, city.getCountryCode());
            statement.setString(3, city.getDistrict());
            statement.setInt(4, city.getPopulation());
            System.out.println("did not work");
        } catch (SQLException e) {
            System.out.println("ERROR during saving city: " + e.getMessage());
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void update(City city) {
        String sql = "UPDATE city SET " +
                "Name = ?, " +
                "CountryCode = ?, " +
                "District = ?, " +
                "population = ? " +
                "WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, city.getName());
            statement.setString(2, city.getCountryCode());
            statement.setString(3, city.getDistrict());
            statement.setInt(4, city.getPopulation());
            statement.setInt(5, city.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR during update city: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM city WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR during delete by id: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
