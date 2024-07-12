package org.example.tp_spring.service;

import lombok.AllArgsConstructor;
import org.example.tp_spring.dto.candidate.CandidateDtoGet;
import org.example.tp_spring.dto.candidate.CandidateDtoPost;
import org.example.tp_spring.entity.Candidate;
import org.example.tp_spring.exception.NotFoundException;
import org.example.tp_spring.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CandidateService implements BaseService<CandidateDtoPost, CandidateDtoGet>{
    private final CandidateRepository candidateRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public CandidateDtoGet create(CandidateDtoPost candidateDtoPost) {
        Candidate candidate = Candidate.builder()
                .name(candidateDtoPost.getName())
                .identificationNumber(candidateDtoPost.getIdentificationNumber())
                .address(candidateDtoPost.getAddress())
                .phone(candidateDtoPost.getPhone())
                .email(candidateDtoPost.getEmail())
                .birthDate(LocalDate.parse(candidateDtoPost.getBirthDateStr(), dateFormatter))
                .rating(candidateDtoPost.getRating())
                .observation(candidateDtoPost.getObservation())
                .skill(candidateDtoPost.getSkill())
                .technicalArea(candidateDtoPost.getTechnicalArea())
                .jobInterviewDate(LocalDate.parse(candidateDtoPost.getJobInterviewDateStr(), dateFormatter))
                .build();

        candidateRepository.save(candidate);
        return candidateToCandidateDtoGet(candidate);
    }

    @Override
    public CandidateDtoGet update(int id, CandidateDtoPost candidateDtoPost) {
        Candidate candidate = getById(id);
        candidate.setName(candidateDtoPost.getName());
        candidate.setIdentificationNumber(candidateDtoPost.getIdentificationNumber());
        candidate.setAddress(candidateDtoPost.getAddress());
        candidate.setPhone(candidateDtoPost.getPhone());
        candidate.setEmail(candidateDtoPost.getEmail());
        candidate.setBirthDate(LocalDate.parse(candidateDtoPost.getBirthDateStr(), dateFormatter));
        candidate.setRating(candidateDtoPost.getRating());
        candidate.setObservation(candidateDtoPost.getObservation());
        candidate.setSkill(candidateDtoPost.getSkill());
        candidate.setTechnicalArea(candidateDtoPost.getTechnicalArea());
        candidate.setJobInterviewDate(LocalDate.parse(candidateDtoPost.getJobInterviewDateStr(), dateFormatter));

        candidateRepository.save(candidate);
        return candidateToCandidateDtoGet(candidate);
    }

    @Override
    public boolean delete(int id) {
        Candidate candidate = getById(id);
        candidateRepository.delete(candidate);
        return true;
    }

    @Override
    public CandidateDtoGet findById(int id) {
        return candidateToCandidateDtoGet(getById(id));
    }

    @Override
    public List<CandidateDtoGet> findAll() {
        return candidatesToCandidateDtoGets((List<Candidate>) candidateRepository.findAll());
    }

    private Candidate getById(Integer id) {
        return candidateRepository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
    }

    private CandidateDtoGet candidateToCandidateDtoGet(Candidate candidate) {
        return CandidateDtoGet.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .identificationNumber(candidate.getIdentificationNumber())
                .address(candidate.getAddress())
                .phone(candidate.getPhone())
                .email(candidate.getEmail())
                .birthDate(candidate.getBirthDate())
                .rating(candidate.getRating())
                .observation(candidate.getObservation())
                .skill(candidate.getSkill())
                .technicalArea(candidate.getTechnicalArea())
                .jobInterviewDate(candidate.getJobInterviewDate())
                .build();
    }

    private List<CandidateDtoGet> candidatesToCandidateDtoGets(List<Candidate> candidates) {
        return candidates.stream().map(this::candidateToCandidateDtoGet).collect(Collectors.toList());
    }
}
