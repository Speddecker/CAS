package by.gstu.dao;

import by.gstu.entities.AcademicPerformance;

import java.util.List;

public interface AcademicPerformanceDAO {
    boolean insertAcademicPerformance(AcademicPerformance ap);
    boolean updateAcademicPerformance(AcademicPerformance ap);
    boolean deleteAcademicPerformance(AcademicPerformance ap);
    AcademicPerformance findAcademicPerformance(int id);
    List<AcademicPerformance> getAllAcademicPerformance();
}
