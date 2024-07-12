package org.example.tp_spring.service;

import lombok.AllArgsConstructor;
import org.example.tp_spring.dto.vacation.VacationDtoGet;
import org.example.tp_spring.dto.vacation.VacationDtoPost;
import org.example.tp_spring.entity.Vacation;
import org.example.tp_spring.repository.VacationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class VacationService implements BaseService<VacationDtoPost, VacationDtoGet>{
    private final VacationRepository vacationRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public VacationDtoGet create(VacationDtoPost vacationDtoPost) {
        Vacation vacation = Vacation.builder()
                .employeeId(vacationDtoPost.getEmployeeId())
                .startDate(LocalDate.parse(vacationDtoPost.getStartDateStr(), dateFormatter))
                .endDate(LocalDate.parse(vacationDtoPost.getEndDateStr(), dateFormatter))
                .build();

        vacationRepository.save(vacation);
        return vacationToVacationDtoGet(vacation);
    }

    @Override
    public VacationDtoGet update(int id, VacationDtoPost vacationDtoPost) {
        Vacation vacation = getById(id);
        vacation.setEmployeeId(vacationDtoPost.getEmployeeId());
        vacation.setStartDate(LocalDate.parse(vacationDtoPost.getStartDateStr(), dateFormatter));
        vacation.setEndDate(LocalDate.parse(vacationDtoPost.getEndDateStr(), dateFormatter));

        vacationRepository.save(vacation);
        return vacationToVacationDtoGet(vacation);
    }

    @Override
    public boolean delete(int id) {
        Vacation vacation = getById(id);
        vacationRepository.delete(vacation);
        return true;
    }

    @Override
    public VacationDtoGet findById(int id) {
        return vacationToVacationDtoGet(getById(id));
    }

    @Override
    public List<VacationDtoGet> findAll() {
        return vacationsToVacationDtoGets((List<Vacation>) vacationRepository.findAll());
    }

    private Vacation getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
    }

    private VacationDtoGet vacationToVacationDtoGet(Vacation vacation) {
        return VacationDtoGet.builder()
                .id(vacation.getId())
                .employeeId(vacation.getEmployeeId())
                .startDate(vacation.getStartDate())
                .endDate(vacation.getEndDate())
                .build();
    }

    private List<VacationDtoGet> vacationsToVacationDtoGets(List<Vacation> vacations) {
        return vacations.stream().map(this::vacationToVacationDtoGet).collect(Collectors.toList());
    }
}
