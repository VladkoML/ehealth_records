package org.diploma.dao;

import org.diploma.entity.Record;
import org.diploma.entity.Vaccination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VaccinationsDAOImpl implements CrudDAO<Vaccination>{

    private Connection connection;

    private static final String SQL_SAVE_VACCINATION =
            "INSERT INTO vaccinations (" +
                    "vaccine_name, " +
                    "address_of_build, " +
                    "reaction, " +
                    "vaccinated, " +
                    "patient_id) " +
                    "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_ALL_RECORDS =
            "SELECT * FROM vaccinations WHERE patient_id=? ORDER BY vaccination_id DESC";

    @Override
    public Vaccination find(Integer id) {
        return null;
    }

    @Override
    public int save(Vaccination vaccination) {

        int status = 0;
        connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = null;

        try{

            preparedStatement = connection.prepareStatement(SQL_SAVE_VACCINATION);

            preparedStatement.setString(1, vaccination.getVaccineName());
            preparedStatement.setString(2, vaccination.getAddressOfBuild());
            preparedStatement.setString(3, vaccination.getReaction());
            preparedStatement.setObject(4, vaccination.getVaccinated());
            preparedStatement.setInt(5, vaccination.getPatient().getPatientId());

            status = preparedStatement.executeUpdate();

        } catch (SQLException e){
            throw new IllegalStateException(e);
        } finally {

            try{

                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();

            } catch (SQLException e){
                e.printStackTrace();
            }

        }

        return 0;

    }

    @Override
    public int update(Vaccination model) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public List<Vaccination> findAll(int id) {

        connection = ConnectionDB.getConnection();
        List<Vaccination> vaccinations = new ArrayList<>();
        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_RECORDS);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Vaccination vaccination = new Vaccination();
                vaccination.setVaccinationId(resultSet.getInt("vaccination_id"));
                vaccination.setVaccineName(resultSet.getString("vaccine_name"));
                vaccination.setReaction(resultSet.getString("reaction"));
                vaccination.setAddressOfBuild(resultSet.getString("address_of_build"));
                vaccination.setVaccinated(resultSet.getObject("vaccinated", LocalDate.class));

                vaccinations.add(vaccination);

            }

        } catch (SQLException e){
            throw new IllegalStateException(e);
        } finally {

            try{

                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        return vaccinations;

    }
}
