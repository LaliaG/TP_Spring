package org.example.tp_spring.service;

import lombok.AllArgsConstructor;
import org.example.tp_spring.dto.absence.AbsenceDtoGet;
import org.example.tp_spring.dto.absence.AbsenceDtoPost;
import org.example.tp_spring.entity.Absence;
import org.example.tp_spring.exception.NotFoundException;
import org.example.tp_spring.repository.AbsenceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AbsenceService implements BaseService<AbsenceDtoPost, AbsenceDtoGet> {
    private final AbsenceRepository absenceRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public AbsenceDtoGet create(AbsenceDtoPost absenceDtoPost) {
    Absence absence = Absence.builder()
            .employeeId(absenceDtoPost.getEmployeeId())
            .absenceDate(LocalDate.parse(absenceDtoPost.getAbsenceDateStr(), dateFormatter))
            .build();

        absenceRepository.save(absence);
        return absenceToAbsenceDtoGet(absence);
}

@Override
public AbsenceDtoGet update(int id, AbsenceDtoPost absenceDtoPost) {
    Absence absence = getById(id);
    absence.setEmployeeId(absenceDtoPost.getEmployeeId());
    absence.setAbsenceDate(LocalDate.parse(absenceDtoPost.getAbsenceDateStr(), dateFormatter));

    absenceRepository.save(absence);
    return absenceToAbsenceDtoGet(absence);
}

@Override
public boolean delete(int id) {
    Absence absence = getById(id);
    absenceRepository.delete(absence);
    return true;
}

@Override
public AbsenceDtoGet findById(int id) {
    return absenceToAbsenceDtoGet(getById(id));
}

@Override
public List<AbsenceDtoGet> findAll() {
    return absencesToAbsenceDtoGets((List<Absence>) absenceRepository.findAll());
}

private Absence getById(Integer id) {
    return absenceRepository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
}

private AbsenceDtoGet absenceToAbsenceDtoGet(Absence absence) {
    return AbsenceDtoGet.builder()
            .absenceId(absence.getAbsenceId())
            .employeeId(absence.getEmployeeId())
            .absenceDate(absence.getAbsenceDate())
            .build();
}

private List<AbsenceDtoGet> absencesToAbsenceDtoGets(List<Absence> absences) {
    return absences.stream().map(this::absenceToAbsenceDtoGet).collect(Collectors.toList());
}
}
