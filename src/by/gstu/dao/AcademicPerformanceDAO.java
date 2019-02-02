package by.gstu.dao;

import by.gstu.entities.AcademicPerformance;

import java.util.List;

public interface AcademicPerformanceDAO {
    boolean insert(AcademicPerformance ap);
    boolean update(AcademicPerformance ap);
    boolean delete(AcademicPerformance ap);
    AcademicPerformance findAcademicPerformance(int id);
    List<AcademicPerformance> getAllAcademicPerformance();
}
